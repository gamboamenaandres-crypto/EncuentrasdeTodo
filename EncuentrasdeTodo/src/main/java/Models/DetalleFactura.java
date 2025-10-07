package Models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tbl_detalles_factura")
public class DetalleFactura {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_detalles_factura")
    private int id_detallesfactura;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_factura")
    private Factura factura;

    @ManyToOne(fetch = FetchType.EAGER) // EAGER opcional, pero ayuda a evitar LazyInitializationException
    @JoinColumn(name = "id_producto")
    private Productos producto;

    @Column(name = "Cantidad")
    private int cantidad;

    @Column(name = "Total")
    private double Total;


    public DetalleFactura() {
    }

    public DetalleFactura(Factura factura, Productos producto, int cantidad, double total) {
        this.factura = factura;
        this.producto = producto;
        this.cantidad = cantidad;
        this.Total = total;

    }



    public double getTotal() {
        return Total;
    }

    public void setTotal(int total) {
        Total = total;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getId_detallesfactura() {
        return id_detallesfactura;
    }

    public void setId_detallesfactura(int id_detallesfactura) {
        this.id_detallesfactura = id_detallesfactura;
    }

    public Productos getProductos() {
        return producto;
    }

    public void setProductos(Productos productos) {
        this.producto = productos;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    @Override
    public String toString() {
        return "DetalleFactura{" +
                "id_detallesfactura=" + id_detallesfactura +
                ", productos=" + producto +
                ", factura=" + factura +
                ", SubTotal=" + Total +
                '}';
    }


}
