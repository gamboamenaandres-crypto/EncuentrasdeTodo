package Models;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="Tbl_genero")
public class Genero {
	
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name="id_genero")
	public int id_genero;
	
	@Column(name="des_genero")
	public String des_genero;

    @OneToMany(mappedBy = "genero", cascade = CascadeType.ALL)
    private List<Usuario> usuarios = new ArrayList<>();


    public int getId_genero() {
        return id_genero;
    }

    public void setId_genero(int id_genero) {
        this.id_genero = id_genero;
    }

    public String getDes_genero() {
        return des_genero;
    }

    public void setDes_genero(String des_genero) {
        this.des_genero = des_genero;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }


    public Genero() {


    }

    public Genero(String des_genero) {
        this.des_genero = des_genero;

    }


    @Override
    public String toString() {
        return "Genero{" +
                "id_genero=" + id_genero +
                ", des_genero='" + des_genero + '\'' +
                ", usuarios=" + usuarios +
                '}';
    }
}
