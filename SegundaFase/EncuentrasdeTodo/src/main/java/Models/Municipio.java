package Models;

import javax.persistence.*;

@Entity
@Table(name="tbl_municipios")
public class Municipio {

	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Id
	@Column(name ="id_municipio")
	public int id_municipio;
	
	@Column (name="nom_municipio")
	public String nom_municipio;

	public int getId_municipio() {
		return id_municipio;
	}

	public void setId_municipio(int id_municipio) {
		this.id_municipio = id_municipio;
	}

	public String getNom_munisipio() {
		return nom_municipio;
	}

	public void setNom_munisipio(String nom_municipio) {
		this.nom_municipio = nom_municipio;
	}

	public Municipio() {
		//Contructor vacio
		
	}

	public Municipio(String nom_municipio) {
		this.nom_municipio = nom_municipio;
	}

	@Override
	public String toString() {
		return "Municipio: id_municipio=" + id_municipio + ", nombre=" + nom_municipio;
	}
	
	
	
	
	
	
	
}
