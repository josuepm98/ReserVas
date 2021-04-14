package reservas.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import reservas.model.Empresa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
