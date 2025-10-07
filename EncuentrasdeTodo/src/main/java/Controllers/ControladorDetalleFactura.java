package Controllers;

import Models.DetalleFactura;
import Models.Factura;
import Models.Productos;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ControladorDetalleFactura {

    SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
            .addAnnotatedClass(Productos.class).buildSessionFactory();

    Session session = sessionFactory.openSession();


    public String FacturarProductos(int factura, int id_producto, int cantidad){

        Factura id_factura = session.get(Factura.class, factura) ;
        Productos producto = session.get(Productos.class, id_producto);
double total = producto.getPrecio()*cantidad;
        try{

            DetalleFactura nuevo_detalle = new DetalleFactura(id_factura,producto,cantidad, total);

            session.beginTransaction();

            session.save(nuevo_detalle);

            session.getTransaction().commit();

            return "detalle generado exitosamente";

        } catch (Exception e) {
            e.printStackTrace();
            return  "Error";
        } finally {
            sessionFactory.close();
        }



    }

}
