package com.example.ing_soft.model;

import java.util.List;

import javax.persistence.*;

@Entity
public class MetodoPago {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY )
    int id_pago;
    String nombre;
    String tipo;
    
    @OneToMany
    @JoinColumn(name="id_venta")
    List<Venta> ventas;
   
    public List<Venta> getVentas() {
        return ventas;
    }
    public void setVentas(List<Venta> ventas) {
        this.ventas = ventas;
    }
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
