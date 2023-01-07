package com.example.ing_soft.repository;

import com.example.ing_soft.model.Categoria;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;



public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
    Optional<Categoria> findCategoriaByNombre(String nombre);
}