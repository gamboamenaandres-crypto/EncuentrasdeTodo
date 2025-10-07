package Controllers;


import Controllers.genero_controller;
import org.hibernate.*;

import org.hibernate.cfg.Configuration;

import Models.Genero;
import Models.Municipio;
import Models.Usuario;
import Models.tipo_usuario;


import java.util.List;

public class UsuarioController {


	SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
			.addAnnotatedClass(Usuario.class).buildSessionFactory();
	
	Session session = sessionFactory.openSession();
	
	
	public String AgregarUsuarios(String identificacion, String nombre_usuario, String apellido_usuario,
			String telefono, String correo, int id_genero, int id_municipio, int id_tipo_usuario) {


        try {
            Genero genero = session.get(Genero.class, id_genero);
            tipo_usuario tipo_usuario = session.get(tipo_usuario.class, id_tipo_usuario);
            Municipio municipio = session.get(Municipio.class, id_municipio);


            Usuario nuevo_usuario = new Usuario(identificacion, nombre_usuario, apellido_usuario, telefono, correo, genero, municipio, tipo_usuario);


            session.beginTransaction();
            session.save(nuevo_usuario);
            session.getTransaction().commit();


            return "usuario agregado exitosamente";


        } catch (Exception e) {

            e.printStackTrace();
            return "Error";
        } finally {
            sessionFactory.close();
        }
    }



        public String EliminarUsuario(int id_usuario){


            try {


                Usuario eliminar_usuario = session.get(Usuario.class, id_usuario);



                session.beginTransaction();
                session.delete(eliminar_usuario);
                session.getTransaction().commit();


                return "usuario eliminado exitosamente";


            } catch(Exception e) {

                e.printStackTrace();
                return "Error, usuario no encontrado";
            } finally {
                sessionFactory.close();
            }
		
	    }
    public String ActualizarUsuario(int id_usuario, String identificacion, String nombre_usuario, String apellido_usuario,
                                    String telefono, String correo, int id_genero, int id_municipio, int id_tipo_usuario){


        try {

            Genero genero = session.get(Genero.class, id_genero);
            Municipio municipio = session.get(Municipio.class, id_municipio);
            tipo_usuario rol = session.get(tipo_usuario.class, id_tipo_usuario);

            session.beginTransaction();
            Usuario actualizar_ususario = session.get(Usuario.class, id_usuario);
            actualizar_ususario.setIdentificacion(identificacion);
            actualizar_ususario.setNombre_usuario(nombre_usuario);
            actualizar_ususario.setApellido_usuario(apellido_usuario);
            actualizar_ususario.setTelefono(telefono);
            actualizar_ususario.setCorreo(correo);
            actualizar_ususario.setDireccion(municipio);
            actualizar_ususario.setGenero(genero);
            actualizar_ususario.setRoles(rol);

            session.update(actualizar_ususario);
            session.getTransaction().commit();


            return "usuario actualizado exitosamente";


        } catch(Exception e) {

            e.printStackTrace();
            return "Error, usuario no actualizado";
        } finally {
            sessionFactory.close();
        }

    }

    public static List<Usuario> MostrarUsuarios(){

        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Usuario.class).buildSessionFactory();

        Session session = sessionFactory.openSession();
        List<Usuario> lista = null;

        try {


            lista = session.createQuery("FROM Usuario", Usuario.class).getResultList();



            return lista;


        } catch(Exception e) {

            e.printStackTrace();
            return null;

        } finally {
            sessionFactory.close();
        }

    }
	
	
	
	
}
