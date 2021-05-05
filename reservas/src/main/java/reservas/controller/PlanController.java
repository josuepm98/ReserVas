package reservas.controller;

import com.google.gson.Gson;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reservas.authentication.UsuarioNoLogeadoException;
import reservas.model.Plan;
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

    @GetMapping("/plans") //NO SE LA RUTA QUE PEDIRAN
    public ResponseEntity<?> planes(HttpSession session) {
        String nombreUsuarioLogeado = (String) session.getAttribute("nombreUserLogeado");

        if(nombreUsuarioLogeado == null){
            throw new UsuarioNoLogeadoException();
        }

        List<Plan> planes = planService.getPlanes(); //TENEMOS QUE DEVOLVER LA SELECT DE SERVICIOS Y PASARLA AL FRONT COMO JSON

        Gson gson =  new Gson();
        String json = gson.toJson(planes);

        return new ResponseEntity<>(json ,HttpStatus.OK);
    }

    @GetMapping("/plan/{id}") //NO SE LA RUTA QUE PEDIRAN
    public ResponseEntity<?> plan(@PathVariable(value="id") Integer idPlan, HttpSession session) {
        String nombreUsuarioLogeado = (String) session.getAttribute("nombreUserLogeado");

        if(nombreUsuarioLogeado == null){
            throw new UsuarioNoLogeadoException();
        }

        Plan plan = planService.getPlan(idPlan); //TENEMOS QUE DEVOLVER LA SELECT DE SERVICIOS Y PASARLA AL FRONT COMO JSON

        Gson gson =  new Gson();
        String json = gson.toJson(plan);

        return new ResponseEntity<>(json ,HttpStatus.OK);
    }

}
