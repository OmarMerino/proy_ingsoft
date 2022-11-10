package com.example.ing_soft.repository;

import com.example.ing_soft.model.Categoria;
import org.springframework.data.japa.repository.JpaRepository;
import org.springframework.stereotype.repository;

import java.util.Optional;

@Repository
public interface CategoriaRepository extends JpaRepository <Venta,integer>{
    Optional<Categoria> findCategoriaById(Integer idCategoria);
}