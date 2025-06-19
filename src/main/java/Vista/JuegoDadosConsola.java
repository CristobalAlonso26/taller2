package Vista;
import Controlador.JuegoDados;
import java.util.Scanner;

public class JuegoDadosConsola {
    private final Scanner sc = new Scanner(System.in);
    private JuegoDados juegoDados = new JuegoDados();
    private int finprograma = 0;

    public void menuJuegoDados() {
        int opcion;
        do {
            mostrarOpcionesJuegoDados();
            opcion = obtenerOpcionJuegoDados(0);
            ejecutarOpcionJuegoDados(opcion);
        } while (finprograma == 0);
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
        int resultado = juegoDados.jugar();
        if (resultado == 7) {
            System.out.println("Ha obtenido un 7. Ha ganado el juego");
        } else {
            System.out.println("Ha obtenido un " + resultado + ". No ha ganado el juego");
        }
    }

    public boolean confirmarSalidaJuegoDados() {
        boolean entradaValida = false;

        while (!entradaValida) {
            try {
                System.out.print("¿Seguro que desea salir? (S/N): ");
                String respuesta = sc.nextLine().trim();

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
    private void manejoDeSalidaJuegoDados() {
        if (confirmarSalidaJuegoDados()) {
            finprograma = 1;
        }
    }
}

