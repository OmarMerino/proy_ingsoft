package com.example.ing_soft.model;

import java.util.List;

import javax.persistence.*;

@Entity
public class Vendido {

    
    @OneToMany
    @JoinColumn(name="id_venta")
    private List<Venta> ventas;
    
    @OneToMany
    @JoinColumn(name="id_producto")
    private List<Producto> productos;

    private int precio;

    public List<Venta> getVentas() {
        return ventas;
    }

    public void setVentas(List<Venta> ventas) {
        this.ventas = ventas;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    //private int cantidad;
    
}
