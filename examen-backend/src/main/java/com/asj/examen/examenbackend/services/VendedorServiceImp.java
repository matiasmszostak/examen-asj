package com.asj.examen.examenbackend.services;


import com.asj.examen.examenbackend.exceptions.vendedor.VendedorNoExisteException;
import com.asj.examen.examenbackend.exceptions.vendedor.VendedorYaExisteException;
import com.asj.examen.examenbackend.models.Vendedor;
import com.asj.examen.examenbackend.models.Venta;
import com.asj.examen.examenbackend.repositories.VendedorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendedorServiceImp implements VendedorService{

    //El Logger sirve para hacer un seguimiento de errores. Usamos el de la librería slf4j
    private Logger logger = LoggerFactory.getLogger(VendedorServiceImp.class);

    public VendedorServiceImp() {
        logger.info("Se inicializa VendedorServiceImp");
    }




    @Autowired
    private VendedorRepository vendedorRepository;



    @Override
    public Vendedor altaNuevoVendedor(Vendedor vendedor) throws Exception {

        if (vendedor != null) {
      //      if (vendedor.getId() != null) {
                if (this.vendedorRepository.findById(vendedor.getId()).isPresent()) {
                    throw new VendedorYaExisteException("Ya existe vendedor con id " + vendedor.getId());
                }
    //        }
            vendedor.setComision(0.0);
            vendedor.setSueldoTotal(vendedor.getSueldoBasico() + vendedor.getComision());
            return this.vendedorRepository.save(vendedor);
        } else {
            return null;
        }

    }

    @Override
    public Optional<Vendedor> buscarVendedorPor(Long id) throws VendedorNoExisteException{
        return Optional.empty();
    }

    @Override
    public Optional<Vendedor> buscarVendedorPor(String nombre) throws VendedorNoExisteException{
        return Optional.empty();
    }


}

