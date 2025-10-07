package Views;

import java.util.List;


/**
 * Hello world!
 *
 */
import Controllers.*;
import Models.*;


import javax.swing.JFrame;


public class AppAgregarUsuario extends JFrame
{
    //Ingresar Usuarios
    public static void main( String[] args )
    {
    	


    	//String agregar = new UsuarioController().AgregarUsuarios("15", "Andres", "Arvelaez", "3136554",
          //      "adnres@hot",2,1,4  );

    	
    	//Actualizar
    		//String actualizar = new UsuarioController().ActualizarUsuario(14,"14", "Andres", "Arbelaez",
              //      "3136554", "keke@hot",2,1,4  );


        //Eliminar
    		String eliminar = new UsuarioController().EliminarUsuario(13);
        
    	//Mostrar
    	List<Usuario> x = UsuarioController.MostrarUsuarios();
    	
System.out.print(x);
    	
    	
    

}


}
