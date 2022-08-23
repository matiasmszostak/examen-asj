package com.asj.examen.examenbackend.services;

import com.asj.examen.examenbackend.models.Vendedor;
import com.asj.examen.examenbackend.models.Venta;
import com.asj.examen.examenbackend.repositories.VentaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VentaServiceImp implements VentaService{



    //El Logger sirve para hacer un seguimiento de errores. Usamos el de la librería slf4j
    private Logger logger = LoggerFactory.getLogger(VentaServiceImp.class);

    public VentaServiceImp() {
        logger.info("Se inicializa VentaServiceImp");
    }



    @Autowired
    private VentaRepository ventaRepository;


    @Override
    public Venta altaNuevaVenta(Venta venta) throws Exception {
        return null;
    }

    @Override
    public Optional<Venta> buscarVentaPor(Long id) {
        return Optional.empty();
    }

}
