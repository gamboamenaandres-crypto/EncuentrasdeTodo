package Models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="tbl_municipios")
public class Municipio {

	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Id
	@Column(name ="id_municipio")
	public int id_municipio;
	
	@Column (name="nom_municipio")
	public String nom_municipio;

    @OneToMany(mappedBy = "direccion", cascade = CascadeType.ALL)
    private List<Usuario> usuarios = new ArrayList<>();

    

	public int getId_municipio() {
		return id_municipio;
	}

	public void setId_municipio(int id_municipio) {
		this.id_municipio = id_municipio;
	}

	public String getNom_municipio() {
		return nom_municipio;
	}

	public void setNom_municipio(String nom_municipio) {
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
		return nom_municipio;
	}
	
	
	
	
	
	
	
}
