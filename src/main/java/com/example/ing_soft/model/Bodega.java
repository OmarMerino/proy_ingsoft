package com.example.ing_soft.model;


import java.util.List;

import javax.persistence.*;
import javax.persistence.Id;



@Entity
public class Bodega {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    int id_bodega;
    String ubicacion;
    String nombre_bod;

    @ManyToMany(mappedBy = "bodegas")
    private List<Producto> productos;

    public List<Producto> getProductos() {
        return productos;
    }
    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
    public int getId_bodega() {
        return id_bodega;
    }
    public void setId_bodega(int id_bodega) {
        this.id_bodega = id_bodega;
    }
    public String getUbicacion() {
        return ubicacion;
    }
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
    public String getNombre_bod() {
        return nombre_bod;
    }
    public void setNombre_bod(String nombre_bod) {
        this.nombre_bod = nombre_bod;
    }
    
    
}
