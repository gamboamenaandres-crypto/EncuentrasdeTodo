package Controllers;


import Models.Categoria;
import Models.Estados;
import Models.Productos;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ProductosController {
    SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
            .addAnnotatedClass(Productos.class).buildSessionFactory();

    Session session = sessionFactory.openSession();

    public String RegistrarProducto(String nombre_producto, int id_categoria, double precio){

        try{

            Estados estado = session.get(Estados.class, 1);
            Categoria categoria_encontrada = session.get(Categoria.class,id_categoria);
            Productos producto = new Productos(nombre_producto, precio,categoria_encontrada,estado );

            session.beginTransaction();

            session.save(producto);

            session.getTransaction().commit();
            return "Producto: " +nombre_producto+ " agregado exitosamente";


        } catch (Exception e){
            e.printStackTrace();
            return "Error al registrar el prodcuto";
        }finally {
            sessionFactory.close();
        }
    }

    public String ActualizarProducto(int id_producto,String des_producto, int id_categoria, double precio){

        try{
            Estados estados = session.get(Estados.class, 1);
            Productos producto = session.get(Productos.class, id_producto);

            Categoria categoria_encontrada= session.get(Categoria.class,id_categoria);
            session.beginTransaction();

            producto.setDescripcion_producto(des_producto);
            producto.setCategoria(categoria_encontrada);
            producto.setPrecio(precio);
            producto.setEstado(estados);

            session.update(producto);

            session.getTransaction().commit();
            return "Producto: " +des_producto+ " actualizado exitosamente";


        } catch (Exception e){
            e.printStackTrace();
            return "Error al actualizar el producto";
        }finally {
            sessionFactory.close();
        }
    }

    public String EliminarProducto(int id_producto){

        try{

            Estados estados = session.get(Estados.class, 2);
            Productos producto = session.get(Productos.class, id_producto);

            session.beginTransaction();

            producto.setEstado(estados);

            session.update(producto);

            session.getTransaction().commit();
            return "Producto:  actualizado a estado cero(0) fuera de stock";


        } catch (Exception e){
            e.printStackTrace();
            return "Error al actualizar el producto";
        }finally {
            sessionFactory.close();
        }
    }


    public static List<Productos> MostrarProductos(){
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Productos.class).buildSessionFactory();

        Session session = sessionFactory.openSession();

        List<Productos> productos = null;


        try{

            productos = session.createQuery("FROM Productos", Productos.class).getResultList();

            return productos;



        } catch (Exception e){
            e.printStackTrace();
            return null;

        }finally {
            sessionFactory.close();
        }


    }


}
