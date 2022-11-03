package com.example.ing_soft.model;

import javax.persistence.*;

@Entity
public class Metodo_pago {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY )
    int id_pago;
    String nombre;
    String tipo;

    
    public int getId_pago() {
        return id_pago;
    }
    public void setId_pago(int id_pago) {
        this.id_pago = id_pago;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
}
