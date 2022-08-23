package com.asj.examen.examenbackend.services;

import com.asj.examen.examenbackend.models.Producto;

import java.util.Optional;


public interface ProductoService {

    Producto altaNuevoProducto(Producto producto) throws Exception;

    Optional<Producto> buscarProductoPor(Long id);


}
