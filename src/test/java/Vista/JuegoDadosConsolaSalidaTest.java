package Vista;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

public class JuegoDadosConsolaSalidaTest {

    private JuegoDadosConsola juegoDadosConsola;
    private ByteArrayOutputStream outputCapturado;
    private PrintStream salidaEstandar;
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        juegoDadosConsola = new JuegoDadosConsola();
        salidaEstandar = System.out;
        outputCapturado = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputCapturado));
    }

    @Test
    public void testConfirmarSalidaConS() {
        proveerEntrada("S\n");
        boolean resultado = juegoDadosConsola.confirmarSalidaJuegoDados();
        assertTrue(resultado, "Debería retornar true cuando se ingresa 'S'");
        assertTrue(outputCapturado.toString().contains("Saliendo..."));
    }

    @Test
    public void testConfirmarSalidaConN() {
        proveerEntrada("N\n");
        boolean resultado = juegoDadosConsola.confirmarSalidaJuegoDados();
        assertFalse(resultado, "Debería retornar false cuando se ingresa 'N'");
        assertTrue(outputCapturado.toString().contains("No se ha salido..."));
    }

    @Test
    public void testConfirmarSalidaConMinusculas() {
        proveerEntrada("s\n");
        boolean resultado = juegoDadosConsola.confirmarSalidaJuegoDados();
        assertTrue(resultado, "Debería retornar true cuando se ingresa 's' minúscula");

        outputCapturado.reset();
        proveerEntrada("n\n");
        resultado = juegoDadosConsola.confirmarSalidaJuegoDados();
        assertFalse(resultado, "Debería retornar false cuando se ingresa 'n' minúscula");
    }

    @Test
    public void testConfirmarSalidaConEntradaVacia() {
        proveerEntrada("\nS\n");
        boolean resultado = juegoDadosConsola.confirmarSalidaJuegoDados();
        assertTrue(outputCapturado.toString().contains("Error: La respuesta no puede estar vacía"));
    }

    @Test
    public void testConfirmarSalidaConEntradaInvalida() {
        proveerEntrada("X\nS\n");
        boolean resultado = juegoDadosConsola.confirmarSalidaJuegoDados();
        assertTrue(outputCapturado.toString().contains("Error: Por favor, ingrese 'S' para sí o 'N' para no"));
        assertTrue(resultado, "Debería retornar true después de la entrada válida 'S'");
    }

    private void proveerEntrada(String data) {
        ByteArrayInputStream testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
        juegoDadosConsola = new JuegoDadosConsola();
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() {
        System.setOut(salidaEstandar);
    }
}