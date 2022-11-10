package com.example.ing_soft.model;

import java.util.List;

import javax.persistence.*;

@Entity
public class Producto {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY )
    private int id_producto;
    private int precio;
    private int stock;
    private String nombre_prod;
    private String descripcion;

    @ManyToOne
    @JoinTable(name="id_existe")
    private Existe existe;

    @ManyToOne
    @JoinTable(name="id_vendido")
    private Vendido vendido;


    
    @ManyToMany
    @JoinTable(name = "Pertenece", joinColumns = @JoinColumn(name = "id_producto"),
            inverseJoinColumns = @JoinColumn(name = "id_categoria"))
    private List<Categoria> categorias;



    public int getId_producto() {
        return id_producto;
    }



    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }



    public int getPrecio() {
        return precio;
    }



    public void setPrecio(int precio) {
        this.precio = precio;
    }



    public int getStock() {
        return stock;
    }



    public void setStock(int stock) {
        this.stock = stock;
    }



    public String getNombre_prod() {
        return nombre_prod;
    }



    public void setNombre_prod(String nombre_prod) {
        this.nombre_prod = nombre_prod;
    }



    public String getDescripcion() {
        return descripcion;
    }



    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }



    public Existe getExiste() {
        return existe;
    }



    public void setExiste(Existe existe) {
        this.existe = existe;
    }



    public Vendido getVendido() {
        return vendido;
    }



    public void setVendido(Vendido vendido) {
        this.vendido = vendido;
    }



    public List<Categoria> getCategorias() {
        return categorias;
    }



    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }




    
    

    
}
