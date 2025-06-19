package Vista;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

public class JuegoDadosConsolaTest {

    private JuegoDadosConsola juegoDadosConsola;
    private ByteArrayOutputStream outputCapturado;
    private PrintStream salidaEstandar;

    @BeforeEach
    public void setUp() {
        juegoDadosConsola = new JuegoDadosConsola();
        salidaEstandar = System.out;
        outputCapturado = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputCapturado));
    }

    @Test
    public void testMostrarResultadoJuegoDados() {
        for (int i = 0; i < 10; i++) {
            outputCapturado.reset();

            juegoDadosConsola.mostrarResultadoJuegoDados();

            String resultado = outputCapturado.toString().trim();

            assertTrue(
                    resultado.matches("Ha obtenido un 7\\. Ha ganado el juego") ||
                            resultado.matches("Ha obtenido un \\d+\\. No ha ganado el juego"),
                    "El mensaje debe indicar si ganó con 7 o perdió con otro número"
            );

            if (!resultado.contains("7")) {
                int numeroObtenido = extraerNumero(resultado);
                assertTrue(numeroObtenido >= 2 && numeroObtenido <= 12,
                        "El resultado debe estar entre 2 y 12");
            }
        }
    }

    private int extraerNumero(String mensaje) {
        // Extrae el número y elimina el punto
        return Integer.parseInt(mensaje.split(" ")[3].replace(".", ""));
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() {
        System.setOut(salidaEstandar);
    }
}