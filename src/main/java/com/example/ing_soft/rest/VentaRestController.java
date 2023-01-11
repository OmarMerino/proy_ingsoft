package com.example.ing_soft.rest;

import com.example.ing_soft.service.VentaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.ing_soft.model.Venta;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping (value ="venta",produces ="application/json")
public class VentaRestController {
    
    @Autowired
    private VentaService ventaService;

    @GetMapping (value="")
    public ResponseEntity<List<Venta>> getAllVenta(){
        List<Venta> ventaList = ventaService.findAllVentas();
        if(!ventaList.isEmpty()){
            return new ResponseEntity<>(ventaList,HttpStatus.OK);
        } else {
            return new  ResponseEntity <>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping (value="/{id_venta}")
    public ResponseEntity<Venta> getVentabyId(@PathVariable int id_venta){
        Optional<Venta> ventaOptional = ventaService.findVentaById(id_venta);
        if(ventaOptional.isPresent()){
            return new ResponseEntity<>(ventaOptional.get(),HttpStatus.OK);
        } else {
            return new  ResponseEntity <>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping (value ="")
    public ResponseEntity<Void> addVenta (@RequestBody Venta venta){
        boolean create = ventaService.save(venta);
        if(create){
            return new ResponseEntity<>(HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping (value ="")
    public ResponseEntity<Void> updateVenta (@RequestBody Venta venta ){
        boolean update = ventaService.update(venta);
        if(update){
            return new ResponseEntity<> (HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping (value ="/{id_venta}")
    public ResponseEntity<Void> deleteVentaById(@PathVariable int id_venta){
        boolean delete = ventaService.deleteVentaById(id_venta);
        if(delete){
            return new ResponseEntity<> (HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value="metodoPago/{id_venta}/{id_pago}")
    public ResponseEntity<Void> seleccionarMetodoPago(@PathVariable int id_venta, @PathVariable int id_pago){

        boolean seleccionMetodo = ventaService.seleccionarMetodoPago(id_venta,id_pago);

        if(seleccionMetodo){
            return new ResponseEntity<> (HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
   
}