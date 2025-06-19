package Vista;

import java.util.Scanner;

public class JuegoDadosConsola {
    private static Scanner sc = new Scanner(System.in);

    public void menu() {
        int opcion;
        do {
            mostrarOpciones();
            opcion = obtenerOpcion(0);
            ejecutarOpcion(opcion);
        } while (opcion != 2);
    }

    public void mostrarOpciones(int opcion) {
        switch (opcion) {
            case 1 -> System.out.println("1. Lanzar dados");
            case 2 -> System.out.println("2. Salir");
            default -> System.out.println("Opcion invalida");
        }
    }

    private int obtenerOpcion(int opcion) {
        try {
            opcion = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Ingrese un numero valido");
            return -1; // Devolver un valor inválido para que no ejecute ninguna opción
        }
        return opcion;
    }
}
