package reservas.controller;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reservas.authentication.ManagerUserSession;
import reservas.model.Cliente;
import reservas.model.Empresa;
import reservas.model.Usuario;
import reservas.model.Servicio;
import reservas.service.ClienteService;
import reservas.service.EmpresaService;
import reservas.service.ServicioService;
import reservas.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

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
public class ServicioController {

    @Autowired
    ServicioService servicioService;

    @Autowired
    ServicioService usuarioService;

    @Autowired
    ManagerUserSession managerUserSesion;

    @GetMapping("/servicios") //NO SE LA RUTA QUE PEDIRAN, HOME SEGURAMENTE
    public ResponseEntity<?> servicios(@RequestBody Usuario usuario, Model model, HttpSession session) {
        managerUserSesion.comprobarUsuarioLogeado(session, usuario.getNombreUser());

        //List<Servicio> services = servicioService.getServicios(); TENEMOS QUE DEVOLVER LA SELECT DE SERVICIOS Y PASARLA AL FRONT COMO JSON

        return new ResponseEntity<>(HttpStatus.OK);
    }




}
