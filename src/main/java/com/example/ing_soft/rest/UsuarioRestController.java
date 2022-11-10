package com.example.ing_soft.rest;

import java.util.Optional;
import java.util.List;

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
        boolean actualizado = usuarioService.update(empleado);
        if(actualizado){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    // Eliminar Usuarios segun RUT
    @DeleteMappping(value = "/{rut}")
    public ResponseEntity<Void> deleteUsuarioByRut(@PathVariable int rut){
        boolean eliminado = usuarioService.deleteUsuarioByRut(rut);
        if(eliminado){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/{rut}")
    public ResponseEntity<Usuario> getUsuarioByRut(@PathVariable int rut){
        Optional<Usuario> usuarioOptional = usuarioService.findUsuarioByRut(rut);
        if (usuarioOptional.isPresent()){
            return new ResponseEntity<>(empleadoOptional.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
