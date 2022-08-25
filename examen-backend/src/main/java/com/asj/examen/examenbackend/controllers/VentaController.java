package com.asj.examen.examenbackend.controllers;


import com.asj.examen.examenbackend.dto.VendedorDTO;
import com.asj.examen.examenbackend.dto.VentaDTO;
import com.asj.examen.examenbackend.exceptions.producto.ProductoNoExisteException;
import com.asj.examen.examenbackend.exceptions.vendedor.VendedorNuloException;
import com.asj.examen.examenbackend.exceptions.vendedor.VendedorYaExisteException;
import com.asj.examen.examenbackend.exceptions.venta.VentaNoExisteException;
import com.asj.examen.examenbackend.exceptions.venta.VentaNulaException;
import com.asj.examen.examenbackend.exceptions.venta.VentaYaExisteException;
import com.asj.examen.examenbackend.models.Producto;
import com.asj.examen.examenbackend.models.Vendedor;
import com.asj.examen.examenbackend.models.Venta;
import com.asj.examen.examenbackend.repositories.VentaRepository;
import com.asj.examen.examenbackend.services.VentaService;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ventas")
@CrossOrigin(origins = "http://localhost:4200/") //para conectar con el frontend sin problemas de CORS (seguridad)
public class VentaController {

    private Logger logger = LoggerFactory.getLogger(VentaController.class);

    private final VentaService ventaService;

    public VentaController(VentaService ventaService) {
        this.ventaService = ventaService;
    }

    @Autowired
    private VentaRepository ventaRepository;



    @PostMapping()
    public ResponseEntity<?> altaNuevaVenta(@RequestBody VentaDTO ventaDTO) {
        try{
            ObjectMapper om = new ObjectMapper();

            om.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);

            om.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

            Venta venta = om.convertValue(ventaDTO, Venta.class);

            Venta ventaEnDB = this.ventaService.altaNuevaVenta(venta);

            VentaDTO resultado = om.convertValue(ventaEnDB, VentaDTO.class);
            return ResponseEntity.ok(resultado);

        } catch (VentaYaExisteException e){
            logger.error("Error: Venta ya existe", e);
            return ResponseEntity.badRequest().body("Ya existe la venta. Detalle " + e.getMessage());
        }catch (VentaNulaException ventaNulaException){
            ventaNulaException.printStackTrace();
            return ResponseEntity.badRequest().body("La venta no puede ser nula");
        }catch (Exception e){
            logger.error("Error interno", e);
            return ResponseEntity.internalServerError().body("Error interno no identificado");
        }
    }


    @GetMapping()
    public List<Venta> listarTodasLasVentas(){
        return ventaRepository.findAll();
    }
    /*
    @GetMapping()
    public List<Venta> listarTodasLasVentas(){
        return (List<Venta>) this.ventaService.listarTodasLasVentas();
    }

*/

    /*
    @GetMapping(path = "/{idVenta}")
    public ResponseEntity<?> buscarProductoPorId(@PathVariable Long idVenta) throws VentaNoExisteException {
        return ResponseEntity.ok(this.ventaService
                .buscarVentaPor(idVenta)
                .orElse(null));
    }



*/
}
