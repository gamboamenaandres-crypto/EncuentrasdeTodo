package Models;

import javax.persistence.*;

@Entity
@Table(name="tbl_tipo_usuario")
public class tipo_usuario {
	
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Id
	@Column(name="id_tipo_usuario")
	public int id_tipo_usuario;
	
	@Column(name="des_tipo_usuario")
	public String des_tipo_usuario;
	
	

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

	public tipo_usuario() {
	
	}

	public tipo_usuario(String des_tipo_usuario) {
		
		this.des_tipo_usuario = des_tipo_usuario;
	}

	@Override
	public String toString() {
		return "tipo_usuario [id_tipo_usuario=" + id_tipo_usuario + ", des_tipo_usuario=" + des_tipo_usuario + "]";
	}
	
	
	
	
	
	
	
	
	
}
