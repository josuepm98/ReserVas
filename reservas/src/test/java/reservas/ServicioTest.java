package reservas;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.springframework.beans.factory.annotation.Autowired;
import reservas.model.Servicio;
import reservas.service.ServicioService;

import java.util.ArrayList;
import java.util.List;


public class ServicioTest {

    ServicioService servicioService = new ServicioService();

    @Test
    public void crearServicio(){
        Servicio servicio = new Servicio("nombrePrueba", "Aspe", 500.5, "2021-05-10", "08:00:00", "09:00:00", "Peluqueria", Servicio.ServicioEstado.LIBRE, "taesEmpresa", null);
        boolean resultadoEsperado = true;
        boolean resultadoReal = servicio.createService();
        assertEquals(resultadoEsperado, resultadoReal);

        //dejamos la BBDD igual
        resultadoReal = servicio.deleteService();
        resultadoEsperado = true;
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

    @Test
    public void getServicio(){
        Servicio resultadoReal = servicioService.getService(1);
        assertEquals(1, resultadoReal.getId());
    }

    @Test
    public void getServicios(){
        List<Servicio> resultadoEsperado = new ArrayList<>();
        Servicio service;
        service = servicioService.getService(1);
        resultadoEsperado.add(service);
        service = servicioService.getService(2);
        resultadoEsperado.add(service);
        List<Servicio> resultadoReal = servicioService.getServicios("taesEmpresa", 1);

        for(int i = 0; i < resultadoEsperado.size(); i++) {
            assertEquals(resultadoEsperado.get(i).getId(), resultadoReal.get(i).getId());
        }
    }

    @Test
    public void getServiciosPorCategoria(){
        List<Servicio> resultadoEsperado = new ArrayList<>();
        Servicio service;
        service = servicioService.getService(1);
        resultadoEsperado.add(service);
        List<Servicio> resultadoReal = servicioService.getServiciosPorCategoria("Peluqueria");

        for(int i = 0; i < resultadoEsperado.size(); i++) {
            assertEquals(resultadoEsperado.get(i).getId(), resultadoReal.get(i).getId());
        }
    }


}
