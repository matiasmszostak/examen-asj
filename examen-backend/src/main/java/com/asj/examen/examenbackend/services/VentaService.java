package com.asj.examen.examenbackend.services;


import com.asj.examen.examenbackend.exceptions.producto.ProductoNoExisteException;
import com.asj.examen.examenbackend.exceptions.venta.VentaNoExisteException;
import com.asj.examen.examenbackend.models.Venta;

import java.util.Optional;

public interface VentaService {



    Venta altaNuevaVenta(Venta venta) throws Exception;

    Optional<Venta> buscarVentaPor(Long id) throws VentaNoExisteException;

    Iterable<Venta> listarTodasLasVentas();




/*
    Iterable<Venta> listarVentas();

* */
}