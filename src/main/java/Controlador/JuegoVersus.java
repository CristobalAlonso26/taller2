package Controlador;

import Modelo.Dado;
import Modelo.Jugador;
import Controlador.JuegoDados;

public class JuegoVersus {
    private Jugador jugador1;
    private Jugador jugador2;
    private int rondasMax;


    JuegoVersus(Jugador jugador1, Jugador jugador2, int rondasMax ){
        this.rondasMax = rondasMax;
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;

    }

    public void jugar(){
        while (jugador1.getPuntos() == rondasMax || jugador2.getPuntos() == rondasMax){
            jugador1.jugar();
            jugador2.jugar();
        }
        mostrarMarcadores();
        mostrarGanador();
    }

    private void mostrarMarcadores(){
        System.out.println("El juego ha terminado");
        System.out.println("Jugador 1: " + jugador1.getPuntos());
        System.out.println("Jugador 2: " + jugador2.getPuntos());}
    private void mostrarGanador(){
        if(jugador1.getPuntos() > jugador2.getPuntos()){
            System.out.println("El ganador es el jugador " + jugador1.getNombre());
        }else{
            System.out.println("El ganador es el jugador " + jugador2.getNombre());
        }
    }
}
