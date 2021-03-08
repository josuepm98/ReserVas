package reservas.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name = "usuario")
public class Usuario{

    @Id
    @NotNull
    public String nombreUser;
    @NotNull
    public String email;
    @NotNull
    public String nombre;
    @NotNull
    public String apellidos;
    @NotNull
    public String password;

    // Constructor vacío necesario para JPA/Hibernate.
    // Lo hacemos privado para que no se pueda usar desde el código de la aplicación. Para crear un
    // usuario en la aplicación habrá que llamar al constructor público. Hibernate sí que lo puede usar, a pesar
    // de ser privado.
    public Usuario() {}

    // Constructor público con nombreUser por parámetro
    public Usuario(String nombreUser) {
        this.nombreUser = nombreUser;
    }

    //getters and setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombreUser() {
        return nombreUser;
    }

    public void setNombreUser(String nombreUser) {
        this.nombreUser = nombreUser;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //equals basado en el nombreUser
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;

        return nombreUser.equals(usuario.nombreUser);
    }

    @Override
    public int hashCode() {
        // Generamos un hash basado en el nombreUser
        return Objects.hash(nombreUser);
    }
}