package reservas.authentication;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

@Component
public class ManagerUserSession {

    // Añadimos el id de usuario en la sesión HTTP para hacer
    // una autorización sencilla. En los métodos de controllers
    // comprobamos si el id del usuario logeado coincide con el obtenido
    // desde la URL
    public void logearUsuario(HttpSession session, String emailUsuario) {
        session.setAttribute("emailUsuarioLogeado", emailUsuario);
    }

    public void comprobarUsuarioLogeado(HttpSession session, String emailUsuario) {
        String emailUsuarioLogeado = (String) session.getAttribute("emailUsuarioLogeado");
        if (!emailUsuario.equals(emailUsuarioLogeado))
            throw new UsuarioNoLogeadoException();
    }
}
