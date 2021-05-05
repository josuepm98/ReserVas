package reservas.controller;

import com.google.gson.Gson;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import reservas.authentication.ManagerUserSession;
import reservas.authentication.UsuarioNoLogeadoException;
import reservas.model.Cliente;
import reservas.service.ClienteService;
import reservas.service.ServicioService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


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
            throw new UsuarioNoLogeadoException();
        }

        List<Cliente> clientes = clienteService.getClientes(); //TENEMOS QUE DEVOLVER LA SELECT DE CLIENTES Y PASARLA AL FRONT COMO JSON
        //NO SE POR QUE MUESTRA ANTES LA FECHA QUE EL NOMBRE EN EL JSON
        Gson gson =  new Gson();
        String json = gson.toJson(clientes);

        return new ResponseEntity<>(json ,HttpStatus.OK);
    }
}
