package reservas.service;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.springframework.stereotype.Service;
import reservas.model.Cliente;
import reservas.model.Servicio;
import reservas.model.Usuario;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

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
                        cliente.getNombre() + "', '" + cliente.getApellidos() + "', '" + cliente.getEmail() + "', default);";

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

    public boolean existeCliente(String nombreUser){
        Connection conn = SQL.conectarMySQL();  // Nos conectamos a la BBDD
        boolean resultado = true;

        Statement comando;
        ResultSet consulta = null;

        try {
            comando = conn.createStatement();
            consulta = comando.executeQuery("select * from cliente where nombreUser='" + nombreUser + "';");

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

    public List<Cliente> getClientes(){
        Connection conn = SQL.conectarMySQL();  // Nos conectamos a la BBDD
        List<Cliente> clientes = new ArrayList<>();

        try {
            String query = "";

            query = "select distinct usuario.nombreUser, cliente.fechaNac, usuario.password, usuario.nombre, usuario.apellidos, usuario.email, usuario.img from cliente join usuario on cliente.nombreUser = usuario.nombreUser;";

            Statement st = conn.createStatement(); //creamos el statement -> nos permite sacar los datos obtenidos de la select
            ResultSet rs = st.executeQuery(query); //ejecutamos la query

            while (rs.next())
            {
                Cliente cliente = new Cliente();
                //NO SE POR QUE MUESTRA ANTES LA FECHA QUE EL NOMBRE EN EL JSON FINAL
                cliente.nombreUser = rs.getString("nombreUser");

                DateFormat dateFormatFecha = new SimpleDateFormat("yyyy-MM-dd"); //se necesita para la conversión de la BBDD (Date) a String
                cliente.fechaNac = dateFormatFecha.format(rs.getDate("fechaNac"));

                cliente.password = rs.getString("password");
                cliente.nombre = rs.getString("nombre");
                cliente.apellidos = rs.getString("apellidos");
                cliente.email = rs.getString("email");
                cliente.img = rs.getString("img");

                clientes.add(cliente);
            }

            return clientes;

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Se ha producido un error.");
            return clientes;
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

    public Cliente getCliente(String nombreUser){
        Connection conn = SQL.conectarMySQL();  // Nos conectamos a la BBDD
        Cliente cliente = new Cliente();

        try {
            String query = "select distinct cliente.nombreUser, cliente.fechaNac, usuario.password, usuario.nombre, usuario.apellidos, usuario.email, usuario.img from cliente, usuario where cliente.nombreUser = usuario.nombreUser and cliente.nombreUser = '" + nombreUser + "';";

            Statement st = conn.createStatement(); //creamos el statement -> nos permite sacar los datos obtenidos de la select
            ResultSet rs = st.executeQuery(query); //ejecutamos la query

            rs.next();

            //NO SE POR QUE MUESTRA ANTES LA FECHA QUE EL NOMBRE EN EL JSON FINAL
            cliente.nombreUser = rs.getString("nombreUser");

            DateFormat dateFormatFecha = new SimpleDateFormat("yyyy-MM-dd"); //se necesita para la conversión de la BBDD (Date) a String
            cliente.fechaNac = dateFormatFecha.format(rs.getDate("fechaNac"));

            cliente.password = rs.getString("password");
            cliente.nombre = rs.getString("nombre");
            cliente.apellidos = rs.getString("apellidos");
            cliente.email = rs.getString("email");
            cliente.img = rs.getString("img");

            return cliente;

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Se ha producido un error.");
            return cliente;
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
