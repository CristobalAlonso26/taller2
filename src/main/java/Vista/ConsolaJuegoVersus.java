package Vista;

import java.util.Scanner;

public class ConsolaJuegoVersus {
    private static Scanner sc = new Scanner(System.in);

    public void menuJuegoVersus() {
        int opcion;
        do {
            mostrarOpcionesJuegoVersus();
            opcion = obtenerOpcionJuegoVersus(0);
            ejecutarOpcionJuegoVersus(opcion);
        } while (finprograma == 0);
    }

    private void ejecutarOpcionJuegoVersus(int opcion) {
        switch (opcion) {
            case 1 -> mostrarResultadoJuegoVersus();
            case 2 -> manejoDeSalidaJuegoVersus();
            default -> System.out.println("Opcion invalida");
        }
    }

    private int obtenerOpcionJuegoVersus(int opcion) {
        try {
            opcion = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Ingrese un numero valido");
            return -1; // Devolver un valor inválido para que no ejecute ninguna opción
        }
        return opcion;
    }
    public void mostrarOpcionesJuegoVersus() {
        System.out.println("1. Lanzar dados");
        System.out.println("2. Salir");
    }
}
