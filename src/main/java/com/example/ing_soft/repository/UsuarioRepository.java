package com.example.ing_soft.repository;

import com.example.ing_soft.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.repository;


import java.util.Optional;

@repository

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
    Optional<Usuario> findUsuarioByNombre(String nombre);
}