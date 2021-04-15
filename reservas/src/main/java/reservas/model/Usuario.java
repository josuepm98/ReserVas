package reservas.model;

import reservas.service.UsuarioService;

import java.util.Objects;

public class Usuario{

    public String nombreUser;
    public String password;
    public String nombre;
    public String apellidos;
    public String email;
    public String img;

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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public boolean eliminarUsuario() {
        UsuarioService usuario = new UsuarioService();
        return usuario.eliminarUsuario(this);
    }

    public boolean existe() {
        UsuarioService usuario = new UsuarioService();
        return usuario.existe(nombreUser);
    }

    public boolean autenticacion() {
        UsuarioService usuario = new UsuarioService();
        return usuario.autenticacion(nombreUser, password);
    }

    /*public Usuario getUsuario(String nombreUser){
        UsuarioService usuario = new UsuarioService();
        return usuario.getUsuario(nombreUser);
    }*/

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