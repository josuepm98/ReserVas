package reservas.controller;

import com.google.gson.Gson;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
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

import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sun.security.util.SecurityConstants;


import javax.servlet.http.HttpSession;

//CREAR TOKENS https://www.adictosaltrabajo.com/2017/09/25/securizar-un-api-rest-utilizando-json-web-tokens/

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

    // @org.jetbrains.annotations.NotNull
    private String getJWTToken(String username) {
        String secretKey = "mySecretKey";
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList("ROLE_USER");

        String token = Jwts
                .builder()
                .setId("softtekJWT")
                .setSubject(username)
                .claim("authorities",
                        grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 600000))
                .signWith(SignatureAlgorithm.HS512,
                        secretKey.getBytes()).compact();

        return "Bearer " + token;
    }

    @GetMapping("/")
    public ResponseEntity<String> home() {
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

    @GetMapping("/login")
    public ResponseEntity<String> loginForm() {
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Usuario usuario, Model model, HttpSession session) {

        String nombreUser = usuario.getNombreUser();
        String token = "";
        // Llamada al servicio para comprobar si el login es correcto
        boolean loginStatus = usuarioService.autenticacion(nombreUser, usuario.getPassword());

        if (loginStatus) {
            token = getJWTToken(nombreUser);
            //usuario.setToken(token);

            managerUserSesion.logearUsuario(session, nombreUser);
        } else {
            return new ResponseEntity<>("Nombre de usuario o contraseña incorrectos", HttpStatus.FORBIDDEN);
        }

        Gson gson =  new Gson();

        if(clienteService.existeCliente(nombreUser)){
            Cliente cliente = clienteService.getCliente(nombreUser);
            cliente.setToken(token);
            String json = gson.toJson(cliente);
            return new ResponseEntity<>(json, HttpStatus.OK);
        }
        else {
            Empresa empresa = empresaService.getEmpresa(nombreUser);
            empresa.setToken(token);
            String json = gson.toJson(empresa);
            return new ResponseEntity<>(json, HttpStatus.OK);
        }
    }


    @PostMapping("/registerUser")
    public ResponseEntity<?> registroCliente(@RequestBody Cliente cliente, Model model) {
        boolean existeUsuario = usuarioService.existe(cliente.getNombreUser());

        if (existeUsuario) {
            return new ResponseEntity<>("Ya existe un usuario con ese nombre de usuario", HttpStatus.CONFLICT);
        }

        clienteService.crearCliente(cliente);

        return new ResponseEntity<>("Registro realizado correctamente", HttpStatus.OK);
    }


    //VER LAS RUTAS PORQUE REGISTRO EMPRESA NO EXISTE EN EL FRONT

    @PostMapping("/registerStore")
    public ResponseEntity<?> registroEmpresa(@RequestBody Empresa empresa, Model model) {
        boolean existeEmpresa = empresaService.existe(empresa.getNombreUser());

        if (existeEmpresa) {
            return new ResponseEntity<>("Ya existe una empresa con ese nombre de usuario", HttpStatus.CONFLICT);
        }

        empresaService.crearEmpresa(empresa);

        return new ResponseEntity<>("Registro realizado correctamente", HttpStatus.OK);
    }

    @GetMapping("/logout")
    public ResponseEntity<String> logout(HttpSession session) {
        session.setAttribute("nombreUserLogeado", null);
        return new ResponseEntity<>("Sesión finalizada", HttpStatus.OK);
    }
}