package com.example.ing_soft.model;

import javax.persistence.*;

@Entity
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    int id_cagegoria;
    String nombre_cat;


    
    public int getId_cagegoria() {
        return id_cagegoria;
    }
    public void setId_cagegoria(int id_cagegoria) {
        this.id_cagegoria = id_cagegoria;
    }
    public String getNombre_cat() {
        return nombre_cat;
    }
    public void setNombre_cat(String nombre_cat) {
        this.nombre_cat = nombre_cat;
    }
    
}
