package com.example.ing_soft.rest;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ing_soft.model.Producto;
import com.example.ing_soft.service.ProductoService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping (value = "producto", produces ="application/json")
public class ProductoRestController {
    @Autowired
    private ProductoService productoService;


    @GetMapping(value = "/all")
    public ResponseEntity<List<Producto>> getAllProducto(){
        List<Producto> productoList = productoService.findAllProductos();
        if(!productoList.isEmpty()){
            return new ResponseEntity<> (productoList, HttpStatus.OK);
        }else{
            return new ResponseEntity<> (HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping (value = "")
    public ResponseEntity<Void> addProducto (@RequestBody Producto producto){
        boolean creado = productoService.save(producto);
        if(creado){
            return new ResponseEntity<>(HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping (value = "")
    public ResponseEntity<Void> updateProducto (@RequestBody Producto producto){
        boolean actualizado = productoService.update(producto);
        if(actualizado){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping (value = "/{id_producto}")
    public ResponseEntity<Void> deleteProductoById(@PathVariable int id_producto){
        boolean eliminado = productoService.deleteProductoById(id_producto);
        if(eliminado){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value="/{id_producto}")
    public ResponseEntity<Producto> getProductoById (@PathVariable int id_producto){
        Optional<Producto> productoOptional= productoService.findProductoById(id_producto);
        if(productoOptional.isPresent()){
            return new ResponseEntity<>(productoOptional.get(),HttpStatus.OK);
        }else { 
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    
    @PutMapping (value ="/{id_producto},{precio}")
    public ResponseEntity<Void> updatePrecioProducto (@PathVariable int id_producto,@PathVariable int precio){
        boolean actualizado = productoService.modificarPrecioById(id_producto, precio);

        if(actualizado){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    } 
    
}