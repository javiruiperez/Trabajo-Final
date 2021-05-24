package Test;

import main.models.Respuesta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RespuestaTest {
    Respuesta res;
    @BeforeEach
    public void setUp() throws Exception {
        res = new Respuesta(1, "Respuesta de Testing");
    }

    @Test
    @DisplayName("Obtener el texto")
    public void obtenerTexto(){
        assertEquals("Get texto funciona", res.getTexto(), "Respuesta de Testing");  
    }

    @Test
    @DisplayName("Cambio de texto")
    public void testMultiply() {
        res.setTexto("Texto cambiado");
        assertEquals("El cambio de texto funciona", res.getTexto(),
                "Texto cambiado");
    }
}
