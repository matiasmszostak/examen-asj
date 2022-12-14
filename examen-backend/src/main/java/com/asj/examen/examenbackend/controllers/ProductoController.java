package com.asj.examen.examenbackend.controllers;

import com.asj.examen.examenbackend.dto.ProductoDTO;
import com.asj.examen.examenbackend.exceptions.producto.ProductoNoExisteException;
import com.asj.examen.examenbackend.exceptions.producto.ProductoNuloException;
import com.asj.examen.examenbackend.exceptions.producto.ProductoYaExisteException;
import com.asj.examen.examenbackend.models.Producto;
import com.asj.examen.examenbackend.repositories.ProductoRepository;
import com.asj.examen.examenbackend.services.ProductoService;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
    @ApiOperation("Ingresar producto")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "Datos ingresados con algún error"),
            @ApiResponse(code = 500, message = "Error interno de sistema")
    })
    public ResponseEntity<?> altaNuevoProducto(@RequestBody ProductoDTO productoDTO) {
        try{
            ObjectMapper om = new ObjectMapper();

            om.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);

            om.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

            Producto producto = om.convertValue(productoDTO, Producto.class);

            Producto productoEnDB = this.productoService.altaNuevoProducto(producto);

            ProductoDTO resultado = om.convertValue(productoEnDB, ProductoDTO.class);
            return ResponseEntity.ok(resultado);

        } catch (ProductoYaExisteException e){
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
    @ApiOperation("Mostrar todos los productos")
    @ApiResponse(code = 200, message = "OK")
    public List<Producto> listarTodosLosProductos(){
        return productoRepository.findAll();
    }



    @GetMapping("/categoria/{categoria}")
    @ApiOperation("Mostrar todos los productos por categoría")
    @ApiResponse(code = 200, message = "OK")
    public List<Producto> listarProductosPorCategoria(@PathVariable String categoria) {
        return (List<Producto>) this.productoService.buscarProductoPor(categoria);
    }





    @GetMapping(path = "/{idProducto}")
    @ApiOperation("Mostrar producto por ID")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<Producto> buscarProductoPorId(@PathVariable Long idProducto) throws ProductoNoExisteException {
        return ResponseEntity.ok(this.productoService
                .buscarProductoPor(idProducto)
                .orElse(null));
    }




}
