package Controlador;
import Modelo.Dado;

public class JuegoDados {

    private int sumarDados(int dado1, int dado2) {
        return dado1 + dado2;
    }

    public int jugar(){
    Dado dado1 = new Dado();
    Dado dado2 = new Dado();
        dado1.lanzarDado();
        dado2.lanzarDado();
        return sumarDados(dado1.getCaraVisible(), dado2.getCaraVisible());
}
}

