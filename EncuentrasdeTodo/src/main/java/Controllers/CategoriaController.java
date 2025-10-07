package Controllers;

import Models.Categoria;
import Models.Productos;
import Models.Proveedor;
import Models.Usuario;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import org.hibernate.query.Query;
import java.util.List;

public class CategoriaController {

    SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
            .addAnnotatedClass(Categoria.class).buildSessionFactory();

    Session session = sessionFactory.openSession();


    public String CrearCategoria(String nombre_categoria, int id_proveedor){

        try{

            Proveedor proveedor = session.get(Proveedor.class, id_proveedor);

            Categoria nuevaCategoria = new Categoria(nombre_categoria, proveedor);

            session.beginTransaction();

            session.save(nuevaCategoria);

            session.getTransaction().commit();

            return "Categoria agregada exitosamente";


        } catch (Exception e){
            e.printStackTrace();
            return "Error al agregar la categoria";
        } finally {
            sessionFactory.close();
        }

    }

    public String EliminarCategoria(int id_categoria){

        try{

            String hql_productos = "FROM Productos p WHERE p.categoria = :categoria_obj";

            Query<Productos> productosQuery = session.createQuery(hql_productos, Productos.class);
            productosQuery.setParameter("categoria_obj", Categoria.class); // Pasamos el objeto persistente

            List<Productos> productosAsociados = productosQuery.getResultList();

            for (Productos producto : productosAsociados) {
                session.delete(producto); // Eliminar producto por producto
            }

            Categoria Eliminar = session.get(Categoria.class, id_categoria);

            session.beginTransaction();

            session.delete(Eliminar);

            session.getTransaction().commit();

            return "Categoria Eliminada exitosamente";


        } catch (Exception e){
            e.printStackTrace();
            return "Error al Eliminar la categoria";
        } finally {
            sessionFactory.close();
        }

    }

    public String ActualizarCategoria(int id_categoria, String nom_categoria, int id_proveedor){

        try{

            Categoria modification = session.get(Categoria.class, id_categoria);
            Proveedor proveedor = session.get(Proveedor.class, id_proveedor);

            modification.setNombre_categoria(nom_categoria);
            modification.setProveedor(proveedor);

            session.beginTransaction();

            session.delete(modification);

            session.getTransaction().commit();

            return "Categoria Actualizada exitosamente";


        } catch (Exception e){
            e.printStackTrace();
            return "Error al Actualizar la categoria, categoria no encontrada";
        } finally {
            sessionFactory.close();
        }

    }


    public static List<Categoria> ListarCategoria(){

        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Categoria.class).buildSessionFactory();

        Session session = sessionFactory.openSession();
        List<Categoria> categoria = null;

        try{

            categoria = session.createQuery("FROM Categoria", Categoria.class).getResultList();

            return categoria;


        }catch (Exception e){

            e.printStackTrace();
            return null;
        }finally {
            sessionFactory.close();
        }

    }

}
