package com.example.ing_soft.repository;

import com.example.ing_soft.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    Optional<Producto> findProductoByNombre(String nombre);
}