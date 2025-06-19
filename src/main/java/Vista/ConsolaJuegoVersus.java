package Vista;

import Controlador.JuegoVersus;
import Modelo.Jugador;

import java.util.Scanner;

public class ConsolaJuegoVersus {
    private static Scanner sc = new Scanner(System.in);
    Jugador jugador1;
    Jugador jugador2;
    private int finprograma = 0;

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
            case 1 -> manejarJuegoVersus();
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
        System.out.println("1. iniciar juego versus");
        System.out.println("2. Salir");
    }
    private void obtenerJugadores() {
        System.out.println("Ingrese el nombre del jugador 1");
        jugador1 = new Jugador(sc.nextLine());
        System.out.println("Ingrese el nombre del jugador 2");
        jugador2 = new Jugador(sc.nextLine());
    }
    private String obtenerRondas() {
        System.out.println("Ingrese el numero de rondas (1, 3, 5)");
        return sc.nextLine();
    }
    private int validarRondas(String rondas){
        switch (rondas){
            case "1" -> {return 1;}
            case "3" -> {return 3;}
            case "5" -> {return 5;}
            default -> {
                System.out.println("Rondas invalidas");
                return 0;
            }
            }
    }
    private void manejarJuegoVersus(){
        obtenerJugadores();
        JuegoVersus juegoVersus = new JuegoVersus(jugador1, jugador2, validarRondas(obtenerRondas()));
        juegoVersus.jugar();
        mostrarMarcadores();
        mostrarGanador();
    }
    private void mostrarMarcadores(){
        System.out.println("El juego ha terminado");
        System.out.println("Jugador " + jugador1.getNombre() +":" + jugador1.getPuntos());
        System.out.println("Jugador " + jugador2.getNombre() +":" + jugador2.getPuntos());}
    private void mostrarGanador(){
        if(jugador1.getPuntos() > jugador2.getPuntos()){
            System.out.println("El ganador es el jugador " + jugador1.getNombre());
        }else if (jugador1.getPuntos() < jugador2.getPuntos()) {
            System.out.println("El ganador es el jugador " + jugador2.getNombre());
        }else {
            System.out.println("Empate");
        }
    }

    public boolean confirmarSalidaJuegoVersus() {
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
    private void manejoDeSalidaJuegoVersus() {
        if (confirmarSalidaJuegoVersus()) {
            finprograma = 1;
        }
    }
}
