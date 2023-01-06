package com.example.ing_soft.repository;

import com.example.ing_soft.model.MetodoPago;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;



public interface MetodoPagoRepository extends JpaRepository<MetodoPago, Integer> {
    java.util.Optional<MetodoPago> findMetodoPagoByNombre(String nombre);
    Optional <MetodoPago> findById(Integer id_pago);
}