package reservas.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class Empresa extends Usuario{

    private String direccion;

    public Empresa() {}

    public Empresa(String nombreUser, String password, String nombre, String apellidos, String email) {
        super(nombreUser, password, nombre, apellidos, email);
    }

    //getters and setters
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

}