package reservas.controller;

import com.google.gson.Gson;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reservas.authentication.ManagerUserSession;
import reservas.authentication.UsuarioNoLogeadoException;
import reservas.model.Servicio;
import reservas.service.ServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import javax.servlet.http.HttpSession;

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

    //TODOS LOS SERVICIOS (TANTO LIBRES COMO RESERVADOS) DE UNA EMPRESA EN CONCRETO
    @GetMapping("/stores/{nombreUser}/services") //NO SE LA RUTA QUE PEDIRAN
    public ResponseEntity<?> serviciosEmpresa(@PathVariable(value="nombreUser") String nombreUser, Model model, HttpSession session) {
        managerUserSesion.comprobarUsuarioLogeado(session, nombreUser);

        List<Servicio> services = servicioService.getServicios(nombreUser, 1); //DEVOLVEMOS LA SELECT DE SERVICIOS Y PASARLA AL FRONT COMO JSON

        Gson gson =  new Gson();
        String json = gson.toJson(services);

        return new ResponseEntity<>(json ,HttpStatus.OK);
    }

    @GetMapping("/stores/services/disponibles/{nombreUser}") //NO SE LA RUTA QUE PEDIRAN
    public ResponseEntity<?> serviciosLibresEmpresa(@PathVariable(value="nombreUser") String nombreUser, Model model, HttpSession session) {
        String nombreUsuarioLogeado = (String) session.getAttribute("nombreUserLogeado");

        if(nombreUsuarioLogeado == null){
            throw new UsuarioNoLogeadoException();
        }

        List<Servicio> services = servicioService.getServiciosLibres(nombreUser); //DEVOLVEMOS LA SELECT DE SERVICIOS Y PASARLA AL FRONT COMO JSON

        Gson gson =  new Gson();
        String json = gson.toJson(services);

        return new ResponseEntity<>(json ,HttpStatus.OK);
    }

    @GetMapping("/services/{id}") //NO SE LA RUTA QUE PEDIRAN
    public ResponseEntity<?> servicioInfo(@PathVariable(value="id") Integer idService, HttpSession session) {
        String nombreUsuarioLogeado = (String) session.getAttribute("nombreUserLogeado");

        if(nombreUsuarioLogeado == null){
            throw new UsuarioNoLogeadoException();
        }

        //DEVOLVEMOS LA SELECT DE SERVICIO Y PASARLA AL FRONT COMO JSON
        Servicio service = new Servicio();
        service.setId(idService);
        service = service.getService();

        //Servicio service = servicioService.getService(idService);

        if(service.id == 0 && service.precio == 0.0){
            return new ResponseEntity<>("No existe ningún servicio con ese ID", HttpStatus.NOT_FOUND);
        }

        Gson gson =  new Gson();
        String json = gson.toJson(service);

        return new ResponseEntity<>(json ,HttpStatus.OK);
    }

    /*@GetMapping("/{category}/services") //NO SE LA RUTA QUE PEDIRAN
    public ResponseEntity<?> serviciosCategoria(@PathVariable(value="category") String categoryName, HttpSession session) {
        String nombreUsuarioLogeado = (String) session.getAttribute("nombreUserLogeado");

        if(nombreUsuarioLogeado == null){
            throw new UsuarioNoLogeadoException();
        }

        List<Servicio> services = servicioService.getServiciosPorCategoria(categoryName); //DEVOLVEMOS LA SELECT DE SERVICIO Y PASARLA AL FRONT COMO JSON

        Gson gson =  new Gson();
        String json = gson.toJson(services);

        return new ResponseEntity<>(json ,HttpStatus.OK);
    }*/

    @DeleteMapping("/services/{id}/delete")
    public String deleteServicio(@PathVariable(value="id") Integer idService, HttpSession session){
        String nombreUsuarioLogeado = (String) session.getAttribute("nombreUserLogeado");

        if(nombreUsuarioLogeado == null){
            throw new UsuarioNoLogeadoException();
        }

        Servicio servicio = servicioService.getService(idService);

        if(servicioService.deleteService(servicio)) {
            return "redirect:/stores/" + nombreUsuarioLogeado + "/services";
        }else{
            return "No existe ningun servicio con ese ID";
        }
    }

    //CREAR SERVICIO
    //@PostMapping

    //MOSTRAR RUTAS
    //@GetMapping

}
