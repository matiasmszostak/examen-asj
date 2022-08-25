package com.asj.examen.examenbackend.repositories;


import com.asj.examen.examenbackend.models.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Long> {

    Optional<Venta> findVentaById(Long id);

    @Query("select v from Venta v join fetch v.vendedor u where u.id = ?1")
    Iterable<Venta> findVentaByIdVendedor(Long id);
    // v es por Venta, u es por Vendedor


}
