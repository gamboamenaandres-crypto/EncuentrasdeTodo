package Controllers;

import Models.DetalleFactura;
import Models.Factura;
import Models.Productos;
import Models.Usuario;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class FacturaControlador {

    SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
            .addAnnotatedClass(Productos.class).buildSessionFactory();

    Session session = sessionFactory.openSession();


    public String AgregarFactura(double Total, int id_usuario){

        try{
            Usuario comprador= session.get(Usuario.class, id_usuario);

            Factura factura = new Factura(Total, comprador);

            session.beginTransaction();

            session.save(factura);

            session.getTransaction().commit();




            return "Factura creada exitosamente id: " + factura.getId_factura();



        } catch (Exception e) {
            e.printStackTrace();
            return "Error al agregar factura, usuario no existe";
        }finally {
            sessionFactory.close();
        }



    }


    public static List<Factura> MostrarFactura(){

        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Productos.class).buildSessionFactory();

        Session session = sessionFactory.openSession();

        List<Factura> lista = null;

        try{

            lista = session.createQuery("FROM Factura", Factura.class).getResultList();

            return lista;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            sessionFactory.close();
        }

    }
}
