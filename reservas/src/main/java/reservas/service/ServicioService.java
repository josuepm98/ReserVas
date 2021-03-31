package reservas.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import reservas.model.Servicio;

import java.sql.*;

@Service
public class ServicioService {

    private ConexionMySQL SQL = new ConexionMySQL();

    public boolean createService(Servicio servicio){
        Connection conn = SQL.conectarMySQL();  // Nos conectamos a la BBDD
        boolean resultado = false;

        try{

            String query = "INSERT INTO servicio (id, nombre, direccion, precio, fecha, horaInicio, horaFin, categoria, estado, " +
                    "empresa, cliente) VALUES (null, '" + servicio.nombre + "', '" + servicio.direccion + "', " + servicio.precio +
                    ", '" + servicio.fecha + "', '" + servicio.horaInicio + "', '" + servicio.horaFin + "', '" + servicio.categoria +
                    "', '" + servicio.estado + "', '" + servicio.empresa + "', null);";

            String generatedColumns[] = { "ID" };
            PreparedStatement comando = conn.prepareStatement(query, generatedColumns);  // IMP añadir el id al insertar
            if(comando.executeUpdate() > 0) {  // Se ha insertado el servicio
                ResultSet rs = comando.getGeneratedKeys();
                if(rs.next()){
                    servicio.setId((int)rs.getLong(1));  // Metemos el id obtenido
                }
                resultado = true;
            }
            return resultado;

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Se ha producido un error.");
            return resultado;
        }finally {
            try {
                conn.close();
            }catch (Exception e){
                System.out.println("Error al cerrar la conexión");
            }
        }
    }

    public boolean deleteService(Servicio servicio){
        Connection conn = SQL.conectarMySQL();  // Nos conectamos a la BBDD
        boolean resultado = false;

        try{

            String query = "DELETE FROM servicio WHERE (`id` = '" + servicio.getId() + "');";

            PreparedStatement comando = conn.prepareStatement(query);
            if(comando.executeUpdate() > 0) {  // Se ha eliminado el servicio
                resultado = true;
            }
            return resultado;

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Se ha producido un error.");
            return resultado;
        }finally {
            try {
                conn.close();
            }catch (Exception e){
                System.out.println("Error al cerrar la conexión");
            }
        }
    }

    public boolean getServicios(){
        Connection conn = SQL.conectarMySQL();  // Nos conectamos a la BBDD
        boolean resultado = false;

        try {


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
