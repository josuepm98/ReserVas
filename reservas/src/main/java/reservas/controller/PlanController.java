package reservas.controller;

import com.google.gson.Gson;
import com.google.gson.JsonParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reservas.authentication.ManagerUserSession;
import reservas.authentication.UsuarioNoLogeadoException;
import reservas.model.Cliente;
import reservas.model.Empresa;
import reservas.model.Usuario;
import reservas.model.Servicio;
import reservas.model.Plan;
import reservas.service.ClienteService;
import reservas.service.EmpresaService;
import reservas.service.ServicioService;
import reservas.service.UsuarioService;
import reservas.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sun.security.util.SecurityConstants;


import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

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

}
