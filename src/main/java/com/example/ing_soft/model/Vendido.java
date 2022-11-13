package com.example.ing_soft.model;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "vendido")
public class Vendido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_vendido;

 /*    // muchos vendidos forman una venta
    @ManyToOne
    @JoinColumn(name = "id_venta")
    private Venta venta;

    // un vendido contiene muchos productos
    @OneToMany
    @JoinColumn(name = "id_producto")
    private List<Producto> productos; */

    @Column(name = "cantidad")
    private int cantidad;

    public int getId_vendido() {
        return id_vendido;
    }

    public void setId_vendido(int id_vendido) {
        this.id_vendido = id_vendido;
    }

    /* public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    } */

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Vendido() {
    }

}
