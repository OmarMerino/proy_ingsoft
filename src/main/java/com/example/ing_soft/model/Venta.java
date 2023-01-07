package com.example.ing_soft.model;




import javax.persistence.*;

@Entity
@Table(name = "venta")
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "fecha")
    private String fecha;
    @Column(name = "descuento")
    private int descuento;
    @Column(name = "total")
    private int total;
    @ManyToOne
    @JoinColumn(name = "id_pago")
    private MetodoPago metodo_pago;
   /*  // usuario-venta
    @ManyToOne
    @JoinColumn(name = "rut")
    private Usuario usuario;
    // metodo pago-venta
    @ManyToOne
    @JoinColumn(name = "id_pago")
    private MetodoPago metodo_pago;
    // una venta esta en muchos vendido
    @OneToMany
    @JoinColumn(name = "id_vendido")
    private List<Vendido> vendidos; */

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getDescuento() {
        return descuento;//1%-100%
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

    public MetodoPago getMetodo_pago() {
        return metodo_pago;
    }

    public void setMetodo_pago(MetodoPago metodo_pago) {
        this.metodo_pago = metodo_pago;
    }

    /* public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    

    public List<Vendido> getVendidos() {
        return vendidos;
    }

    public void setVendidos(List<Vendido> vendidos) {
        this.vendidos = vendidos;
    } */

    public Venta() {
    }
}