package com.asj.examen.examenbackend.services;

import com.asj.examen.examenbackend.models.Vendedor;
import com.asj.examen.examenbackend.models.Venta;

import java.util.List;
import java.util.Optional;

public interface VendedorService {

    Vendedor altaNuevoVendedor(Vendedor vendedor) throws Exception;

    Optional<Vendedor> buscarVendedorPor(Long id);

    Optional<Vendedor> buscarVendedorPor(String nombre);

    Optional<Vendedor> aumentarComisionPorVentas(List<Venta> listaVentas); //Probar



}
