package com.example.ing_soft.model;

import javax.persistence.*;

@Entity
public class Venta {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY )
    int id_venta;
    String fecha;
    int descuento;
    int total;
    
    @ManyToOne
    @JoinColumn(name = "rut")
    private Usuario usuario;

    @ManyToOne                  
    @JoinColumn(name = "id_pago")
    private MetodoPago metodo_pago;



    
    public int getId_venta() {
        return id_venta;
    }




    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }
    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public int getDescuento() {
        return descuento;
    }
    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }
    public int getTotal() {
        return total;
    }
    public void setTotal(int total) {
        this.total = total;
    }
    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public MetodoPago getMetodo_pago() {
        return metodo_pago;
    }
    public void setMetodo_pago(MetodoPago metodo_pago) {
        this.metodo_pago = metodo_pago;
    }
    

}