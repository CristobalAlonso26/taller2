package Modelo;

public class Dado {
    private int caraVisible;
    public void lanzarDado() {
        this.caraVisible = (int)(Math.random()*6+1);
    }
    public int getCaraVisible() {
        return caraVisible;
    }
}
