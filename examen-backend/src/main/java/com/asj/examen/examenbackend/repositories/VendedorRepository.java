package com.asj.examen.examenbackend.repositories;


import com.asj.examen.examenbackend.models.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VendedorRepository  extends JpaRepository<Vendedor, Long> {

    Optional<Vendedor> findVendedorById(Long id);
    Optional<Vendedor> findVendedorByNombre(String nombre);

}


