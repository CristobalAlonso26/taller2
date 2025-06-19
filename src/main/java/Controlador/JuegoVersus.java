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
            System.out.println("\nRonda " + (i+1));
            jugador1.jugar();
            delay();
            jugador2.jugar();
            delay();
        }
    }

    private void delay() {
        try {
            Thread.sleep(1000); // pausa de 2 segundos
        } catch (InterruptedException e) {
            e.printStackTrace();}
    }

}
