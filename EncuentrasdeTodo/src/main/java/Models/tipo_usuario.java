package Models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="tbl_tipo_usuario")
public class tipo_usuario {
	
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Id
	@Column(name="id_tipo_usuario")
	private int id_tipo_usuario;
	
	@Column(name="des_tipo_usuario")
	private String des_tipo_usuario;


    @OneToMany(mappedBy = "roles", cascade = CascadeType.ALL)
    private List<Usuario> usuarios = new ArrayList<>();


    public int getId_tipo_usuario() {
        return id_tipo_usuario;
    }

    public void setId_tipo_usuario(int id_tipo_usuario) {
        this.id_tipo_usuario = id_tipo_usuario;
    }

    public String getDes_tipo_usuario() {
        return des_tipo_usuario;
    }

    public void setDes_tipo_usuario(String des_tipo_usuario) {
        this.des_tipo_usuario = des_tipo_usuario;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        tipo_usuario that = (tipo_usuario) o;
        return id_tipo_usuario == that.id_tipo_usuario && Objects.equals(des_tipo_usuario, that.des_tipo_usuario) && Objects.equals(usuarios, that.usuarios);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_tipo_usuario, des_tipo_usuario, usuarios);
    }

    public tipo_usuario() {

    }

    public tipo_usuario(String des_tipo_usuario) {
        this.des_tipo_usuario = des_tipo_usuario;

    }
}
