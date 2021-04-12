package reservas;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import reservas.model.Categoria;
import reservas.model.Cliente;
import reservas.service.CategoriaService;

public class CategoriaTest {

    @Test
    public void testExiste1() {
        // Debe dar true ya que buscamos una categoria que SÍ existe
        Categoria categoria = new Categoria("Peluqueria");
        boolean resultadoReal = categoria.existe();
        assertTrue(resultadoReal);
    }
    
    @Test
    public void testCrearCategoria() {
        // Este test prueba que se crea correctamente una categoria

    	Categoria categoria = new Categoria("Masaje");
        boolean resultadoReal = categoria.existe();
        assertFalse(resultadoReal);

        // Debe dar true ya que no hay error al crear
        resultadoReal = categoria.crearCategoria();
        assertTrue(resultadoReal);

        // Debe dar true ya que ahora SÍ existe
        resultadoReal = categoria.existe();
        assertTrue(resultadoReal);


       // Para dejar la BD igual procedemos a eliminarlo

        resultadoReal = categoria.eliminarCategoria();
        assertTrue(resultadoReal);
        // Ya no existe
        resultadoReal = categoria.existe();
        assertFalse(resultadoReal);
    }
    @Test
    public void testGetCategorias() {
    
    	CategoriaService cService = new CategoriaService(); 
    	List<Categoria> resultadoEsperado = new ArrayList<>();
    	resultadoEsperado.add(new Categoria("Peluqueria"));
    	resultadoEsperado.add(new Categoria("Spa"));

    	System.out.println(cService.getCategorias());
    	assertEquals(resultadoEsperado,cService.getCategorias());
    }
}
