package Controllers;

import org.hibernate.*; 
import java.util.List;
import org.hibernate.cfg.Configuration;

import Models.Municipio;


public class municipios_controller {

	
	SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
			.addAnnotatedClass(Municipio.class).buildSessionFactory();
	
	Session session = sessionFactory.openSession();
	
	public String agregar_municipio(String nom_municipio) {
		
		
		try {
			Municipio municipio = new Municipio(nom_municipio);
			session.beginTransaction();
			
			
			session.save(municipio);
			
			session.getTransaction().commit();	
			
			return "municipio agregado Exitosamente";
			
		} catch (Exception e){
			
			e.printStackTrace();
			sessionFactory.close();
			
		} finally {
			sessionFactory.close();
		}
		
		
		return "Error al agregar el municipio";
		
	}
	
	public String eliminar_municipio(int id) {
		try {
			
			Municipio municipio = session.get(Municipio.class, id);
			
			session.delete(municipio);
			
			session.beginTransaction();
			
			
			
			session.getTransaction().commit();
			
			
			
			return "Municipio eliminado exitosamente";
			
		
		} catch (Exception e){
			
			e.printStackTrace();
			return "Error al eliminar el municipio";
			
		} finally {
			sessionFactory.close();
		}
		
		
	}
	
	public String actualizar_municipio(int id, String nombre_nuevo) {
		try {
			
			Municipio municipio = session.get(Municipio.class, id);
			
			municipio.setNom_munisipio(nombre_nuevo);
			
			session.beginTransaction();
			
			session.update(municipio);
			
			session.getTransaction().commit();
			
			
			
			return "Municipio actualizado exitosamente";
			
		
		} catch (Exception e){
			
			e.printStackTrace();
			return "Error al actualizar el municipio";
			
		} finally {
			sessionFactory.close();
		}
		
		
	}
	
	public static List<Municipio> Lista_municipios() {
		
		
		
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Municipio.class).buildSessionFactory();
		List<Municipio> lista_municipios = null;
		Session session = sessionFactory.openSession();
		
		
		
		try {
			
			lista_municipios  = session.createQuery("FROM Municipio", Municipio.class).getResultList();
			
			
			
			return lista_municipios;
			
		
		} catch (Exception e){
			
			e.printStackTrace();
			return lista_municipios;
			
		} finally {
			sessionFactory.close();
		}
		
		
		
	}
	
	
	
	}
	
	
	

