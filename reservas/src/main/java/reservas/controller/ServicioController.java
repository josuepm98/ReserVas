package reservas.controller;

import com.google.gson.Gson;
import com.google.gson.JsonParser;
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

    @GetMapping("/users/{nombreUser}/services") //NO SE LA RUTA QUE PEDIRAN
    public ResponseEntity<?> serviciosCliente(@PathVariable(value="nombreUser") String nombreUser, Model model, HttpSession session) {
        managerUserSesion.comprobarUsuarioLogeado(session, nombreUser);

        List<Servicio> services = servicioService.getServicios(nombreUser, 0); //TENEMOS QUE DEVOLVER LA SELECT DE SERVICIOS Y PASARLA AL FRONT COMO JSON

        Gson gson =  new Gson();
        String json = gson.toJson(services);

        return new ResponseEntity<>(json ,HttpStatus.OK);
    }

    @GetMapping("/stores/{nombreUser}/services") //NO SE LA RUTA QUE PEDIRAN
    public ResponseEntity<?> serviciosEmpresa(@PathVariable(value="nombreUser") String nombreUser, Model model, HttpSession session) {
        managerUserSesion.comprobarUsuarioLogeado(session, nombreUser);

        List<Servicio> services = servicioService.getServicios(nombreUser, 1); //DEVOLVEMOS LA SELECT DE SERVICIOS Y PASARLA AL FRONT COMO JSON

        Gson gson =  new Gson();
        String json = gson.toJson(services);

        return new ResponseEntity<>(json ,HttpStatus.OK);
    }

    @GetMapping("/services/{id}") //NO SE LA RUTA QUE PEDIRAN
    public ResponseEntity<?> servicioInfo(@PathVariable(value="id") Integer idService, HttpSession session) {
        String nombreUsuarioLogeado = (String) session.getAttribute("nombreUserLogeado");

        if(nombreUsuarioLogeado == null){
            return new ResponseEntity<>("Usuario no autorizado, debes iniciar sesión", HttpStatus.UNAUTHORIZED);
        }

        Servicio service = servicioService.getService(idService); //DEVOLVEMOS LA SELECT DE SERVICIO Y PASARLA AL FRONT COMO JSON

        Gson gson =  new Gson();
        String json = gson.toJson(service);

        return new ResponseEntity<>(json ,HttpStatus.OK);
    }

    @GetMapping("/{category}/services") //NO SE LA RUTA QUE PEDIRAN
    public ResponseEntity<?> servicioInfo(@PathVariable(value="category") String categoryName, HttpSession session) {
        String nombreUsuarioLogeado = (String) session.getAttribute("nombreUserLogeado");

        if(nombreUsuarioLogeado == null){
            return new ResponseEntity<>("Usuario no autorizado, debes iniciar sesión", HttpStatus.UNAUTHORIZED);
        }

        List<Servicio> services = servicioService.getServiciosPorCategoria(categoryName); //DEVOLVEMOS LA SELECT DE SERVICIO Y PASARLA AL FRONT COMO JSON

        Gson gson =  new Gson();
        String json = gson.toJson(services);

        return new ResponseEntity<>(json ,HttpStatus.OK);
    }

    //CREAR SERVICIO
    //@PostMapping

    //MOSTRAR RUTAS
    //@GetMapping

}
