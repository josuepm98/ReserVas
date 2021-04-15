package reservas.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import reservas.model.Cliente;
import reservas.model.Empresa;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmpresaService extends UsuarioService{

    Logger logger = LoggerFactory.getLogger(EmpresaService.class);

    // Creamos la cadena para conectar a la BBDD
    private ConexionMySQL SQL = new ConexionMySQL();

    public boolean crearEmpresa(Empresa empresa) {
        Connection conn = SQL.conectarMySQL();  // Nos conectamos a la BBDD
        boolean resultado = false;

        try {

            if(empresa.existe()) {
                System.out.println("Esa empresa ya existe");
            }else {
                // String contrasenyaEncriptada = encript(usuario.getPassword());  // Esta línea será para encriptar cuando tengamos el método
                String contrasenyaEncriptada = empresa.getPassword();

                // query para insertar en la tabla usuario
                String query1 = "insert into usuario values ('" + empresa.getNombreUser() + "', '" + contrasenyaEncriptada + "', '" +
                        empresa.getNombre() + "', '" + empresa.getApellidos() + "', '" + empresa.getEmail() + "', default);";

                // query para insertar en la tabla empresa
                String query2 = "insert into empresa (`nombreUser`, `direccion`) values ('" + empresa.getNombreUser() + "', '" + empresa.getDireccion() + "');";

                // Empieza la transacción
                conn.setAutoCommit(false);

                PreparedStatement comando1 = conn.prepareStatement(query1);
                PreparedStatement comando2 = conn.prepareStatement(query2);
                if(comando1.executeUpdate() > 0 && comando2.executeUpdate() > 0) {  // Se han ejecutado las 2 queries bien
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

    public List<Cliente> getClientesEmpresa(String nombreEmpresa){
        Connection conn = SQL.conectarMySQL();  // Nos conectamos a la BBDD
        List<Cliente> clientes = new ArrayList<>();

        try {
            String query = "";

            query = "select distinct cliente.nombreUser, cliente.fechaNac, usuario.password, usuario.nombre, usuario.apellidos, usuario.email, usuario.img from cliente join servicio on cliente.nombreUser = servicio.cliente and servicio.empresa = '" + nombreEmpresa + "' join usuario on cliente.nombreUser = usuario.nombreUser;";

            Statement st = conn.createStatement(); //creamos el statement -> nos permite sacar los datos obtenidos de la select
            ResultSet rs = st.executeQuery(query); //ejecutamos la query

            while (rs.next())
            {
                Cliente cliente = new Cliente();
                //NO SE POR QUE MUESTRA ANTES LA FECHA QUE EL NOMBRE EN EL JSON FINAL
                cliente.nombreUser = rs.getString("nombreUser");

                DateFormat dateFormatFecha = new SimpleDateFormat("yyyy-mm-dd"); //se necesita para la conversión de la BBDD (Date) a String
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

    /* LO TENGO QUE HACER @JOSE
    public boolean generarDia() {
        Connection conn = SQL.conectarMySQL();  // Nos conectamos a la BBDD
        boolean resultado = false;

        try {

            if(empresa.existe()) {
                System.out.println("Esa empresa ya existe");
            }else {

                // query para insertar en la tabla usuario
                String query1 = "insert into usuario values ('" + empresa.getNombreUser() + "', '" + contrasenyaEncriptada + "', '" +
                        empresa.getNombre() + "', '" + empresa.getApellidos() + "', '" + empresa.getEmail() + "', default);";

                // query para insertar en la tabla empresa
                String query2 = "insert into empresa values ('" + empresa.getNombreUser() + "', '" + empresa.getDireccion() + "');";

                // Empieza la transacción
                conn.setAutoCommit(false);

                PreparedStatement comando1 = conn.prepareStatement(query1);
                PreparedStatement comando2 = conn.prepareStatement(query2);
                if(comando1.executeUpdate() > 0 && comando2.executeUpdate() > 0) {  // Se han ejecutado las 2 queries bien
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
     */

}
