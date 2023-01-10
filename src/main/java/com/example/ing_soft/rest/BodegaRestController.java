package com.example.ing_soft.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.ing_soft.model.Bodega;
import com.example.ing_soft.service.BodegaService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping (value = "bodega", produces ="application/json")
public class BodegaRestController {
    @Autowired
    private BodegaService bodegaService;


    @GetMapping(value = "/all")
    public ResponseEntity<List<Bodega>> getAllBodegas(){
        List<Bodega> bodegaList = bodegaService.findAllBodegas();
        if(!bodegaList.isEmpty()){
            return new ResponseEntity<> (bodegaList, HttpStatus.OK);
        }else{
            return new ResponseEntity<> (HttpStatus.NOT_FOUND);
        }
    }
 
    @GetMapping(value="/{nombre}")
    public ResponseEntity<Bodega> getBodegaByNombre (@PathVariable String nombre){

        
        Optional<Bodega> bodegaOptional= bodegaService.findByNombre(nombre);

        if(bodegaOptional.isPresent()){
            return new ResponseEntity<>(bodegaOptional.get(),HttpStatus.OK);
        }else { 
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    

    @PostMapping (value = "")
    public ResponseEntity<Void> addBodega (@RequestBody Bodega bodega){
        boolean creado = bodegaService.save(bodega);
        if(creado){
            return new ResponseEntity<>(HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping (value = "")
    public ResponseEntity<Void> updateBodega (@RequestBody Bodega bodega){
        boolean actualizado = bodegaService.update(bodega);
        if(actualizado){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping (value = "/{id_bodega}")
    public ResponseEntity<Void> deleteBodegaById(@PathVariable int id_bodega){
        boolean eliminado = bodegaService.deleteBodegaById(id_bodega);
        if(eliminado){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping (value = "/ubicacion/{ubicacion}/{bodega}")
    public ResponseEntity<Void> updateUbicacionBodega(@PathVariable String ubicacion,@PathVariable String bodega){
        boolean actualizado = bodegaService.cambiarUbicacion(ubicacion,bodega);
        if(actualizado){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    //buscar bodega by id
    @GetMapping(value="ById/{id_bodega}")
    public ResponseEntity<Bodega> getBodegaById (@PathVariable int id_bodega){

        
        Optional<Bodega> bodegaOptional= bodegaService.findBodegaById(id_bodega);

        if(bodegaOptional.isPresent()){
            return new ResponseEntity<>(bodegaOptional.get(),HttpStatus.OK);
        }else { 
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}