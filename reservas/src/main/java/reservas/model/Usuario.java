package reservas.model;

import reservas.service.UsuarioService;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

public class Usuario{

    public String nombreUser;
    public String password;
    public String nombre;
    public String apellidos;
    public String email;

    // Constructor vacío necesario para JPA/Hibernate.
    // Lo hacemos privado para que no se pueda usar desde el código de la aplicación. Para crear un
    // usuario en la aplicación habrá que llamar al constructor público. Hibernate sí que lo puede usar, a pesar
    // de ser privado.
    public Usuario() {}

    // Constructor público con todos los parámetros para evitar valores nulos.
    public Usuario(String nombreUser, String password, String nombre, String apellidos, String email) {
        this.nombreUser = nombreUser;
        this.password = password;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
    }

    //getters and setters
    public String getNombreUser() {
        return nombreUser;
    }

    public void setNombreUser(String nombreUser) {
        this.nombreUser = nombreUser;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean createUser() {
        UsuarioService usuario = new UsuarioService();
        return usuario.createUser(this);
    }

    public boolean deleteUser() {
        UsuarioService usuario = new UsuarioService();
        return usuario.deleteUser(this);
    }

    public boolean exists() {
        UsuarioService usuario = new UsuarioService();
        return usuario.exists(nombreUser);
    }

    public boolean autentication() {
        UsuarioService usuario = new UsuarioService();
        return usuario.autentication(nombreUser, password);
    }

    //Equals basado en el nombreUser
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