package reservas.service;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.springframework.stereotype.Service;
import reservas.model.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Service
public class ClienteService extends UsuarioService{

    // Creamos la cadena para conectar a la BBDD
    private ConexionMySQL SQL = new ConexionMySQL();

    public boolean crearCliente(Cliente cliente) {
        Connection conn = SQL.conectarMySQL();  // Nos conectamos a la BBDD
        boolean resultado = false;

        try {

            if(cliente.existe()) {
                System.out.println("Ese usuario ya existe");
            }else {
                // String contrasenyaEncriptada = encript(usuario.getPassword());  // Esta línea será para encriptar cuando tengamos el método
                String contrasenyaEncriptada = cliente.getPassword();

                // query para insertar en la tabla usuario
                String query1 = "insert into usuario values ('" + cliente.getNombreUser() + "', '" + contrasenyaEncriptada + "', '" +
                        cliente.getNombre() + "', '" + cliente.getApellidos() + "', '" + cliente.getEmail() + "');";

                // query para insertar en la tabla cliente
                String query2 = "insert into cliente values ('" + cliente.getNombreUser() + "', '" + cliente.getFechaNac() + "');";

                // Empieza la transacción
                conn.setAutoCommit(false);

                PreparedStatement comando1 = conn.prepareStatement(query1);
                PreparedStatement comando2 = conn.prepareStatement(query2);
                if(comando1.executeUpdate() > 0 && comando2.executeUpdate() > 0) {  // Se han ejecutado las queries bien
                    resultado = true;
                }

                // Fin transaccion
                conn.commit();
                // Le devolvemos su valor por defecto
                conn.setAutoCommit(true);
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
}
