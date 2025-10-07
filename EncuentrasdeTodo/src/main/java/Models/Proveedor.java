package Models;


import javax.persistence.*;

@Entity
@Table(name="tbl_proveedores")
public class Proveedor {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "id_proveedor")
	public int id_proveedor;
	
	
	@Column(name= "nom_proveedor")
	public String nom_proveedor;


	public int getId_proveedor() {
		return id_proveedor;
	}


	public void setId_proveedor(int id_proveedor) {
		this.id_proveedor = id_proveedor;
	}


	public String getNom_proveedor() {
		return nom_proveedor;
	}


	public void setNom_proveedor(String nom_proveedor) {
		this.nom_proveedor = nom_proveedor;
	}

	
	
	
	@Override
	public String toString() {
		return "Proveedores [id_proveedor=" + id_proveedor + ", nom_proveedor=" + nom_proveedor + "]";
	}


	public Proveedor() {
		//Contructor vacio
		
	}
	
	
	public Proveedor(String nom_proveedor) {
		this.nom_proveedor = nom_proveedor;
	}
	
	
	
	
	


	
	
}
