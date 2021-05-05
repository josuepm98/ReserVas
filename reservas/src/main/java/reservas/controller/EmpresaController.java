package reservas.controller;

import com.google.gson.Gson;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reservas.authentication.ManagerUserSession;
import reservas.model.Cliente;
import reservas.model.Empresa;
import reservas.service.ClienteService;
import reservas.service.EmpresaService;
import reservas.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import javax.servlet.http.HttpSession;

@CrossOrigin(origins = "http://localhost:19006", methods= {RequestMethod.GET,RequestMethod.POST})
@RestController
public class EmpresaController {
    @Autowired
    UsuarioService usuarioService;

    @Autowired
    ClienteService clienteService;

    @Autowired
    EmpresaService empresaService;

    @Autowired
    ManagerUserSession managerUserSesion;


    //MOSTRAR CLIENTES RELACIONADOS CON EMPRESA
    @GetMapping("/stores/{nombreUser}/clientes")
    public ResponseEntity<?> clientesEmpresa(@PathVariable(value="nombreUser") String nombreUser, HttpSession session) {
        managerUserSesion.comprobarUsuarioLogeado(session, nombreUser);

        Empresa empresa = new Empresa();
        empresa.setNombreUser(nombreUser);
        empresa = empresa.getEmpresa();

        List<Cliente> clientes = empresa.getClientesEmpresa(); //TENEMOS QUE DEVOLVER LA SELECT DE CLIENTES Y PASARLA AL FRONT COMO JSON
        Gson gson =  new Gson();
        String json = gson.toJson(clientes);

        return new ResponseEntity<>(json ,HttpStatus.OK);
    }
}
