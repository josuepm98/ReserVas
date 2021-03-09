package reservas.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class Cliente extends Usuario{

    private String fechaNacimiento;

    public Cliente() {}

    // Constructor público con nombreUser por parámetro
    public Cliente(String nombreUser, String password, String nombre, String apellidos, String email) {
        super(nombreUser, password, nombre, apellidos, email);
    }

    //getters and setters
    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}
