package reservas;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import reservas.model.Servicio;


public class ServicioTest {

    @Test
    public void crearServicio(){
        Servicio servicio = new Servicio("nombrePrueba", "Aspe", 500.5, "2021-05-10", "08:00:00", "09:00:00", "Peluqueria", Servicio.ServicioEstado.LIBRE, "taesEmpresa", null);
        boolean resultadoEsperado = true;
        boolean resultadoReal = servicio.createService();
        assertEquals(resultadoEsperado, resultadoReal);
    }

    @Test
    public void deleteServicio(){
        Servicio servicio = new Servicio("PruebaEliminar", "Aspe", 500.5, "2021-05-10", "08:00:00", "09:00:00", "Peluqueria", Servicio.ServicioEstado.LIBRE, "taesEmpresa", null);
        servicio.createService();  // insertamos
        boolean resultadoEsperado = true;
        boolean resultadoReal = servicio.deleteService();
        assertEquals(resultadoEsperado, resultadoReal);
    }


}
