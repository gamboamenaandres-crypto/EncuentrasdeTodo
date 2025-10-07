package Models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tbl_factura")
public class Factura {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_factura")
    private int id_factura;

    @Column(name = "Total")
    private double total;

    @ManyToOne(cascade =CascadeType.ALL)
    @JoinColumn(name = "id_usuario")
    private Usuario id_usuario;




    public Factura() {
    }

    public Factura(double total, Usuario id_usuario) {
        this.total = total;
        this.id_usuario = id_usuario;
    }


    public int getId_factura() {
        return id_factura;
    }

    public void setId_factura(int id_factura) {
        this.id_factura = id_factura;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Usuario getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Usuario id_usuario) {
        this.id_usuario = id_usuario;
    }

    @Override
    public String toString() {
        return
                "id_factura=" + id_factura +
                ", total=" + total +
                ", Identificacion=" + id_usuario.getIdentificacion() +
                ", Nombre"+ id_usuario.getNombre_usuario()+
                ", Apellido"+ id_usuario.getApellido_usuario()+
                ", Telefono"+ id_usuario.getTelefono()+
                ' ';
    }
}
