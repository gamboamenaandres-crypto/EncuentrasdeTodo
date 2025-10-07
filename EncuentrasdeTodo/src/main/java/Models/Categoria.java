package Models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table (name = "tbl_categoria")
public class Categoria {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_categoria")
    private int id_categoria;

    @Column(name = "nom_categoria")
    private String nombre_categoria;


    @ManyToOne(fetch =FetchType.LAZY)
    @JoinColumn(name = "id_proveedor")
    private Proveedor proveedor;

public Categoria() {

}
    public Categoria(String nombre_categoria, Proveedor proveedor) {
        this.nombre_categoria = nombre_categoria;
        this.proveedor = proveedor;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getNombre_categoria() {
        return nombre_categoria;
    }

    public void setNombre_categoria(String nombre_categoria) {
        this.nombre_categoria = nombre_categoria;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Categoria categoria = (Categoria) o;
        return id_categoria == categoria.id_categoria && Objects.equals(nombre_categoria, categoria.nombre_categoria) && Objects.equals(proveedor, categoria.proveedor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_categoria, nombre_categoria, proveedor);
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "id_categoria=" + id_categoria +
                ", nombre_categoria='" + nombre_categoria + '\'' +
                ", proveedor=" + (proveedor != null ? proveedor.getId_proveedor() : "null") +
                '}';
    }

}
