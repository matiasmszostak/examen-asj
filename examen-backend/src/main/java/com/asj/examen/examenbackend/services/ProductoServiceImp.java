package com.asj.examen.examenbackend.services;


import com.asj.examen.examenbackend.models.Producto;
import com.asj.examen.examenbackend.repositories.ProductoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductoServiceImp implements ProductoService{

    //El Logger sirve para hacer un seguimiento de errores. Usamos el de la librería slf4j.
    private Logger logger = LoggerFactory.getLogger(ProductoServiceImp.class);

    public ProductoServiceImp() {
        logger.info("Se inicializa ProductoServiceImp");
    }

    @Autowired
    private ProductoRepository productoRepositorio;



    @Override
    public Optional<Producto> buscarProductoPor(Long id) {
        Optional<Producto> producto = productoRepositorio.findProductoById(id);
        return producto;
    }

    @Override
    public Optional<Producto> buscarProductoPor(String nombre) {
        Optional<Producto> producto = productoRepositorio.findProductoByNombre(nombre);
        return producto;
    }



    @Override
    public Producto altaNuevoProducto(Producto producto) throws Exception {
        if(this.productoRepositorio
                .findProductoByNombre(producto.getNombre()).isPresent()){
            throw new Exception("El producto con el nombre "+ producto.getNombre() + ", ya existe");
        }
        return this.productoRepositorio.save(producto);
    }

}
