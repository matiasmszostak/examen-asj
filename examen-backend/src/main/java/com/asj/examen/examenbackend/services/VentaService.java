package com.asj.examen.examenbackend.services;


import com.asj.examen.examenbackend.models.Venta;

import java.util.Optional;

public interface VentaService {



    Venta altaNuevaVenta(Venta venta) throws Exception;

    Optional<Venta> buscarVentaPor(Long id);
}
