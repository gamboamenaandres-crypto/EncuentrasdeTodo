package Views;

import java.util.List;


/**
 * Hello world!
 *
 */
import Controllers.municipios_controller;
import Models.Municipio;



public class App 
{
    public static void main( String[] args )
    {
    	
    	//Agregar
    	//String agregar = new municipios_controller().agregar_municipio("Girardota");
    	
    	
    	//Actualizar
    		//String eliminar = new municipios_controller().eliminar_municipio(3);
    			
    	//Eliminar
    		//String actualizar = new municipios_controller().actualizar_municipio(3, "Churido");
        
    	//Mostrar
    	List<Municipio> lista = municipios_controller.Lista_municipios();
    	
    	System.out.print(lista);
    	
    	
    }
}
