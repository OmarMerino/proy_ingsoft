package com.example.ing_soft.model;

import java.util.List;

import javax.persistence.*;

@Entity
public class Vendido {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private int id_vendido;

    //muchos vendidos forman una venta
    @ManyToOne
    @JoinColumn(name="id_venta")
    private Venta venta;
    
    //un vendido contiene muchos productos
    @OneToMany
    @JoinColumn(name="id_producto")
    private List<Producto> productos;

    private int cantidad;

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    
    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
    

    
}
