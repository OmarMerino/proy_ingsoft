package com.example.ing_soft.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Existe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_existe;

    @OneToMany
    @JoinColumn(name="id_bodega")
    private List<Bodega> bodegas;
    
    @OneToMany
    @JoinColumn(name="id_producto")
    private List<Producto> productos;

    private int stock_bod;

    public int getId_existe() {
        return id_existe;
    }

    public void setId_existe(int id_existe) {
        this.id_existe = id_existe;
    }

    public List<Bodega> getBodegas() {
        return bodegas;
    }

    public void setBodegas(List<Bodega> bodegas) {
        this.bodegas = bodegas;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public int getStock_bod() {
        return stock_bod;
    }

    public void setStock_bod(int stock_bod) {
        this.stock_bod = stock_bod;
    }

    
    
    
}
