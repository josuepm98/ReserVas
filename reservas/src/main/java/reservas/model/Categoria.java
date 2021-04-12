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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
    
	

}
