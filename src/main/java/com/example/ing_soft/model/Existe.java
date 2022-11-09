package com.example.ing_soft.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Existe {

    @OneToMany
    @JoinColumn(name="id_bodega")
    private List<Bodega> bodegas;
    
    @OneToMany
    @JoinColumn(name="id_producto")
    private List<Producto> productos;

    private int stock_bod;

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
