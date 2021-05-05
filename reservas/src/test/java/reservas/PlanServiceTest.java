package reservas;

import org.junit.Test;
import reservas.model.Plan;
import reservas.model.Servicio;
import reservas.service.PlanService;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class PlanServiceTest {

    // ESTO SON PRUEBAS QUE HE HECHO PERO QUE SE PUEDEN BORRAR Y HACER BIEN
    @Test
    public void testGetPlanes() {
        Plan plan1 = new Plan();
        plan1.id = 1;
        Plan plan2 = new Plan();
        plan2.id = 2;
        Plan plan3 = new Plan();
        plan3.id = 3;
        ArrayList<Plan> resultadoEsperado = new ArrayList<>();
        resultadoEsperado.add(plan1);
        resultadoEsperado.add(plan2);
        resultadoEsperado.add(plan3);
        PlanService plan = new PlanService();
        ArrayList<Plan> resultadoReal = plan.getPlanes();
        for(int i=0; i < resultadoEsperado.size(); i++){
            assertEquals(resultadoEsperado.get(i).getId(), resultadoReal.get(i).getId());
        }
    }

    @Test
    public void testGetPlan() {
        Servicio servicio1 = new Servicio();
        servicio1.id = 7;
        Servicio servicio2 = new Servicio();
        servicio2.id = 9;
        Servicio servicio3 = new Servicio();
        servicio3.id = 11;
        ArrayList<Servicio> resultadoEsperado = new ArrayList<>();
        resultadoEsperado.add(servicio1);
        resultadoEsperado.add(servicio2);
        resultadoEsperado.add(servicio3);
        PlanService plan = new PlanService();
        Plan planN = plan.getPlan(1);
        ArrayList<Servicio> resultadoReal = planN.servicios;
        for(int i=0; i < resultadoReal.size(); i++){
            assertEquals(resultadoEsperado.get(i).getId(), resultadoReal.get(i).getId());
        }
    }

}