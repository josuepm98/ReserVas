package reservas.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reservas.model.Usuario;
import reservas.model.UsuarioRepository;

import java.sql.*;
import java.util.Optional;


@Service
public class UsuarioService {

    Logger logger = LoggerFactory.getLogger(UsuarioService.class);

    // Creamos la cadena para conectar a la BBDD
    private ConexionMySQL SQL = new ConexionMySQL();

    public enum LoginStatus {LOGIN_OK, USER_NOT_FOUND, ERROR_PASSWORD}

    private UsuarioRepository usuarioRepository;

    public boolean createUser(Usuario usuario) {
        Connection conn = SQL.conectarMySQL();  // Nos conectamos a la BBDD
        boolean resultado = false;

        try {

            if(usuario.exists()) {
                System.out.println("Ese usuario ya existe");
            }else {
                // String contrasenyaEncriptada = encript(usuario.getPassword());  // Esta línea será para encriptar cuando tengamos el método
                String contrasenyaEncriptada = usuario.getPassword();

                String query = "insert into usuario values ('" + usuario.getNombreUser() + "', '" + contrasenyaEncriptada + "', '" +
                        usuario.getNombre() + "', '" + usuario.getApellidos() + "', '" + usuario.getEmail() + "');";

                PreparedStatement comando = conn.prepareStatement(query);
                if(comando.executeUpdate() > 0) {  // Se ha insertado el usuario
                    resultado = true;
                }
            }
            return resultado;

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Se ha producido un error.");
            return resultado;
        } finally {
            try {
                if(conn != null){
                    conn.close();
                }
            } catch (SQLException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public boolean deleteUser(Usuario usuario) {
        Connection conn = SQL.conectarMySQL();  // Nos conectamos a la BBDD
        boolean resultado = false;

        try {

            if(!usuario.exists()) {
                System.out.println("Ese usuario no existe");
            }else {
                String query = "delete from usuario where ('nombreUser' = '" + usuario.getNombreUser() + "'); ";

                PreparedStatement comando = conn.prepareStatement(query);
                if(comando.executeUpdate() > 0) {  // Se ha eliminado el usuario
                    resultado = true;
                }
            }
            return resultado;

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Se ha producido un error.");
            return resultado;
        } finally {
            try {
                if(conn != null){
                    conn.close();
                }
            } catch (SQLException e){
                System.out.println(e.getMessage());
            }
        }
    }

    // Devuelve true si el usuario pasado por parámetro existe
    public boolean exists(String nombreUser){
        Connection conn = SQL.conectarMySQL();  // Nos conectamos a la BBDD
        boolean resultado = true;

        Statement comando;
        ResultSet consulta = null;

        try {
            comando = conn.createStatement();
            consulta = comando.executeQuery("select * from usuario where nombreUser='" + nombreUser + "';");

            if(!consulta.next()) {
                resultado = false;
            }
            return resultado;
        } catch (SQLException e) {
            e.printStackTrace();
            return resultado;
        } finally {
            try {
                if(conn != null){
                    conn.close();
                }
            } catch (SQLException e){
                System.out.println(e.getMessage());
            }
        }
    }

    // Comprueba que existe el usuario y que la contraseña es correcta
    public boolean autentication(String nombreUser, String passwordIntroducida) {
        Connection conn = SQL.conectarMySQL();  // Nos conectamos a la BBDD
        boolean resultado = true;

        Statement comando;
        ResultSet consulta = null;

        try {
            // String passwordIntroducidaEncriptada = encript(passwordIntroducida);  // Esta línea será para encriptar
            String passwordIntroducidaEncriptada = passwordIntroducida;

            comando = conn.createStatement();
            consulta = comando.executeQuery("select * from usuario where nombreUser='" + nombreUser + "';");

            if(!consulta.next()) {  // No existe el usuario
                resultado = false;
            }else if(!passwordIntroducidaEncriptada.equals(consulta.getString("password"))){  // Error contraseña
                resultado = false;
            }
            return resultado;
        } catch (Exception e) {
            e.printStackTrace();
            return resultado;
        } finally {
            try {
                if(conn != null){
                    conn.close();
                }
            } catch (SQLException e){
                System.out.println(e.getMessage());
            }
        }
    }

    @Transactional(readOnly = true)
    public LoginStatus login(String nombreUser, String password) {
        Optional<Usuario> usuario = usuarioRepository.findByNombreUser(nombreUser);
        if (!usuario.isPresent()) {
            return LoginStatus.USER_NOT_FOUND;
        } else if (!usuario.get().getPassword().equals(password)) {
            return LoginStatus.ERROR_PASSWORD;
        } else {
            return LoginStatus.LOGIN_OK;
        }
    }
}