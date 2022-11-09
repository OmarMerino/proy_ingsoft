package com.example.ing_soft.model;

import java.util.List;

import javax.persistence.*;



@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY )
    private int rut;
    private String direccion;
    private String telefono;
    private String Correo;
    private String Contraseña;

    
    @OneToMany
    @JoinColumn(name="id_venta")
    private List<Venta> ventas;

    @ManyToMany
    @JoinTable(name = "tiene_permiso", joinColumns = @JoinColumn(name = "id_permiso"),
            inverseJoinColumns = @JoinColumn(name = "rut"))
    private List<Permiso> permisos;
    
    
    public int getRut() {
        return rut;
    }
    public void setRut(int rut) {
        this.rut = rut;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getCorreo() {
        return Correo;
    }
    public void setCorreo(String correo) {
        Correo = correo;
    }
    public String getContraseña() {
        return Contraseña;
    }
    public void setContraseña(String contraseña) {
        Contraseña = contraseña;
    }

}
