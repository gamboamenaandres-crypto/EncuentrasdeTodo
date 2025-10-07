package Models;


import javax.persistence.*;

@Entity
@Table(name = "tbl_productos")
public class Productos {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_producto")
    private int id_producto;


    @Column (name = "descripcion_producto")
    private String descripcion_producto;


    @Column(name = "precio")
    private double precio;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Id_estado")
    private Estados estado;

    @ManyToOne(fetch =FetchType.EAGER)
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;

    public Productos(){

    }

    public Productos(String descripcion_producto, double precio,Categoria categoria, Estados estado) {
        this.descripcion_producto = descripcion_producto;
        this.precio = precio;
        this.categoria = categoria;
        this.estado=estado;
    }


    public Estados getEstado() {
        return estado;
    }

    public void setEstado(Estados estado) {
        this.estado = estado;
    }

    public int getId_producto() {
        return id_producto;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getDescripcion_producto() {
        return descripcion_producto;
    }

    public void setDescripcion_producto(String descripcion_producto) {
        this.descripcion_producto = descripcion_producto;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Productos{" +
                "id_producto=" + id_producto +
                ", descripcion_producto='" + descripcion_producto + '\'' +
                ", precio=" + precio +
                ", categoria=" + (categoria.getNombre_categoria()) +
                ",estado= " +estado.getDes_estado()+
                '}';
    }
}
