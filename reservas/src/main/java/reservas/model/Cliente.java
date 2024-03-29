package reservas.model;

import reservas.service.ClienteService;
import reservas.service.EmpresaService;

public class Cliente extends Usuario{

    public String fechaNac;

    public Cliente() {super();}

    public Cliente(String nombreUser, String password, String nombre, String apellidos, String email, String fechaNac) {
        super(nombreUser, password, nombre, apellidos, email);
        this.fechaNac = fechaNac;
    }

    //getters and setters
    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    public boolean crearCliente() {
        ClienteService cliente = new ClienteService();
        return cliente.crearCliente(this);
    }

    public boolean eliminarCliente() {
        return super.eliminarUsuario();
    }

    public Cliente getCliente(){
        ClienteService cliente = new ClienteService();
        return cliente.getCliente(this.getNombreUser());
    }
    
}
