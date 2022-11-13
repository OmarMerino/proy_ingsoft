package com.example.ing_soft.rest;

import com.example.ing_soft.model.MetodoPago;
import com.example.ing_soft.service.MetodoPagoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "metodopago",produces = "application/json")
public class MetodoPagoRestController {
    @Autowired
    private MetodoPagoService metodopagoService;

    @GetMapping(value ="")
    public ResponseEntity<List<MetodoPago>> getAllMetodoPago(){
        List<MetodoPago> metodopagoList = metodopagoService.findAllMetodoPago();
        if(!metodopagoList.isEmpty()){
            return new ResponseEntity<>(metodopagoList, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "")
    public ResponseEntity<Void> addMetodoPago(@RequestBody MetodoPago metodopago){
        boolean creado = metodopagoService.save(metodopago);
        if(creado){
            return new ResponseEntity<>(HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    
    @PutMapping(value = "")
    public ResponseEntity<Void> updateMetodoPago(@RequestBody MetodoPago metodopago){
        boolean actualizado = metodopagoService.update(metodopago);
        if(actualizado){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/{id_pago}")
    public ResponseEntity<Void> deleteMetodoPagoById(@PathVariable int id_pago){
        boolean eliminado = metodopagoService.deleteMetodoPagoById(id_pago);
        if(eliminado){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
