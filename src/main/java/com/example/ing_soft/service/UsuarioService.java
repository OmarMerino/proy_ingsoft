package com.example.ing_soft.service;

import com.example.ing_soft.model.Usuario;
import com.example.ing_soft.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService{
    @Autowired
    private  UsuarioRepository usuarioRepository;

    public List<Usuario> findAllUsuarios(){
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> findUsuarioById(int id){
        return usuarioRepository.findById(id);
    }

    public boolean save (Usuario usuario){
        usuarioRepository.saveAndFlush(usuario);
        Optional<Usuario> usuarioOptional =usuarioRepository.findById(usuario.getId());
        return usuarioOptional.isPresent();


    }

    public boolean update(Usuario usuario){
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(usuario.getId());
        
        if(usuarioOptional.isPresent()){
            usuarioRepository.saveAndFlush(usuario);
            return true;
        }else{
            return false;
        }
    }

    public boolean changePassword(int id, String password){
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        
        if(usuarioOptional.isPresent()){

            usuarioOptional.get().setContraseña(password);
            
            usuarioRepository.saveAndFlush(usuarioOptional.get());

            return true;
        }else{
            return false;
        }
    }

    public boolean deleteUsuarioById(int id){
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        if(usuarioOptional.isPresent()){
            usuarioRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }

    public Usuario getUsuario() {
        return null;
    }
}