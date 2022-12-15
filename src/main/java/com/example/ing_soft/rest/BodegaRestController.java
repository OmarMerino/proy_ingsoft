package com.example.ing_soft.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.ing_soft.model.Bodega;
import com.example.ing_soft.service.BodegaService;

import java.util.List;

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
}