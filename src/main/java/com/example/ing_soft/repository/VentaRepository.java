package com.example.ing_soft.repository;
import com.example.ing_soft.model.Venta;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VentaRepository extends JpaRepository<Venta,Integer>{
    Optional<Venta> findVentaById(Integer idVenta);
}