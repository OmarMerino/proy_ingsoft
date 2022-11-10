package com.example.ing_soft.rest;

import com.example.ing_soft.service.CategoriaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.ing_soft.model.Categoria;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping (value ="categoria",produce ="application/json")
public class CategoriaRestController { 

    private class CategoriaService categoriaService;

    public CategoriaRestController( CategoriaService categoriaService){
        this.categoriaService=categoriaService;
    }

    @GetMapping(value="")
    public ResponseEntity<List<Categoria>> getAllCategoria (){
        List<Categoria> categoriaList= categoriaService.findAllCategoria();
        if(categoriaList.isEmpty()){
            return new ResponseEntity<>(categoriaList,HttpStatus.OK);        }
    }else { 
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value="/{idCategoria}")
    public ResponseEntity<Categoria> getCategoriaById (@PathVariable int idCategoria){
        Optional<Categoria> categoriaOptional= categoriaService.findCategoriaById(idCategoria);
        if(categoriaList.isPresent()){
            return new ResponseEntity<>(categoriaOptional.get(),HttpStatus.OK);
    }else { 
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
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
    public ResponseEntity<void> updateCategoria(@RequestBody Categoria categoria){
        boolean update = categoriaService.update(categoria);
        if(update){
            return new ResponseEntity<> (HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/{idCategoria}")
    public ResponseEntity<void> deletCategoriaById (@PathVariable int idCategoria){
        boolean delete = categoriaService.deletCategoriaById(idCategoria);
        if(delete){
            return new ResponseEntity<> (HttpStatus.OK);
        }else{
            return new ResponseEntity<> (HttpStatus.NOT_FOUND);
        }
    }

}