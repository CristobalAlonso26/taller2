package Modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DadoTest {

    @Test
    public void testValoresDados() {
        Dado dado = new Dado();
        for (int i = 0; i < 100; i++) {  // multiples lanzamientos
            dado.lanzarDado();
            int valor = dado.getCaraVisible();
            assertTrue(valor >= 1 && valor <= 6,
                    "El valor del dado debe estar entre 1 y 6, pero fue: " + valor);
        }
    }

    @Test
    public void testSumaDados() {
        // Test para verificar la suma de dos dados
        Dado dado1 = new Dado();
        Dado dado2 = new Dado();

        dado1.lanzarDado();
        dado2.lanzarDado();

        int suma = dado1.getCaraVisible() + dado2.getCaraVisible();
        assertTrue(suma >= 2 && suma <= 12,
                "La suma debe estar entre 2 y 12, pero fue: " + suma);
    }
}