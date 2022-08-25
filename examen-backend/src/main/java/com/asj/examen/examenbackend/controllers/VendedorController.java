package com.asj.examen.examenbackend.controllers;


import com.asj.examen.examenbackend.dto.VendedorDTO;
import com.asj.examen.examenbackend.exceptions.producto.ProductoNoExisteException;
import com.asj.examen.examenbackend.exceptions.vendedor.VendedorNoExisteException;
import com.asj.examen.examenbackend.exceptions.vendedor.VendedorNuloException;
import com.asj.examen.examenbackend.models.Producto;
import com.asj.examen.examenbackend.models.Vendedor;
import com.asj.examen.examenbackend.repositories.VendedorRepository;
import com.asj.examen.examenbackend.services.VendedorService;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.asj.examen.examenbackend.exceptions.vendedor.VendedorYaExisteException;

import java.util.List;


@RestController
@RequestMapping("/vendedores")
@CrossOrigin(origins = "http://localhost:4200/") //para conectar con el frontend sin problemas de CORS (seguridad)
public class VendedorController {


    private Logger logger = LoggerFactory.getLogger(VendedorController.class);


    private final VendedorService vendedorService;

    public VendedorController(VendedorService vendedorService) {
        this.vendedorService = vendedorService;
    }

    @Autowired
    private VendedorRepository vendedorRepository;


    @PostMapping()
    public ResponseEntity<?> altaNuevoVendedor(@RequestBody VendedorDTO vendedorDTO) {
        try{
            ObjectMapper om = new ObjectMapper();

            om.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);

            om.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

            Vendedor vendedor = om.convertValue(vendedorDTO, Vendedor.class);

            Vendedor vendedorEnDB = this.vendedorService.altaNuevoVendedor(vendedor);

            VendedorDTO resultado = om.convertValue(vendedorEnDB, VendedorDTO.class);
            return ResponseEntity.ok(resultado);

        } catch (VendedorYaExisteException e){
            logger.error("Error: Vendedor ya existe", e);
            return ResponseEntity.badRequest().body("Ya existe el vendedor. Detalle " + e.getMessage());
        }catch (VendedorNuloException vendedorNuloException){
            vendedorNuloException.printStackTrace();
            return ResponseEntity.badRequest().body("El vendedor no puede ser nulo");
        }catch (Exception e){
            logger.error("Error interno", e);
            return ResponseEntity.internalServerError().body("Error interno no identificado");
        }
    }


    @GetMapping()
    public List<Vendedor> listarTodosLosVendedores(){
        return vendedorRepository.findAll();
    }



    @GetMapping(path = "/{idVendedor}")
    public ResponseEntity<Vendedor> buscarVendedorPorId(@PathVariable Long idVendedor) throws VendedorNoExisteException {
        return ResponseEntity.ok(this.vendedorService
                .buscarVendedorPor(idVendedor)
                .orElse(null));
    }







}
