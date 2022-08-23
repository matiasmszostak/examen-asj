package com.asj.examen.examenbackend.services;


import com.asj.examen.examenbackend.models.Vendedor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VendedorServiceImp implements VendedorService{

    //El Logger sirve para hacer un seguimiento de errores. Usamos el de la librería slf4j
    private Logger logger = LoggerFactory.getLogger(VendedorServiceImp.class);

    public VendedorServiceImp() {
        logger.info("Se inicializa VendedorServiceImp");
    }

    @Override
    public Vendedor altaNuevoVendedor(Vendedor vendedor) throws Exception {
        return null;
    }

    @Override
    public Optional<Vendedor> buscarVendedorPor(Long id) {
        return Optional.empty();
    }
}
