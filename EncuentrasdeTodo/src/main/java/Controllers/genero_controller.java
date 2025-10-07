package Controllers;



import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import Models.Genero;
import java.util.List;


public class genero_controller {

	SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
			.addAnnotatedClass(Genero.class).buildSessionFactory();
	
	Session session = sessionFactory.openSession();
	
	public String agregar_genero(String des_genero){
		try {
			
			Genero genero = new Genero(des_genero);
			
			session.beginTransaction();
			
			session.save(genero);
			
			session.getTransaction().commit();	
			
			return "registro agregado exitosamente";
		} catch (Exception e) {
			e.printStackTrace();
			return "Error";
		}finally {
			sessionFactory.close();
		}
		
		
		
	}
	
	public String eliminar_genero(int id_genero) {
		try {
			
			Genero genero = session.get(Genero.class, id_genero);
			
			session.delete(genero);
			
			session.beginTransaction();
			
			
			session.getTransaction().commit();
			
			return "Registro eliminado exitosamente";
			
		}catch (Exception e){
			
			e.printStackTrace();
			return "Error";
			
		}finally {
			sessionFactory.close();
		}
		
	}
	
	public String actualizar_genero(int id_genero, String des_genero) {
		
		try {
			
			Genero genero = session.get(Genero.class, id_genero);
			
			genero.setDes_genero(des_genero);
			

			session.beginTransaction();
            session.update(genero);
			session.getTransaction().commit();
			
			return "Actualizacion exitosa";

			
			
		}catch (Exception e) {
			e.printStackTrace();
			return"Error";
		} finally {
			sessionFactory.close();
		}	
	}
	
	public static List<Genero> mostrar_generos(){
		
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Genero.class).buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		
		List<Genero> generos = null;
		
		
		try {
			generos = session.createQuery("FROM Genero", Genero.class).getResultList();
			
			return generos;
			
		} catch (Exception e) {
			
			e.printStackTrace();
			return generos;
			
		} finally {
			sessionFactory.close();
		}
		
		
		
		
		
	}
	
	
	
}
