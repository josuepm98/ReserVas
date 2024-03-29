package reservas.controller;

import com.google.gson.Gson;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reservas.authentication.ManagerUserSession;
import reservas.authentication.UsuarioNoLogeadoException;
import reservas.model.Cliente;
import reservas.model.Empresa;
import reservas.model.Servicio;
import reservas.model.Usuario;
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
        //managerUserSesion.comprobarUsuarioLogeado(session, nombreUser);

        Empresa empresa = new Empresa();
        empresa.setNombreUser(nombreUser);
        empresa = empresa.getEmpresa();

        List<Cliente> clientes = empresa.getClientesEmpresa(); //TENEMOS QUE DEVOLVER LA SELECT DE CLIENTES Y PASARLA AL FRONT COMO JSON
        Gson gson =  new Gson();
        String json = gson.toJson(clientes);

        return new ResponseEntity<>(json ,HttpStatus.OK);
    }

    @GetMapping("/{category}/stores") //NO SE LA RUTA QUE PEDIRAN
    public ResponseEntity<?> empresasCategoria(@PathVariable(value="category") String categoryName, HttpSession session) {
        /*String nombreUsuarioLogeado = (String) session.getAttribute("nombreUserLogeado");

        if(nombreUsuarioLogeado == null){
            throw new UsuarioNoLogeadoException();
        }*/

        List<Empresa> empresas = empresaService.getEmpresasPorCategoria(categoryName); //DEVOLVEMOS LA SELECT DE SERVICIO Y PASARLA AL FRONT COMO JSON

        Gson gson =  new Gson();
        String json = gson.toJson(empresas);

        return new ResponseEntity<>(json ,HttpStatus.OK);
    }

    //ESTABLECER HORARIOS EMPRESA
    @PostMapping("/establishTimetable/{nombreUser}")
    public ResponseEntity<?> establecerHorario(@PathVariable(value="nombreUser") String nombreUser, @RequestBody Empresa empresa){
        String inicioJornada = empresa.getInicioJornada();
        String finJornada = empresa.getFinJornada();
        String tiempoServicio = empresa.getTiempoServicio();

        boolean establecer = false;

        establecer = empresaService.establecerHorarioEmpresa(nombreUser, inicioJornada, finJornada, tiempoServicio);

        if(establecer){
            return new ResponseEntity<>("Horario establecido correctamente" ,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("No se ha podido establecer el horario", HttpStatus.OK);
        }
    }

    @PostMapping("/generateDay/{nombreUser}")
    public ResponseEntity<?> generarDia(@PathVariable(value="nombreUser") String nombreUser, @RequestBody Servicio servicio){
        String nombreServicio = servicio.getNombre();
        String direccionServicio = servicio.getDireccion();
        double precio = servicio.getPrecio();
        String fecha = servicio.getFecha();
        Empresa empresa = empresaService.getEmpresa(nombreUser);

        boolean generar = false;

        generar = empresaService.generarDia(empresa, nombreServicio, direccionServicio, precio, fecha);

        if(generar){
            return new ResponseEntity<>("Día generado correctamente" ,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("No se ha podido generar este día porque ya tiene servicios", HttpStatus.OK);
        }
    }
}
