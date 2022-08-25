package com.asj.examen.examenbackend.services;

import com.asj.examen.examenbackend.exceptions.vendedor.VendedorNoExisteException;
import com.asj.examen.examenbackend.exceptions.vendedor.VendedorYaExisteException;
import com.asj.examen.examenbackend.models.Vendedor;
import com.asj.examen.examenbackend.models.Venta;

import java.util.List;
import java.util.Optional;

public interface VendedorService {

    Vendedor altaNuevoVendedor(Vendedor vendedor) throws Exception;

    Optional<Vendedor> buscarVendedorPor(Long id) throws VendedorNoExisteException;

    Optional<Vendedor> buscarVendedorPor(String nombre) throws VendedorNoExisteException;

    Vendedor actualizarVendedor(Long id, Vendedor vendedor) throws VendedorNoExisteException;



}