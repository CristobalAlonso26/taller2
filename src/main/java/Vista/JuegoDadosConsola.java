package Vista;
import Controlador.JuegoDados;
import java.util.Scanner;

public class JuegoDadosConsola {
    private static Scanner sc = new Scanner(System.in);
    private JuegoDados juegoDados = new JuegoDados();

    private void menuJuegoDados() {
        int opcion;
        do {
            mostrarOpcionesJuegoDados();
            opcion = obtenerOpcionJuegoDados(0);
            ejecutarOpcionJuegoDados(opcion);
        } while (opcion != 2);
    }

    private void ejecutarOpcionJuegoDados(int opcion) {
        switch (opcion) {
            case 1 -> mostrarResultadoJuegoDados();
            case 2 -> System.out.println("Saliendo...");
            default -> System.out.println("Opcion invalida");
        }
    }

    private int obtenerOpcionJuegoDados(int opcion) {
        try {
            opcion = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Ingrese un numero valido");
            return -1; // Devolver un valor inválido para que no ejecute ninguna opción
        }
        return opcion;
    }
    public void mostrarOpcionesJuegoDados() {
        System.out.println("1. Lanzar dados");
        System.out.println("2. Salir");
    }
    private void mostrarResultadoJuegoDados() {
        if(juegoDados.jugar()){
            System.out.println("Ganaste");
        }else{
            System.out.println("Perdiste");
        }
    }

}
