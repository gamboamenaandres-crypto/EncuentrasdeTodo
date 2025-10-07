package Views;


import Controllers.EstadoController;

public class Insertar {

    public static void main(String[] args) {
        //pendiente

        String agregar = new EstadoController().AgregarEstado("pendiente");

        System.out.print(agregar);
    }

}
