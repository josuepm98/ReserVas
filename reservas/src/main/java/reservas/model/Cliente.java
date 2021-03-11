package reservas.model;

import reservas.service.ClienteService;

public class Cliente extends Usuario{

    private String fechaNacimiento;

    public Cliente() {super();}

    public Cliente(String nombreUser, String password, String nombre, String apellidos, String email, String fechaNacimiento) {
        super(nombreUser, password, nombre, apellidos, email);
        this.fechaNacimiento = fechaNacimiento;
    }

    //getters and setters
    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public boolean crearCliente() {
        ClienteService cliente = new ClienteService();
        return cliente.crearCliente(this);
    }

    public boolean eliminarCliente() {
        return super.eliminarUsuario();
    }


}
