package com.asj.examen.examenbackend.services;


import com.asj.examen.examenbackend.models.Producto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductoServiceImp implements ProductoService{

    //El Logger sirve para hacer un seguimiento de errores. Usamos el de la librería slf4j
    private Logger logger = LoggerFactory.getLogger(ProductoServiceImp.class);

    public ProductoServiceImp() {
        logger.info("Se inicializa ProductoServiceImp");
    }


    @Override
    public Producto altaNuevoProducto(Producto producto) throws Exception {
        return null;
    }

    @Override
    public Optional<Producto> buscarProductoPor(Long id) {
        return Optional.empty();
    }
}
