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
        System.out.println("\nEl jugador " + this.nombre + " ha jugado \n");
        int resultado = juegoDados.jugar();
        if(resultado == 7){
            System.out.println("Jugador " + this.nombre + "ha obtenido 1 punto");
            this.puntos++;
        }else {
            System.out.println("Jugador " + this.nombre +" obtuvo: "+ resultado+ " no ha obtenido puntos");
        }
        }
    }

