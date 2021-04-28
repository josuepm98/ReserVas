package reservas;

import org.junit.Test;
import reservas.model.Cliente;
import reservas.model.Empresa;
import reservas.service.ClienteService;
import reservas.service.EmpresaService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class EmpresaTest {

    ClienteService clienteService = new ClienteService();
    EmpresaService empresaService = new EmpresaService();

    @Test
    public void testExiste1() {
        // Debe dar true ya que buscamos una empresa que SÍ existe
        Empresa empresa = new Empresa("empresaPeluqueria", "password", "Peluqueria",
                "Peluqueria Peluqueria", "peluqueria@gmail.com", "San Vicente", "Peluqueria");
        boolean resultadoEsperado = true;
        boolean resultadoReal = empresa.existe();
        assertEquals(resultadoEsperado, resultadoReal);
    }

    @Test
    public void testExiste2() {
        // Debe dar false ya que buscamos una empresa que NO existe
        Empresa empresa = new Empresa("noExiste", "taes", "TaesCliente", "Taes Taes",
                "taesCliente@gmail.com", "Aspe", "Peluqueria");
        boolean resultadoEsperado = false;
        boolean resultadoReal = empresa.existe();
        assertEquals(resultadoEsperado, resultadoReal);
    }

    @Test
    public void testAutenticacion1() {
        // Debe dar true ya que la empresa existe y la contraseña está bien
        Empresa empresa = new Empresa("empresaGimnasio1", "password", "Gimnasio1",
                "Gimnasio1 Gimnasio1", "gimnasio1@gmail.com", "Alicante", "Gimnasio");
        boolean resultadoEsperado = true;
        boolean resultadoReal = empresa.autenticacion();
        assertEquals(resultadoEsperado, resultadoReal);
    }

    @Test
    public void testAutenticacion2() {
        // Debe dar false ya que la empresa existe pero la contraseña está mal
        Empresa empresa = new Empresa("empresaGimnasio2", "errorPassword", "Gimnasio2",
                "Gimnasio2 Gimnasio2", "gimnasio2@gmail.com", "Elda", "Gimnasio");
        boolean resultadoEsperado = false;
        boolean resultadoReal = empresa.autenticacion();
        assertEquals(resultadoEsperado, resultadoReal);
    }

    @Test
    public void testCrearEmpresa() {
        // Este test prueba que se crea correctamente las empresas

        Empresa empresa = new Empresa("taesNuevo", "taes", "TaesNuevo", "Taes Nuevo",
                "taesNuevo@gmail.com", "Aspe", "Peluqueria");

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

    @Test
    public void getEmpresaTest(){
        Empresa empresa = new Empresa();
        empresa.setNombreUser("empresaRestaurante");
        String resultadoEsperado = "Restaurante";
        String resultadoReal = empresa.getEmpresa().getNombre();
        assertEquals(resultadoEsperado, resultadoReal);
    }

    @Test
    public void testGetClientesEmpresa() {
        List<Cliente> resultadoEsperado = new ArrayList<>();
        Cliente cliente;
        cliente = clienteService.getCliente("clienteJose");
        resultadoEsperado.add(cliente);
        cliente = clienteService.getCliente("clienteJosue");
        resultadoEsperado.add(cliente);
        List<Cliente> resultadoReal = empresaService.getClientesEmpresa("empresaPeluqueria");

        assertTrue(resultadoReal.size()==resultadoEsperado.size());
        for (int i = 0; i < resultadoEsperado.size(); i++) {
            assertTrue(resultadoEsperado.contains(resultadoReal.get(i)));
        }
    }

    @Test
    public void getHoraTexto(){
        String tiempo = "09:20";
        String resultadoEsperado = "09";
        EmpresaService empresa = new EmpresaService();
        String resultadoReal = empresa.getHoraTexto(tiempo);
        assertEquals(resultadoEsperado, resultadoReal);
    }

    @Test
    public void getHora2Texto(){
        String tiempo = "22:20";
        String resultadoEsperado = "22";
        EmpresaService empresa = new EmpresaService();
        String resultadoReal = empresa.getHoraTexto(tiempo);
        assertEquals(resultadoEsperado, resultadoReal);
    }

    @Test
    public void getMinutosTexto(){
        String tiempo = "09:25";
        String resultadoEsperado = "25";
        EmpresaService empresa = new EmpresaService();
        String resultadoReal = empresa.getMinutosTexto(tiempo);
        assertEquals(resultadoEsperado, resultadoReal);
    }

    @Test
    public void getMinutos2Texto(){
        String tiempo = "22:05";
        String resultadoEsperado = "05";
        EmpresaService empresa = new EmpresaService();
        String resultadoReal = empresa.getMinutosTexto(tiempo);
        assertEquals(resultadoEsperado, resultadoReal);
    }

    @Test
    public void getHora(){
        String tiempo = "09:20";
        int resultadoEsperado = 9;
        EmpresaService empresa = new EmpresaService();
        int resultadoReal = empresa.getHora(tiempo);
        assertEquals(resultadoEsperado, resultadoReal);
    }

    @Test
    public void getHora2(){
        String tiempo = "22:20";
        int resultadoEsperado = 22;
        EmpresaService empresa = new EmpresaService();
        int resultadoReal = empresa.getHora(tiempo);
        assertEquals(resultadoEsperado, resultadoReal);
    }

    @Test
    public void getMinutos(){
        String tiempo = "09:25";
        int resultadoEsperado = 25;
        EmpresaService empresa = new EmpresaService();
        int resultadoReal = empresa.getMinutos(tiempo);
        assertEquals(resultadoEsperado, resultadoReal);
    }

    @Test
    public void getMinutos2(){
        String tiempo = "22:05";
        int resultadoEsperado = 05;
        EmpresaService empresa = new EmpresaService();
        int resultadoReal = empresa.getMinutos(tiempo);
        assertEquals(resultadoEsperado, resultadoReal);
    }

}
