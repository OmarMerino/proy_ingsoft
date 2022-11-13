package com.example.ing_soft.repository;

import com.example.ing_soft.model.MetodoPago;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetodoPagoRepository extends JpaRepository<MetodoPago, Integer> {
    java.util.Optional<MetodoPago> findMetodoPagoByNombre(String nombre);
}