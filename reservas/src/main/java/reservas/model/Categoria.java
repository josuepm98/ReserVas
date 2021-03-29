package reservas.model;

import reservas.service.CategoriaService;
import reservas.service.UsuarioService;
public class Categoria {
	private String nombre;
	
	
	
	public Categoria(){ }
	public Categoria(String nombre) {
		this.nombre=nombre;	
	}
    public String getNombre() {
        return nombre;
    }
    public boolean crearCategoria() {
        CategoriaService categoria = new CategoriaService();
        return categoria.crearCategoria(this);
    }
    
    public void setNombre(String nombre) {
        this.nombre=nombre;
    }
    public boolean existe() {
        CategoriaService categoria = new CategoriaService();
        return categoria.existe(nombre);
    }
    public boolean eliminarCategoria() {
    	CategoriaService categoria = new CategoriaService();
        return categoria.eliminarCategoria(this);
    }
    
	

}
