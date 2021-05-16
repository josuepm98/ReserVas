package reservas.controller;

import com.google.gson.Gson;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reservas.authentication.UsuarioNoLogeadoException;
import reservas.model.Plan;
import reservas.model.Servicio;
import reservas.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import javax.servlet.http.HttpSession;

@CrossOrigin(origins = "http://localhost:19006", methods= {RequestMethod.GET,RequestMethod.POST})
@RestController
public class PlanController {
    @Autowired
    PlanService planService;

    //devolemos planes libres para que se puedan reservar
    @GetMapping("/plans") //NO SE LA RUTA QUE PEDIRAN
    public ResponseEntity<?> planes(HttpSession session) {
        /*String nombreUsuarioLogeado = (String) session.getAttribute("nombreUserLogeado");

        if(nombreUsuarioLogeado == null){
            throw new UsuarioNoLogeadoException();
        }*/

        List<Plan> planes = planService.getPlanesLibres();

        Gson gson =  new Gson();
        String json = gson.toJson(planes);

        return new ResponseEntity<>(json ,HttpStatus.OK);
    }

    @PostMapping("/plans/{id}/reserve/{nombreUser}")
    public ResponseEntity<?> reservaPlan(@PathVariable(value="nombreUser") String nombreUser, @PathVariable(value="id") Integer idPlan){
        boolean reserva = false;

        reserva = planService.reservaPlan(idPlan, nombreUser);

        if(reserva){
            return new ResponseEntity<>("Plan reservado correctamente" ,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("No se ha podido reservar el plan", HttpStatus.OK);
        }
    }

    @PostMapping("/plans/{id}/cancel")
    public ResponseEntity<?> cancelarPlan(@PathVariable(value="id") Integer idPlan){
        boolean reserva = false;

        reserva = planService.cancelPlan(idPlan);

        if(reserva){
            return new ResponseEntity<>("Plan cancelado correctamente" ,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("No se ha podido cancelar el plan", HttpStatus.OK);
        }
    }

    @GetMapping("/users/{nombreUser}/plans") //NO SE LA RUTA QUE PEDIRAN
    public ResponseEntity<?> serviciosCliente(@PathVariable(value="nombreUser") String nombreUser) {
        //managerUserSesion.comprobarUsuarioLogeado(session, nombreUser);

        List<Plan> planes = planService.getPlanes(nombreUser); //TENEMOS QUE DEVOLVER LA SELECT DE SERVICIOS Y PASARLA AL FRONT COMO JSON

        Gson gson =  new Gson();
        String json = gson.toJson(planes);

        return new ResponseEntity<>(json ,HttpStatus.OK);
    }

    /*@GetMapping("/plan/{id}") //NO SE LA RUTA QUE PEDIRAN
    public ResponseEntity<?> plan(@PathVariable(value="id") Integer idPlan, HttpSession session) {
        /*String nombreUsuarioLogeado = (String) session.getAttribute("nombreUserLogeado");

        if(nombreUsuarioLogeado == null){
            throw new UsuarioNoLogeadoException();
        }*//*

        Plan plan = planService.getPlan(idPlan); //TENEMOS QUE DEVOLVER LA SELECT DE SERVICIOS Y PASARLA AL FRONT COMO JSON

        Gson gson =  new Gson();
        String json = gson.toJson(plan);

        return new ResponseEntity<>(json ,HttpStatus.OK);
    }*/

}
