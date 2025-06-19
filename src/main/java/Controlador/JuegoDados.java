package Controlador;

import Modelo.Dado;

public class JuegoDados {

    public int sumarDados(int dado1, int dado2) {
        return dado1 + dado2;
    }
    private Boolean jugar(){
    Dado dado1 = new Dado();
    Dado dado2 = new Dado();
        dado1.lanzarDado();
        dado2.lanzarDado();
    int resultado = sumarDados(dado1.getCaraVisible(), dado2.getCaraVisible());
    return resultado == 7;
}
}

