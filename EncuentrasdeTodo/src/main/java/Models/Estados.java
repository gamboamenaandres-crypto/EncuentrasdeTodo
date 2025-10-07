package Models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Estados")
public class Estados {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name= "Id_estado")
    private int id_estado;

    @Column(name="des_estado")
    private String des_estado;

    @OneToMany(mappedBy = "estado", cascade = CascadeType.ALL)
    private List<Productos>  producto= new ArrayList<>();


    public Estados() {
    }

    public Estados(String des_estado) {
        this.des_estado = des_estado;

    }

    public int getId_estado() {
        return id_estado;
    }

    public void setId_estado(int id_estado) {
        this.id_estado = id_estado;
    }

    public String getDes_estado() {
        return des_estado;
    }

    public void setDes_estado(String des_estado) {
        this.des_estado = des_estado;
    }

    public List<Productos> getProducto() {
        return producto;
    }

    public void setProducto(List<Productos> producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        return "Estados{" +
                "id_estado=" + id_estado +
                ", des_estado='" + des_estado + '\'' +
                '}';
    }
}
