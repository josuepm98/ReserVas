package reservas.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reservas.authentication.ManagerUserSession;
import reservas.model.Cliente;
import reservas.model.Empresa;
import reservas.model.Usuario;
import reservas.service.ClienteService;
import reservas.service.EmpresaService;
import reservas.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@CrossOrigin(origins = "http://localhost:19006", methods= {RequestMethod.GET,RequestMethod.POST})
@RestController
public class LoginController {

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    ClienteService clienteService;

    @Autowired
    EmpresaService empresaService;

    @Autowired
    ManagerUserSession managerUserSesion;

    @GetMapping("/")
    public ResponseEntity<String> home() {
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

    @GetMapping("/login")
    public ResponseEntity<String> loginForm() {
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Usuario usuario, Model model, HttpSession session) {

        String nombreUser = usuario.getNombreUser();
        // Llamada al servicio para comprobar si el login es correcto
        boolean loginStatus = usuarioService.autenticacion(nombreUser, usuario.getPassword());

        if (loginStatus) {
            managerUserSesion.logearUsuario(session, nombreUser);
        } else {
            //model.addAttribute("error", "Nombre de usuario o contraseña incorrectos");
            return new ResponseEntity<>("Nombre de usuario o contraseña incorrectos", HttpStatus.OK);
        }
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

    @GetMapping("/registroCliente")
    public ResponseEntity<String> registroClienteForm() {
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

    @PostMapping("/registroCliente")
    public ResponseEntity<String> registroCliente(@RequestBody Cliente cliente, Model model) {
        boolean existeUsuario = usuarioService.existe(cliente.getNombreUser());

        if (existeUsuario) {
            model.addAttribute("registroCliente", cliente);
            return new ResponseEntity<>("Error, ya existe un usuario con ese nombre de usuario.", HttpStatus.OK);
        }

        clienteService.crearCliente(cliente);

        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

    @GetMapping("/registroEmpresa")
    public ResponseEntity<String> registroEmpresaForm() {
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

    @PostMapping("/registroEmpresa")
    public ResponseEntity<String> registroEmpresa(@RequestBody Empresa empresa, Model model) {
        boolean existeEmpresa = empresaService.existe(empresa.getNombreUser());

        if (existeEmpresa) {
            model.addAttribute("registroEmpresa", empresa);
            return new ResponseEntity<>("Error, ya existe un usuario con ese nombre de usuario.", HttpStatus.OK);
        }

        empresaService.crearEmpresa(empresa);

        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

    @GetMapping("/logout")
    public ResponseEntity<String> logout(HttpSession session) {
        session.setAttribute("nombreUserLogeado", null);
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }
}