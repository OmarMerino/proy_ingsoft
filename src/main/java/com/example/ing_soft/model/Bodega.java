package com.example.ing_soft.model;

import javax.persistence.*;
import javax.persistence.Id;

@Entity
@Table(name = "bodega")
public class Bodega {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(name = "ubicacion")
    String ubicacion;
    @Column(name = "nombre")
    String nombre;

   /*  @ManyToOne
    @JoinTable(name = "id")
    
    private Existe existe; */

    public Bodega() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /* public Existe getExiste() {
        return existe;
    }

    public void setExiste(Existe existe) {
        this.existe = existe;
    } */

}
