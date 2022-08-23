package com.asj.examen.examenbackend.repositories;


import com.asj.examen.examenbackend.models.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Long> {

    Optional<Venta> findVentaById(Long id);

}
