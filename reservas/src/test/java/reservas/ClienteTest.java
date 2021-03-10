package reservas;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import reservas.model.Usuario;
import reservas.model.Cliente;
import static org.junit.Assert.assertEquals;

public class ClienteTest {

    @Test
    public void testExiste1() {
        // Debe dar true ya que buscamos un usuario que SÍ existe
        Cliente cliente = new Cliente("taesCliente", "taes", "TaesCliente", "Taes Taes", "taesCliente@gmail.com", "2000-05-10");
        boolean resultadoEsperado = true;
        boolean resultadoReal = cliente.existe();
        assertEquals(resultadoEsperado, resultadoReal);
    }

    @Test
    public void testExiste2() {
        // Debe dar false ya que buscamos un usuario que NO existe
        Cliente cliente = new Cliente("noExiste", "taes", "TaesCliente", "Taes Taes", "taesCliente@gmail.com", "2000-05-10");
        boolean resultadoEsperado = false;
        boolean resultadoReal = cliente.existe();
        assertEquals(resultadoEsperado, resultadoReal);
    }

    @Test
    public void testAutenticacion1() {
        // Debe dar true ya que el usuario existe y la contraseña está bien
        Cliente cliente = new Cliente("taesCliente", "taes", "TaesCliente", "Taes Taes", "taesCliente@gmail.com", "2000-05-10");
        boolean resultadoEsperado = true;
        boolean resultadoReal = cliente.autenticacion();
        assertEquals(resultadoEsperado, resultadoReal);
    }

    @Test
    public void testAutenticacion2() {
        // Debe dar false ya que el usuario existe pero la contraseña está mal
        Cliente cliente = new Cliente("taesCliente", "errorPassword", "TaesCliente", "Taes Taes", "taesCliente@gmail.com", "2000-05-10");
        boolean resultadoEsperado = false;
        boolean resultadoReal = cliente.autenticacion();
        assertEquals(resultadoEsperado, resultadoReal);
    }

    @Test
    public void testCrearCliente() {
        // Este test prueba que se crea correctamente los clientes

        Cliente cliente = new Cliente("taesNuevo", "taes", "TaesNuevo", "Taes Nuevo", "taesNuevo@gmail.com", "2000-05-10");

        // Debe dar false ya que el usuario NO existe
        boolean resultadoEsperado = false;
        boolean resultadoReal = cliente.existe();
        assertEquals(resultadoEsperado, resultadoReal);

        // Debe dar true ya que no hay error al crear
        resultadoEsperado = true;
        resultadoReal = cliente.crearCliente();
        assertEquals(resultadoEsperado, resultadoReal);

        // Debe dar true ya que ahora SÍ existe
        resultadoEsperado = true;
        resultadoReal = cliente.existe();
        assertEquals(resultadoEsperado, resultadoReal);

        // Para dejar la BD igual procedemos a eliminarlo
        resultadoEsperado = true;
        resultadoReal = cliente.eliminarCliente();
        assertEquals(resultadoEsperado, resultadoReal);

        // Ya no existe
        resultadoEsperado = false;
        resultadoReal = cliente.existe();
        assertEquals(resultadoEsperado, resultadoReal);
    }

}
