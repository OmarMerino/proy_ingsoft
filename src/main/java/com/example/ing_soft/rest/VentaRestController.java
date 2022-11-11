package com.example.ing_soft.rest;

import com.example.ing_soft.service.VentaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.ing_soft.model.Venta;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping (value ="venta",produces ="application/json")
public class VentaRestController {

    private VentaService ventaService;

    public VentaRestController (VentaService ventaService){
        this.ventaService = ventaService;
    }

    @GetMapping (value="")
    public ResponseEntity<List<Venta>> getAllVenta(){
        List<Venta> ventaList = ventaService.findAllVentas();
        if(!ventaList.isEmpty()){
            return new ResponseEntity<>(ventaList,HttpStatus.OK);
        } else {
            return new  ResponseEntity <>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping (value="/{idVenta}")
    public ResponseEntity<Venta> getVentabyId(@PathVariable int idVenta){
        Optional<Venta> ventaOptional = ventaService.findVentaById(idVenta);
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

    @DeleteMapping (value ="/{idVenta}")
    public ResponseEntity<Void> deleteVentaById(@PathVariable int idVenta){
        boolean delete = ventaService.deleteVentaById(idVenta);
        if(delete){
            return new ResponseEntity<> (HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
        

}