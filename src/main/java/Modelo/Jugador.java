package Modelo;
import Controlador.JuegoDados;

public class Jugador {
    private String nombre;
    private int puntos;
    private JuegoDados juegoDados = new JuegoDados();

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.puntos = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }
    public void jugar(){
            System.out.println("El jugador " + this.nombre + " ha jugado ");
        if(juegoDados.jugar()){
            System.out.println("Jugador" + this.nombre + "ha obtenido 1 punto");
            this.puntos++;
        }else {
            System.out.println("Jugador" + this.nombre + "no ha obtenido puntos");
        }
        }
    }

