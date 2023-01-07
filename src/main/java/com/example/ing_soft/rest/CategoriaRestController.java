package com.example.ing_soft.rest;

import com.example.ing_soft.service.CategoriaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.ing_soft.model.Categoria;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping (value ="categoria",produces ="application/json")
public class CategoriaRestController { 
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping(value="")
    public ResponseEntity<List<Categoria>> getAllCategorias(){
        List<Categoria> categoriaList= categoriaService.findAllCategoria();
        if(!categoriaList.isEmpty()) {
            return new ResponseEntity<>(categoriaList,HttpStatus.OK);        
        } else { 
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value="/{id_categoria}")
    public ResponseEntity<Categoria> getCategoriaById (@PathVariable int id_categoria){
        Optional<Categoria> categoriaOptional= categoriaService.findCategoriaById(id_categoria);
        if(categoriaOptional.isPresent()){
            return new ResponseEntity<>(categoriaOptional.get(),HttpStatus.OK);
        }else { 
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value="ByNombre/{nombre}")
    public ResponseEntity<Categoria> getCategoriaByNombre (@PathVariable String nombre){
        Optional<Categoria> categoriaOptional= categoriaService.findCategoriaByNombre(nombre);
        if(categoriaOptional.isPresent()){
            return new ResponseEntity<>(categoriaOptional.get(),HttpStatus.OK);
        }else { 
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "")
    public ResponseEntity<Void> addCategoria (@RequestBody Categoria categoria){
        boolean create = categoriaService.save(categoria);
        if(create){
            return new ResponseEntity<> (HttpStatus.CREATED);
        }else{
            return new ResponseEntity<> (HttpStatus.BAD_REQUEST);
        }
    }
    
    @PutMapping (value="")
    public ResponseEntity<Void> updateCategoria(@RequestBody Categoria categoria){
        boolean update = categoriaService.update(categoria);
        if(update){
            return new ResponseEntity<> (HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/{id_categoria}")
    public ResponseEntity<Void> deletCategoriaById (@PathVariable int id_categoria){
        boolean delete = categoriaService.deleteCategoriaById(id_categoria);
        if(delete){
            return new ResponseEntity<> (HttpStatus.OK);
        }else{
            return new ResponseEntity<> (HttpStatus.NOT_FOUND);
        }
    }
}