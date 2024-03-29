package com.example.ing_soft.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ing_soft.model.Usuario;
import com.example.ing_soft.service.UsuarioService;

@RestController 
@RequestMapping (value = "usuario", produces = "application/json")
public class UsuarioRestController {
    @Autowired
    private UsuarioService usuarioService;

    // Crear Usuarios
    @PostMapping(value = "")
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

    // Eliminar Usuarios segun ID
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteUsuarioById(@PathVariable int id){
        boolean eliminado = usuarioService.deleteUsuarioById(id);

        if(eliminado){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Listar usuarios 
    @GetMapping(value = "" )
    public ResponseEntity<List<Usuario>> getAllUsuarios(){
        List<Usuario> usuarioList = usuarioService.findAllUsuarios();
        if(!usuarioList.isEmpty()) {
            return new ResponseEntity<>(usuarioList, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

     // Listar usuarios por ID
     @GetMapping(value = "/{id}")
     public ResponseEntity<Usuario> getUsuarioById(@PathVariable int id) {
         Optional<Usuario> usuarioOptional = usuarioService.findUsuarioById(id);
         if(usuarioOptional.isPresent()){
             return new ResponseEntity<>(usuarioOptional.get(), HttpStatus.OK);
         }else{
             return new ResponseEntity<>(HttpStatus.NOT_FOUND);
         }
     }
     
     //editar contraseña de un usuario 
    
    @PutMapping (value = "/{id}/{pass}")
    public ResponseEntity<Void> changePassword(@PathVariable int id, @PathVariable String pass){
        boolean actualizado = usuarioService.changePassword(id, pass);
        if(actualizado){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}