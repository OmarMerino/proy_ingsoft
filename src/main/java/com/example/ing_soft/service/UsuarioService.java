package com.example.ing_soft.service;

import com.example.ing_soft.model.Usuario;
import com.example.ing_soft.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService{
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> findAllUsuarios(){
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> findUsuarioByRut(int rut){
        return usuarioRepository.findByRut(rut);
    }

    public boolean save (Usuario usuario){
        usuarioRepository.saveAndFlush(usuario);
        Optional<Usuario> usuarioOptional = usuarioRepository.findUsuarioByNombre(empleado.getNombre());
        return usuarioOptional.isPresent();
    }

    public boolean update(Usuario usuario){
        Optional<Usuario> usuarioOptional = usuarioRepository.findByRut(usuario.getRut());
        
        if(usuarioOptional.isPresent()){
            usuarioRepository.saveAndFlush(usuario);
            return true;
        }else{
            return false;
        }
    }

    public boolean deleteUsuarioByRut(int rut){
        Optional<Usuario> usuarioOptional = usuarioRepository.findByRut(rut);
        if(usuarioOptional.isPresent()){
            usuarioRepository.deleteByRut(rut);
            return true;
        }else{
            return false;
        }
    }
}