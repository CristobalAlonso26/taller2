package Controlador;

import Modelo.Dado;
import Modelo.Jugador;

public class JuegoVersus {
    private Jugador jugador1;
    private Jugador jugador2;
    private Dado dado1;
    private Dado dado2;
    private int rondasAJugar;

    JuegoVersus(Jugador jugador1, Jugador jugador2, int rondasAJugar ){
        this.rondasAJugar = rondasAJugar;
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        dado1 = new Dado();
        dado2 = new Dado();
    }
    private int lanzarDados(){
        dado1.lanzarDado();
        dado2.lanzarDado();
        return dado1.getCaraVisible() + dado2.getCaraVisible();
    }
    private void actualizarPuntaje(int resultado){
        if(resultado == 7){
            jugador1.setPuntos(jugador1.getPuntos()+1);
        }else if(resultado == 11){
            jugador2.setPuntos(jugador2.getPuntos()+1);
        }
    }

}
