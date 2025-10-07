package Views;

import Controllers.UsuarioController;
import Models.Usuario;

import javax.swing.*;
import java.util.List;


public class AppAgregarProducto extends JFrame
{
    //Ingresar Usuarios
    public static void main( String[] args )
    {



    	String agregar = new UsuarioController().AgregarUsuarios("14", "Andres", "Arvelaez", "3136554",
                "keke@hot",2,1,4  );
    	//String agregar = new EstadoController().AgregarEstado("disponible");
    	//String agregar2 = new EstadoController().AgregarEstado("Agotado");


    	//Actualizar
    		String actualizar = new UsuarioController().ActualizarUsuario(13,"14", "Andres", "Arvelaez",
                    "3136554", "keke@hot",2,1,4  );


        //Eliminar
    		String eliminar = new UsuarioController().EliminarUsuario(13);
        
    	//Mostrar
    	List<Usuario> lista = UsuarioController.MostrarUsuarios();
    	
System.out.print(agregar);
    	
    	
    

}


}
