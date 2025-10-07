package Controllers;

import Models.Categoria;
import Models.Estados;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EstadoController {

    SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
            .addAnnotatedClass(Estados.class).buildSessionFactory();

    Session session = sessionFactory.openSession();



    public String AgregarEstado(String des_estado){


        try{

            Estados estado = new Estados(des_estado);

            session.beginTransaction()
;
            session.save(estado);

            session.getTransaction().commit();

            return "Estado agregado exitosamente";

        }catch (Exception E){
            E.printStackTrace();
            return "Error";
        }finally {
            sessionFactory.close();
        }

    }
}
