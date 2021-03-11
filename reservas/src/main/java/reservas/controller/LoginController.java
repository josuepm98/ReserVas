package reservas.controller;

import reservas.authentication.ManagerUserSession;
import reservas.model.Cliente;
import reservas.model.Usuario;
import reservas.model.Empresa;
import reservas.service.ClienteService;
import reservas.service.EmpresaService;
import reservas.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
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
    public String home(Model model) {
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String loginForm(Model model) {
        model.addAttribute("loginData", new LoginData());
        return "formLogin";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute LoginData loginData, Model model, RedirectAttributes flash, HttpSession session) {

        String nombreUser = loginData.getNombreUser();
        // Llamada al servicio para comprobar si el login es correcto
        boolean loginStatus = usuarioService.autenticacion(nombreUser, loginData.getPassword());


        if (loginStatus) {
            managerUserSesion.logearUsuario(session, nombreUser);
            /* Aqui deberiamos ver si es empresa o cliente, y segun lo que sea, devolver un redirect u otro
            if(){
                return "redirect:/cliente";
            }
            else{
                return "redirect:/empresa";
            }*/
        } else {
            model.addAttribute("error", "Nombre de usuario o contraseña incorrectos");
            return "formLogin";
        }
        return "formLogin";
    }

    @GetMapping("/registroCliente")
    public String registroClienteForm(Model model) {
        model.addAttribute("registroClienteData", new RegistroClienteData());
        return "formRegistroCliente";
    }

    @PostMapping("/registroCliente")
    public String registroCliente(@Valid RegistroClienteData registroData, BindingResult result, Model model) {

        if (result.hasErrors()) {
            return "formRegistroCliente";
        }
        boolean existeUsuario = usuarioService.existe(registroData.getNombreUser());

        if (existeUsuario) {
            model.addAttribute("registroClienteData", registroData);
            model.addAttribute("error", "El usuario " + registroData.getNombreUser() + " ya existe");
            return "formRegistroCliente";
        }

        Cliente cliente = new Cliente(registroData.getNombreUser(), registroData.getPassword(), registroData.getNombre(), registroData.getApellidos(), registroData.getEmail(), registroData.getFechaNacimiento());
        clienteService.crearCliente(cliente);
        return "redirect:/login";
    }

    @GetMapping("/registroEmpresa")
    public String registroEmpresaForm(Model model) {
        model.addAttribute("registroEmpresaData", new RegistroEmpresaData());
        return "formRegistroEmpresa";
    }

    @PostMapping("/registroEmpresa")
    public String registroEmpresa(@Valid RegistroEmpresaData registroData, BindingResult result, Model model) {

        if (result.hasErrors()) {
            return "formRegistroEmpresa";
        }
        boolean existeUsuario = usuarioService.existe(registroData.getNombreUser());

        if (existeUsuario) {
            model.addAttribute("registroEmpresaData", registroData);
            model.addAttribute("error", "La empresa " + registroData.getNombreUser() + " ya existe");
            return "formRegistroEmpresa";
        }

        Empresa empresa = new Empresa(registroData.getNombreUser(), registroData.getPassword(), registroData.getNombre(), registroData.getApellidos(), registroData.getEmail(), registroData.getDireccion());
        empresaService.crearEmpresa(empresa);
        return "redirect:/login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.setAttribute("nombreUserLogeado", null);
        return "redirect:/login";
    }
}