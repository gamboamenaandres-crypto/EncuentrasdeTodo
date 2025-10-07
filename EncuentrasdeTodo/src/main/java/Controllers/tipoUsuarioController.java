package Controllers;


import org.hibernate.Session;  
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.List;

import Models.Municipio;
import Models.tipo_usuario;

import javax.management.Query;

public class tipoUsuarioController {
	
	SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
			.addAnnotatedClass(tipo_usuario.class).buildSessionFactory();
	
	Session session = sessionFactory.openSession();
	
	
	public String agregar_tipo_usuario(String des_t_usuario) {
		
		try {
			tipo_usuario t_usuario = new tipo_usuario(des_t_usuario);
			
			session.beginTransaction();
			
			session.save(t_usuario);
			
			session.getTransaction().commit();	
			
			return "Tipo de usuario agregado Exitosamente";
			
		} catch (Exception e){
			
			e.printStackTrace();
			sessionFactory.close();
			
		} finally {
			sessionFactory.close();
		}
		
		
		return "Error al agregar el tipo de usuario";
		}
	
public String actualizar_t_usuario(int id, String des_tipo_usuario) {
	

	try {
		
	tipo_usuario t_usuario = session.get(tipo_usuario.class, id);
	
	
	session.beginTransaction();
	t_usuario.setDes_tipo_usuario(des_tipo_usuario);
		
		
		session.update(t_usuario);
		
		session.getTransaction().commit();	
		
		return "Tipo de usuario actualizado Exitosamente";
		
	} catch (Exception e){
		
		e.printStackTrace();
		sessionFactory.close();
		
	} finally {
		sessionFactory.close();
	}
	
	
	return "Error al actualizar el tipo de usuario";
	}

		public static List<tipo_usuario> Mostrar_tipos_usuarios(){
			
			SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
					.addAnnotatedClass(tipo_usuario.class).buildSessionFactory();
			
			Session session = sessionFactory.openSession();
			
			List<tipo_usuario> t_usuarios = null;
			
			
			try {
				
				t_usuarios = session.createQuery("FROM tipo_usuario", tipo_usuario.class).getResultList();
				
				return t_usuarios;
				
				
				
			} catch (Exception e){
				e.printStackTrace();
				
			}finally {
				sessionFactory.close();
			}
			return t_usuarios;
	
	
		}
		
		
		
		public String EliminarTipo_usuario(int id_tipo_usuario) {
			try {
				
				tipo_usuario Eliminar = session.get(tipo_usuario.class, id_tipo_usuario);
				
				
				session.delete(Eliminar);
				
				session.beginTransaction();
				
				session.getTransaction().commit();
				
				return "tipo de usuario eliminado exitosamente";
				
			} catch (Exception e) {
				e.printStackTrace();
				
				
				return "Hubo un error al eliminar al tipo de usuario";
			} finally {
				sessionFactory.close();
			}
			
		}









}
	
	
	




	
	
	
	
	
	
	


