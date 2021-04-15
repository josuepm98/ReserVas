package reservas.controller;

import com.google.gson.Gson;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reservas.authentication.ManagerUserSession;
import reservas.model.Cliente;
import reservas.model.Empresa;
import reservas.model.Servicio;
import reservas.model.Usuario;
import reservas.service.ClienteService;
import reservas.service.EmpresaService;
import reservas.service.ServicioService;
import reservas.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sun.security.util.SecurityConstants;


import javax.servlet.http.HttpSession;

@CrossOrigin(origins = "http://localhost:19006", methods= {RequestMethod.GET,RequestMethod.POST})
@RestController
public class ClienteController {

    @Autowired
    ServicioService servicioService;

    @Autowired
    ClienteService clienteService;

    @Autowired
    ServicioService usuarioService;

    @Autowired
    ManagerUserSession managerUserSesion;

    //MOSTRAR TODOS CLIENTES
    @GetMapping("/clientes")
    public ResponseEntity<?> allClientes(HttpSession session) {
        String nombreUsuarioLogeado = (String) session.getAttribute("nombreUserLogeado");

        if(nombreUsuarioLogeado == null){
            return new ResponseEntity<>("Usuario no autorizado, debes iniciar sesión", HttpStatus.UNAUTHORIZED);
        }

        List<Cliente> clientes = clienteService.getClientes(); //TENEMOS QUE DEVOLVER LA SELECT DE CLIENTES Y PASARLA AL FRONT COMO JSON
        //NO SE POR QUE MUESTRA ANTES LA FECHA QUE EL NOMBRE EN EL JSON
        Gson gson =  new Gson();
        String json = gson.toJson(clientes);

        return new ResponseEntity<>(json ,HttpStatus.OK);
    }




}
