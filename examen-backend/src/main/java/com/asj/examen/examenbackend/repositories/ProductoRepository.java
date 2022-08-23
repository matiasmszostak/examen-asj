package com.asj.examen.examenbackend.repositories;

import com.asj.examen.examenbackend.models.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {


    Optional<Producto> findProductoByCategoria(String categoria);
    Optional<Producto> findProductoById(Long id);
    Optional<Producto> findProductoByNombre(String nombre);





}
