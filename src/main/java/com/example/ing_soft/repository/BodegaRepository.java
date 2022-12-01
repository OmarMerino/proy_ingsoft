package com.example.ing_soft.repository;

import com.example.ing_soft.model.Bodega;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface BodegaRepository extends JpaRepository<Bodega, Integer>{
    Optional <Bodega> findBodegaByNombre(String nombre);    
    
}