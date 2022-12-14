package com.example.ing_soft.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ing_soft.model.Producto;
import com.example.ing_soft.repository.ProductoRepository;

@Service
public class ProductoService {
    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> findAllProductos(){
        return productoRepository.findAll();
    }

    public Optional<Producto> findProductoById(int id){
        return productoRepository.findById(id);
    }

    public boolean save(Producto producto){
        productoRepository.saveAndFlush(producto);
        Optional<Producto> productoOptional =productoRepository.findById(producto.getId());
        return productoOptional.isPresent();
    }

    public boolean update (Producto producto){
        Optional<Producto> productoOptional = productoRepository.findById(producto.getId());

        if(productoOptional.isPresent()){
            productoRepository.saveAndFlush(producto);
            return true;
        } else {
            return false;
        }
    }

    public boolean deleteProductoById(int id){
        Optional<Producto> productoOptional = productoRepository.findById(id);
        if(productoOptional.isPresent()){
            productoRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }
    
    public boolean modificarPrecioById(int id, int precio){


        Optional<Producto> productoOptional = productoRepository.findById(id);

        Producto producto =new Producto();
        
        if (productoOptional.isPresent()){

            producto.setId(id);
            producto.setNombre(productoOptional.get().getNombre());
            producto.setDescripcion(productoOptional.get().getDescripcion());
            producto.setStock(productoOptional.get().getStock());
            producto.setPrecio(precio);
            
            productoRepository.saveAndFlush(producto);
            return true;

        }else{

            return false;
        }

    }

    public boolean modificarDescripcionById(int id, String descripcion){
        Optional<Producto> productoOptional = productoRepository.findById(id);


        Producto producto =new Producto();
        
        
        if (productoOptional.isPresent()){

            producto.setId(id);
            producto.setNombre(productoOptional.get().getNombre());
            producto.setStock(productoOptional.get().getStock());
            producto.setPrecio(productoOptional.get().getPrecio());

            producto.setDescripcion(descripcion);
            
            productoRepository.saveAndFlush(producto);
            return true;

        }else{
            
            return false;
        }

    }
    
}