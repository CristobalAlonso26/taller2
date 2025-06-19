package Controlador;
import Modelo.Jugador;

public class JuegoVersus {
    private Jugador jugador1;
    private Jugador jugador2;
    private int rondasMax;


    public JuegoVersus(Jugador jugador1, Jugador jugador2, int rondasMax ){
        this.rondasMax = rondasMax;
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;

    }

    public void jugar(){
        for (int i = 0; i < rondasMax; i++){
            jugador1.jugar();
            jugador2.jugar();
            try {
                Thread.sleep(2000); // pausa de 2 segundos
            } catch (InterruptedException e) {
                e.printStackTrace();}
        }
    }

}
