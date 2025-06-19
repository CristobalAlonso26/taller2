package Vista;
import Controlador.JuegoDados;
import java.util.Scanner;

public class JuegoDadosConsola {
    private static Scanner sc = new Scanner(System.in);
    private JuegoDados juegoDados = new JuegoDados();

    private void menu() {
        int opcion;
        do {
            mostrarOpciones();
            opcion = obtenerOpcion(0);
            ejecutarOpcion(opcion);
        } while (opcion != 2);
    }

    private void ejecutarOpcion(int opcion) {
        switch (opcion) {
            case 1 -> mostrarResultado();
            case 2 -> System.out.println("2. Salir");
            default -> System.out.println("Opcion invalida");
        }
    }

    private int obtenerOpcion(int opcion) {
        try {
            opcion = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Ingrese un numero valido");
            return -1; // Devolver un valor inválido para que no ejecute ninguna opción
        }
        return opcion;
    }
    public void mostrarOpciones() {
        System.out.println("1. Lanzar dados");
        System.out.println("2. Salir");
    }
    private void mostrarResultado() {
        if(juegoDados.jugar()){
            System.out.println("Ganaste");
        }else{
            System.out.println("Perdiste");
        }
    }

}
