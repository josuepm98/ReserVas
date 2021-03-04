package reservas.authentication;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//excepcion para controlar el acceso a la página
@ResponseStatus(value = HttpStatus.UNAUTHORIZED, reason="Usuario no autorizado")
public class UsuarioNoLogeadoException extends RuntimeException{
}
