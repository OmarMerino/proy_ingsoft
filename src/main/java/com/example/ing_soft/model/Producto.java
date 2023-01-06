package com.example.ing_soft.model;




import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "precio")
    private int precio;
    @Column(name = "stock")
    private int stock;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "descripcion")
    private String descripcion;
    @ManyToOne
    @JoinTable(name = "id_existe")
    private Existe existe;
    
    @ManyToOne
    @JoinTable(name = "id_vendido")
    private Vendido vendido;

    @ManyToMany
    @JoinTable(name = "Pertenece", joinColumns = @JoinColumn(name = "id_producto"), inverseJoinColumns = @JoinColumn(name = "id_categoria"))
    private List<Categoria> categorias; 

    public Producto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /* public Existe getExiste() {
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
    } */

}
