package reservas.authentication;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

@Component
public class ManagerUserSession {

    // Añadimos el nombreUser de usuario en la sesión HTTP para hacer
    // una autorización sencilla. En los métodos de controllers
    // comprobamos si el nombreUser del usuario logeado coincide con el obtenido
    // desde la URL
    public void logearUsuario(HttpSession session, String nombreUser) {
        session.setAttribute("nombreUserLogeado", nombreUser);
    }

    public void comprobarUsuarioLogeado(HttpSession session, String nombreUser) {
        String nombreUserLogeado = (String) session.getAttribute("nombreUserLogeado");
        if (!nombreUser.equals(nombreUserLogeado))
            throw new UsuarioNoLogeadoException();
    }
}
