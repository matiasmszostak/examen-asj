package com.asj.examen.examenbackend.services;


import com.asj.examen.examenbackend.exceptions.producto.ProductoNoExisteException;
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
            if (vendedor.getId() != null) {
                if (this.vendedorRepository.findById(vendedor.getId()).isPresent()) {
                    throw new VendedorYaExisteException("Ya existe el vendedor buscado");
                }
            }
            vendedor.setComision(0.0);
            vendedor.setSueldoTotal(vendedor.getSueldoBasico() + vendedor.getComision());
            return this.vendedorRepository.save(vendedor);
        } else {
            return null;
        }

    }

    @Override
    public Optional<Vendedor> buscarVendedorPor(Long id) throws VendedorNoExisteException {
        if (!this.vendedorRepository.findVendedorById(id).isPresent()) {
            throw new VendedorNoExisteException("El vendedor buscado no existe");
        } else {
            return this.vendedorRepository.findVendedorById(id);
        }
    }

    @Override
    public Optional<Vendedor> buscarVendedorPor(String nombre) throws VendedorNoExisteException{
        return Optional.empty();
    }





    @Override
    public Vendedor actualizarVendedor(Long id, Vendedor vendedorActualizado) throws VendedorNoExisteException {
        Optional<Vendedor> vendedorBuscado = this.vendedorRepository
                .findById(id);

        if (vendedorBuscado.isPresent()) {
            Vendedor vendedor = vendedorBuscado.get();

            vendedor.setComision(vendedorActualizado.getComision());
            vendedor.setSueldoTotal(vendedorActualizado.getSueldoTotal());

            return this.vendedorRepository.save(vendedor);
        } else {
            throw new VendedorNoExisteException("El vendedor buscado no existe");
        }
    }





}