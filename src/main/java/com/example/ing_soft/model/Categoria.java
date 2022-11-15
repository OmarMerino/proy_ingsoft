package com.example.ing_soft.model;

import javax.persistence.*;

import java.util.List;

@Entity
@Table(name = "categoria")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "nombre")
    private String nombre;

     /* @ManyToMany(mappedBy = "categorias")
    private List<Producto> productos; */

    public Categoria() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    

   

    /* public List<Producto> getProductos() {
        return productos;
    } */


    /* public void setProductos(List<Producto> productos) {
        this.productos = productos;
    } */

}
