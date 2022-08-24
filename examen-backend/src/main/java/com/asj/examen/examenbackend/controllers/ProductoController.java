package com.asj.examen.examenbackend.controllers;

import com.asj.examen.examenbackend.dto.ProductoDTO;
import com.asj.examen.examenbackend.exceptions.producto.ProductoNuloException;
import com.asj.examen.examenbackend.exceptions.producto.ProductoYaExisteExcpetion;
import com.asj.examen.examenbackend.models.Producto;
import com.asj.examen.examenbackend.repositories.ProductoRepository;
import com.asj.examen.examenbackend.services.ProductoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
@CrossOrigin(origins = "http://localhost:4200/") //para conectar con el frontend sin problemas de CORS (seguridad)
public class ProductoController {

    private Logger logger = LoggerFactory.getLogger(ProductoController.class);



    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @Autowired
    private ProductoRepository productoRepository;


    @PostMapping()
    public ResponseEntity<?> altaNuevoProducto(@RequestBody ProductoDTO productoDTO) {
        try{
            ObjectMapper om = new ObjectMapper();

            Producto producto = om.convertValue(productoDTO, Producto.class);

            Producto productoEnDB = this.productoService.altaNuevoProducto(producto);

            ProductoDTO resultado = om.convertValue(productoEnDB, ProductoDTO.class);
            return ResponseEntity.ok(resultado);

        } catch (ProductoYaExisteExcpetion e){
            logger.error("Error: Producto ya existe", e);
            return ResponseEntity.badRequest().body("Ya existe el producto. Detalle " + e.getMessage());
        }catch (ProductoNuloException productoNuloException){
            productoNuloException.printStackTrace();
            return ResponseEntity.badRequest().body("El producto no puede ser nulo");
        }catch (Exception e){
            logger.error("Error interno", e);
            return ResponseEntity.internalServerError().body("Error interno no identificado");
        }
    }

    @GetMapping()
    public List<Producto> listarTodosLosProductos(){
        return productoRepository.findAll();
    }

    @GetMapping(path = "/{idProducto}")
    public ResponseEntity<Producto> buscarProductoPorId(@PathVariable Long idProducto) {
        return ResponseEntity.ok(this.productoService
                .buscarProductoPor(idProducto)
                .orElse(null));
    }


/*
    @GetMapping(path = "/{idProducto}")
    public ResponseEntity<?> buscarCliente(@PathVariable Long idProducto) {
        Optional<Producto> producto = this.productoService.buscarProductoPor(idProducto);
        if (producto != null) {
            return ResponseEntity.ok(producto);
        } else {
            return ResponseEntity.badRequest().body("El producto buscado no existe");
        }
    }

 */

    /*
        try{
            ObjectMapper om = new ObjectMapper();

            Producto producto = om.convertValue(productoDTO, Producto.class);

            Producto productoEnDB = this.productoService.buscarProductoPor(idProducto);

            ProductoDTO resultado = om.convertValue(productoEnDB, ProductoDTO.class);
            return ResponseEntity.ok(resultado);
*/






}
