package com.example.ing_soft.repository;

import com.example.ing_soft.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface CategoriaRepository extends JpaRepository <Categoria, Integer>{
    Optional<Categoria> findCategoriaById(Integer id_categoria);
}