package com.example.ing_soft.rest;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ing_soft.model.Usuario;
import com.example.ing_soft.service.UsuarioService;

@RestController 
public class UsuarioRestController {
    private UsuarioService usuarioService;

    public UsuarioRestController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    // Crear Usuarios
    @PostMapping(value = " ")
    public ResponseEntity<Void> addUsuario(@RequestBody Usuario usuario){
        boolean creado = usuarioService.save(usuario);

        if(creado){
            return new ResponseEntity<>(HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    // Editar Usuarios
    @PutMapping (value = "")
    public ResponseEntity<Void> updateUsuario(@RequestBody Usuario usuario){
        boolean actualizado = usuarioService.update(usuario);
        if(actualizado){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    // Eliminar Usuarios segun RUT
    @DeleteMappping(value = "/{rut}")
    public ResponseEntity<Void> deleteUsuarioById(@PathVariable int rut){
        boolean eliminado = usuarioService.deleteUsuarioById(rut);
        if(eliminado){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Listar usuarios 
    @GetMapping(value = "/{rut}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable int rut){
        Optional<Usuario> usuarioOptional = usuarioService.findUsuarioById(rut);
        if (usuarioOptional.isPresent()){
            return new ResponseEntity<>(usuarioOptional.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
