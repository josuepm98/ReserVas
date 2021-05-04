package reservas;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import reservas.model.Servicio;
import reservas.service.ServicioService;

import java.util.ArrayList;
import java.util.List;


public class ServicioTest {

    ServicioService servicioService = new ServicioService();

    @Test
    public void crearServicioTest(){
        Servicio servicio = new Servicio("nombrePrueba", "Aspe", 500.5, "2021-05-10", "08:00:00", "09:00:00", Servicio.ServicioEstado.LIBRE, "empresaSpa2", null);
        boolean resultadoEsperado = true;
        boolean resultadoReal = servicio.createService();
        assertEquals(resultadoEsperado, resultadoReal);

        //dejamos la BBDD igual
        resultadoReal = servicio.deleteService();
        resultadoEsperado = true;
        assertEquals(resultadoEsperado, resultadoReal);
    }

    @Test
    public void deleteServicioTest(){
        Servicio servicio = new Servicio("PruebaEliminar", "Aspe", 500.5, "2021-05-10", "08:00:00", "09:00:00", Servicio.ServicioEstado.LIBRE, "empresaSpa2", null);
        servicio.createService();  // insertamos
        boolean resultadoEsperado = true;
        boolean resultadoReal = servicio.deleteService();
        assertEquals(resultadoEsperado, resultadoReal);
    }

    @Test
    public void getServicioTest(){
        Servicio resultadoReal = servicioService.getService(1);
        assertEquals(1, resultadoReal.getId());
    }

    @Test
    public void getServiciosTest(){
        Servicio servicio1 = new Servicio("Masaje", "Alicante", 20, "2021-06-20", "09:00", "10:00", Servicio.ServicioEstado.LIBRE, "empresaSpa1", null);
        servicio1.id = 7;
        Servicio servicio2 = new Servicio("Masaje", "Alicante", 20, "2021-06-20", "10:00", "11:00", Servicio.ServicioEstado.LIBRE, "empresaSpa1", null);
        servicio2.id = 8;

        List<Servicio> resultadoEsperado = new ArrayList<>();
        resultadoEsperado.add(servicio1);
        resultadoEsperado.add(servicio2);

        List<Servicio> resultadoReal = servicioService.getServicios("empresaSpa1", 1);

        for(int i = 0; i < resultadoEsperado.size(); i++) {
            assertEquals(resultadoEsperado.get(i).getId(), resultadoReal.get(i).getId());
        }
    }

    @Test
    public void getServiciosPorCategoriaTest(){
        Servicio servicio = new Servicio("Comida", "Aspe", 0, "2021-06-20", "13:00", "15:00", Servicio.ServicioEstado.LIBRE, "empresaRestaurante", null);
        servicio.id = 12;

        List<Servicio> resultadoEsperado = new ArrayList<>();
        resultadoEsperado.add(servicio);

        List<Servicio> resultadoReal = servicioService.getServiciosPorCategoria("Restaurante");

        for(int i = 0; i < resultadoEsperado.size(); i++) {
            assertEquals(resultadoEsperado.get(i).getId(), resultadoReal.get(i).getId());
        }
    }

    @Test
    public void getServiciosPorFecha(){
        String nombreUser = "empresaSpa1";
        String fecha = "2021-06-20";

        int resultadoEsperado[] = {7, 8};

        Servicio servicio = new Servicio();
        List<Servicio> operacion = servicio.getServiciosPorFecha(nombreUser, fecha);
        int resultadoReal[] = new int [2];
        for(int i=0; i<operacion.size(); i++){
            resultadoReal[i] = operacion.get(i).getId();
        }
        assertArrayEquals(resultadoEsperado, resultadoReal);
    }

}
