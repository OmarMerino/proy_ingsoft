package com.example.ing_soft.model;

import javax.persistence.*;

@Entity
public class Permiso {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY )    
    private int id_permiso;
    private String nombre_permiso;
    
    public int getId_permiso() {
        return id_permiso;
    }
    public void setId_permiso(int id_permiso) {
        this.id_permiso = id_permiso;
    }
    public String getNombre_permiso() {
        return nombre_permiso;
    }
    public void setNombre_permiso(String nombre_permiso) {
        this.nombre_permiso = nombre_permiso;
    }
}
