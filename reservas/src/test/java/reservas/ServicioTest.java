package reservas;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import reservas.model.Servicio;


public class ServicioTest {

    @Test
    public void crearServicio(){
        Servicio servicio = new Servicio("nombrePrueba", "Aspe", 500.5, "2021-05-10", "08:00:00", "09:00:00", "Peluqueria", Servicio.ServicioEstado.LIBRE, "taesEmpresa", null);
        boolean resultadoEsperado = true;
        boolean resultadoReal = servicio.crearServicio();
        assertEquals(resultadoEsperado, resultadoReal);
    }
}
