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
            case 2 -> manejoDeSalidaJuegoDados();
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

    public boolean confirmarSalidaJuegoDados(String respuesta) {
        boolean entradaValida = false;

        while (!entradaValida) {
            try {
                System.out.print("¿Seguro que desea salir? (S/N): ");
                respuesta = sc.nextLine().trim();

                if (respuesta.isEmpty()) {
                    throw new IllegalArgumentException("La respuesta no puede estar vacía");
                }

                if (!respuesta.equalsIgnoreCase("s") && !respuesta.equalsIgnoreCase("n")) {
                    throw new IllegalArgumentException("Por favor, ingrese 'S' para sí o 'N' para no");
                }

                entradaValida = true;

                if (respuesta.equalsIgnoreCase("s")) {
                    System.out.println("Saliendo...");
                    return true;
                } else {
                    System.out.println("No se ha salido...");
                    return false;
                }

            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Error inesperado. Por favor, intente nuevamente.");
            }
        }
    return false;
    }
    private int manejoDeSalidaJuegoDados() {
        if (confirmarSalidaJuegoDados(sc.nextLine())) {
            return -1;
        } else {
            return 2;
        }
    }
}

