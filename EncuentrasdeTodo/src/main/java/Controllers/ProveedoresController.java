package Controllers;

import java.util.List;

import org.hibernate.*; 
import org.hibernate.cfg.Configuration;

import Models.Proveedor;
import Models.tipo_usuario;




public class ProveedoresController {


	SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
			.addAnnotatedClass(Proveedor.class).buildSessionFactory();
	
	Session session = sessionFactory.openSession();
	
	public String agregar_proveedor(String nom_proveedor) {
		
		try {
			Proveedor proveedor = new Proveedor(nom_proveedor);
			 
			session.beginTransaction();
			
			session.persist(proveedor);
			
			session.getTransaction().commit();	
			
			return "proveedor agregado Exitosamente";
			
		} catch (Exception e){
			
			e.printStackTrace();
			
		} finally {
			sessionFactory.close();
		}
		
		
		return "Error al agregar el proveedor";
		
	}
	
	
	public String actualizar_proveedor(int id_proveedor, String nom_proveedor) {
		
		try {
			Proveedor proveedor = session.get(Proveedor.class, id_proveedor);
			
			
			session.beginTransaction();
			proveedor.setNom_proveedor(nom_proveedor);
			
		
			session.update(proveedor);
			
			session.getTransaction().commit();	
			
			return "proveedor actualizado Exitosamente";
			
		} catch (Exception e){
			
			e.printStackTrace();
			sessionFactory.close();
			
		} finally {
			sessionFactory.close();
		}
		
		
		return "Error al actualizar el proveedor";
		
	}
	
	public static List<Proveedor> listar_proveedores(){
		
		List<Proveedor> lista_proveedores = null;
		
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Proveedor.class).buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		try {
			
			lista_proveedores = session.createQuery("FROM Proveedor", Proveedor.class).getResultList();
			
			
			session.beginTransaction().commit();
			
			return lista_proveedores;
			
			
				
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			sessionFactory.close();
			
		}
		return lista_proveedores;
		
	}

	public String EliminarProveedor(int id_proveedor) {
		try {
			
			Proveedor Eliminar = session.get(Proveedor.class, id_proveedor);
			
			
			session.delete(Eliminar);
			
			session.beginTransaction();
			
			session.getTransaction().commit();
			
			return "Proveedor eliminado exitosamente";
			
		} catch (Exception e) {
			e.printStackTrace();
			
			
			return "Hubo un error al eliminar al proveedor";
		} finally {
			sessionFactory.close();
		}
		
	}
	
	
}
