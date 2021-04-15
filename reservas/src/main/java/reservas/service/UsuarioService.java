package reservas.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import reservas.model.Usuario;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


@Service
public class UsuarioService {

    Logger logger = LoggerFactory.getLogger(UsuarioService.class);

    // Creamos la cadena para conectar a la BBDD
    private ConexionMySQL SQL = new ConexionMySQL();

    public boolean eliminarUsuario(Usuario usuario) {
        Connection conn = SQL.conectarMySQL();  // Nos conectamos a la BBDD
        boolean resultado = false;

        try {

            if(!usuario.existe()) {
                System.out.println("Ese usuario no existe");
            }else {
                // A la hora de borrar son muy importantes las comillas simples que cogen la palabra nombreUser, no tengo ni puta
                // idea de por qué con 'nombreUser' no funciona. Tiene que ser `nombreUser`
                String query = "delete from usuario where (`nombreUser` = '" + usuario.getNombreUser() + "'); ";
                PreparedStatement comando = conn.prepareStatement(query);
                if(comando.executeUpdate() > 0) {  // Se ha eliminado el usuario de sus dos tablas
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
    public boolean existe(String nombreUser){
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
    public boolean autenticacion(String nombreUser, String passwordIntroducida) {
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

    /*public Usuario getUsuario(String nombreUser){
        Connection conn = SQL.conectarMySQL();  // Nos conectamos a la BBDD
        Usuario usuario = new Usuario();

        try {
            String query = "select * from usuario where nombreUser='" + nombreUser + "';";

            Statement st = conn.createStatement(); //creamos el statement -> nos permite sacar los datos obtenidos de la select
            ResultSet rs = st.executeQuery(query); //ejecutamos la query

            rs.next();

            usuario.nombreUser = rs.getString("nombreUser");
            usuario.password = rs.getString("password");
            usuario.nombre = rs.getString("nombre");
            usuario.apellidos = rs.getString("apellidos");
            usuario.email = rs.getString("email");
            usuario.img = rs.getString("img");

            return usuario;
        } catch (SQLException e) {
            e.printStackTrace();
            return usuario;
        } finally {
            try {
                if(conn != null){
                    conn.close();
                }
            } catch (SQLException e){
                System.out.println(e.getMessage());
            }
        }
    }*/

}