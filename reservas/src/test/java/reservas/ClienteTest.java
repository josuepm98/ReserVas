package reservas;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import reservas.model.Usuario;
import reservas.model.UsuarioRepository;
import reservas.service.UsuarioService;
import static org.junit.Assert.assertEquals;

public class ClienteTest {

    @Test
    public void testExists1() {
        // Debe dar true ya que buscamos un usuario que SÍ existe
        Usuario usuario = new Usuario("taesCliente", "taes", "TaesCliente", "Taes Taes", "taesCliente@gmail.com");
        boolean resultadoEsperado = true;
        boolean resultadoReal = usuario.exists();
        assertEquals(resultadoEsperado, resultadoReal);
    }

    @Test
    public void testExists2() {
        // Debe dar false ya que buscamos un usuario que NO existe
        Usuario usuario = new Usuario("noExiste", "taes", "TaesCliente", "Taes Taes", "taesCliente@gmail.com");
        boolean resultadoEsperado = false;
        boolean resultadoReal = usuario.exists();
        assertEquals(resultadoEsperado, resultadoReal);
    }

    @Test
    public void testAutentication1() {
        // Debe dar true ya que el usuario existe y la contraseña está bien
        Usuario usuario = new Usuario("taesCliente", "taes", "TaesCliente", "Taes Taes", "taesCliente@gmail.com");
        boolean resultadoEsperado = true;
        boolean resultadoReal = usuario.autentication();
        assertEquals(resultadoEsperado, resultadoReal);
    }

    @Test
    public void testAutentication2() {
        // Debe dar false ya que el usuario existe pero la contraseña está mal
        Usuario usuario = new Usuario("taesCliente", "errorPassword", "TaesCliente", "Taes Taes", "taesCliente@gmail.com");
        boolean resultadoEsperado = false;
        boolean resultadoReal = usuario.autentication();
        assertEquals(resultadoEsperado, resultadoReal);
    }

    @Test
    public void testCreate() {
        Usuario usuario = new Usuario("taesNuevo", "taes", "TaesNuevo", "Taes Nuevo", "taesNuevo@gmail.com");

        // Debe dar false ya que el usuario NO existe
        boolean resultadoEsperado = false;
        boolean resultadoReal = usuario.exists();
        assertEquals(resultadoEsperado, resultadoReal);

        // Debe dar true ya que no hay error al crear
        resultadoEsperado = true;
        resultadoReal = usuario.createUser();
        assertEquals(resultadoEsperado, resultadoReal);

        // Debe dar true ya que ahora SÍ existe
        resultadoEsperado = true;
        resultadoReal = usuario.exists();
        assertEquals(resultadoEsperado, resultadoReal);

        // Para dejar la BD igual procedemos a eliminarlo
        /*  ESTO SE DBERÍA DE HACER PERO EL MÉTODO DELETE DA ERROR, HAY QUE DEPURARLO
        resultadoEsperado = true;
        resultadoReal = usuario.deleteUser();
        assertEquals(resultadoEsperado, resultadoReal);

        resultadoEsperado = false;
        resultadoReal = usuario.exists();
        assertEquals(resultadoEsperado, resultadoReal);
        */
    }

}
