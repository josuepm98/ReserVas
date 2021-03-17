package reservas;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import reservas.model.Empresa;
import static org.junit.Assert.assertEquals;

public class EmpresaTest {

    @Test
    public void testExiste1() {
        // Debe dar true ya que buscamos una empresa que SÍ existe
        Empresa empresa = new Empresa("taesEmpresa", "taes", "TaesCliente", "Taes Taes", "taesCliente@gmail.com", "Aspe");
        boolean resultadoEsperado = true;
        boolean resultadoReal = empresa.existe();
        assertEquals(resultadoEsperado, resultadoReal);
    }

    @Test
    public void testExiste2() {
        // Debe dar false ya que buscamos una empresa que NO existe
        Empresa empresa = new Empresa("noExiste", "taes", "TaesCliente", "Taes Taes", "taesCliente@gmail.com", "Aspe");
        boolean resultadoEsperado = false;
        boolean resultadoReal = empresa.existe();
        assertEquals(resultadoEsperado, resultadoReal);
    }

    @Test
    public void testAutenticacion1() {
        // Debe dar true ya que la empresa existe y la contraseña está bien
        Empresa empresa = new Empresa("taesEmpresa", "taes", "TaesCliente", "Taes Taes", "taesCliente@gmail.com", "Aspe");
        boolean resultadoEsperado = true;
        boolean resultadoReal = empresa.autenticacion();
        assertEquals(resultadoEsperado, resultadoReal);
    }

    @Test
    public void testAutenticacion2() {
        // Debe dar false ya que la empresa existe pero la contraseña está mal
        Empresa empresa = new Empresa("taesEmpresa", "errorPassword", "TaesCliente", "Taes Taes", "taesCliente@gmail.com", "Aspe");
        boolean resultadoEsperado = false;
        boolean resultadoReal = empresa.autenticacion();
        assertEquals(resultadoEsperado, resultadoReal);
    }

    @Test
    public void testCrearEmpresa() {
        // Este test prueba que se crea correctamente las empresas

        Empresa empresa = new Empresa("taesNuevo", "taes", "TaesNuevo", "Taes Nuevo", "taesNuevo@gmail.com", "Aspe");

        // Debe dar false ya que la empresa NO existe
        boolean resultadoEsperado = false;
        boolean resultadoReal = empresa.existe();
        assertEquals(resultadoEsperado, resultadoReal);

        // Debe dar true ya que no hay error al crear
        resultadoEsperado = true;
        resultadoReal = empresa.crearEmpresa();
        assertEquals(resultadoEsperado, resultadoReal);

        // Debe dar true ya que ahora SÍ existe
        resultadoEsperado = true;
        resultadoReal = empresa.existe();
        assertEquals(resultadoEsperado, resultadoReal);

        // Para dejar la BD igual procedemos a eliminarlo
        resultadoEsperado = true;
        resultadoReal = empresa.eliminarEmpresa();
        assertEquals(resultadoEsperado, resultadoReal);

        // Ya no existe
        resultadoEsperado = false;
        resultadoReal = empresa.existe();
        assertEquals(resultadoEsperado, resultadoReal);
    }

}
