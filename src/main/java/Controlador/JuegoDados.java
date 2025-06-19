package Controlador;

import Modelo.Dado;

public class JuegoDados {

    public int sumarDados(int dado1, int dado2) {
        return dado1 + dado2;
    }
    private void jugar(){
    Dado dado1 = new Dado();
    Dado dado2 = new Dado();
        dado1.lanzarDado();
        dado2.lanzarDado();
    int resultado = sumarDados(dado1.getCaraVisible(), dado2.getCaraVisible());
        if (resultado == 7) {
        System.out.println("Has ganado!!!!!!!!!!!!!!!!!!!!!!!!");
    } else {
        System.out.println("Has perdido, bu");
    }
}
}

