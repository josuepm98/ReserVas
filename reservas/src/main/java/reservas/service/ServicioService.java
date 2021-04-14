package reservas.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import reservas.model.Categoria;
import reservas.model.Servicio;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

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

    public Servicio getService(int serviceId){
        Connection conn = SQL.conectarMySQL();  // Nos conectamos a la BBDD
        Servicio service = new Servicio();

        try {
            String query = "SELECT * FROM servicio WHERE (`id` = '" + serviceId + "');";

            Statement st = conn.createStatement(); //creamos el statement -> nos permite sacar los datos obtenidos de la select
            ResultSet rs = st.executeQuery(query); //ejecutamos la query

            rs.next();

            service.id = rs.getInt("id");
            service.nombre = rs.getString("nombre");
            service.direccion = rs.getString("direccion");
            service.precio = rs.getDouble("precio");

            DateFormat dateFormatFecha = new SimpleDateFormat("yyyy-mm-dd"); //se necesita para la conversión de la BBDD (Date) a String
            service.fecha = dateFormatFecha.format(rs.getDate("fecha"));

            DateFormat dateFormatHora = new SimpleDateFormat("hh:mm:ss"); //se necesita para la conversión de la BBDD (Time) a String
            service.horaInicio = dateFormatHora.format(rs.getDate("horaInicio"));
            service.horaFin = dateFormatHora.format(rs.getDate("horaFin"));

            service.categoria = rs.getString("categoria");
            service.estado = service.estado.valueOf(rs.getString("estado")); //se necesita la conversión a ENUM (valueOf) (Yo cambiaría el enum si nos da problemas)
            service.empresa = rs.getString("empresa");
            service.cliente = rs.getString("cliente");

            return service;

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Se ha producido un error.");
            return service;
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

    //0 -> cliente
    //1 -> empresa
    public List<Servicio> getServicios(String nombreUser, int value){
        Connection conn = SQL.conectarMySQL();  // Nos conectamos a la BBDD
        List<Servicio> servicesUser = new ArrayList<>();

        try {
            String query = "";
            if(value == 0) { //miramos según el value (0,1) si hacemos la select con cliente o empresa
                query = "SELECT * FROM servicio WHERE (`cliente` = '" + nombreUser + "');";
            }
            else{
                query = "SELECT * FROM servicio WHERE (`empresa` = '" + nombreUser + "');";
            }

            Statement st = conn.createStatement(); //creamos el statement -> nos permite sacar los datos obtenidos de la select
            ResultSet rs = st.executeQuery(query); //ejecutamos la query

            while (rs.next())
            {
                Servicio service = new Servicio();
                service.id = rs.getInt("id");
                service.nombre = rs.getString("nombre");
                service.direccion = rs.getString("direccion");
                service.precio = rs.getDouble("precio");

                DateFormat dateFormatFecha = new SimpleDateFormat("yyyy-mm-dd"); //se necesita para la conversión de la BBDD (Date) a String
                service.fecha = dateFormatFecha.format(rs.getDate("fecha"));

                DateFormat dateFormatHora = new SimpleDateFormat("hh:mm:ss"); //se necesita para la conversión de la BBDD (Time) a String
                service.horaInicio = dateFormatHora.format(rs.getDate("horaInicio"));
                service.horaFin = dateFormatHora.format(rs.getDate("horaFin"));

                service.categoria = rs.getString("categoria");
                service.estado = service.estado.valueOf(rs.getString("estado")); //se necesita la conversión a ENUM (valueOf) (Yo cambiaría el enum si nos da problemas)
                service.empresa = rs.getString("empresa");
                service.cliente = rs.getString("cliente");

                servicesUser.add(service);
            }

            return servicesUser;

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Se ha producido un error.");
            return servicesUser;
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

    public List<Servicio> getServiciosPorCategoria(String nombreCategoria){
        Connection conn = SQL.conectarMySQL();  // Nos conectamos a la BBDD
        List<Servicio> services = new ArrayList<>();

        try {
            String query = "SELECT * FROM servicio WHERE categoria='"+ nombreCategoria + "' and estado='LIBRE';";

            Statement st = conn.createStatement(); //creamos el statement -> nos permite sacar los datos obtenidos de la select
            ResultSet rs = st.executeQuery(query); //ejecutamos la query

            while (rs.next()) {
                Servicio service = new Servicio();
                service.id = rs.getInt("id");
                service.nombre = rs.getString("nombre");
                service.direccion = rs.getString("direccion");
                service.precio = rs.getDouble("precio");

                DateFormat dateFormatFecha = new SimpleDateFormat("yyyy-mm-dd"); //se necesita para la conversión de la BBDD (Date) a String
                service.fecha = dateFormatFecha.format(rs.getDate("fecha"));

                DateFormat dateFormatHora = new SimpleDateFormat("hh:mm:ss"); //se necesita para la conversión de la BBDD (Time) a String
                service.horaInicio = dateFormatHora.format(rs.getDate("horaInicio"));
                service.horaFin = dateFormatHora.format(rs.getDate("horaFin"));

                service.categoria = rs.getString("categoria");
                service.estado = service.estado.valueOf(rs.getString("estado")); //se necesita la conversión a ENUM (valueOf) (Yo cambiaría el enum si nos da problemas)
                service.empresa = rs.getString("empresa");
                service.cliente = rs.getString("cliente");

                services.add(service);
            }

            return services;

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Se ha producido un error.");
            return services;
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
