package reservas.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import reservas.model.Cliente;
import reservas.model.Empresa;
import reservas.model.Servicio;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.sql.*;
import java.time.LocalDate;
import java.util.*;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

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

    public Empresa getEmpresa(String nombreUser){
        Connection conn = SQL.conectarMySQL();  // Nos conectamos a la BBDD
        Empresa empresa = new Empresa();

        try {
            /*
            También se puede:
            select empresa.nombreUser, empresa.direccion, empresa.inicioJornada, empresa.finJornada,
                    empresa.tiempoServicio, usuario.password, usuario.nombre, usuario.apellidos, usuario.email,
                    usuario.img from empresa inner join usuario on empresa.nombreUser = usuario.nombreUser;
            */
            String query = "select distinct empresa.nombreUser, empresa.direccion, empresa.inicioJornada, empresa.finJornada, " +
                    "empresa.tiempoServicio, usuario.password, usuario.nombre, usuario.apellidos, usuario.email," +
                    "usuario.img from empresa, usuario where empresa.nombreUser = usuario.nombreUser and empresa.nombreUser = '" + nombreUser + "';";

            Statement st = conn.createStatement(); //creamos el statement -> nos permite sacar los datos obtenidos de la select
            ResultSet rs = st.executeQuery(query); //ejecutamos la query

            if(rs.next()) {
                empresa.setNombreUser(rs.getString("nombreUser"));
                empresa.setPassword(rs.getString("password"));
                empresa.setNombre(rs.getString("nombre"));
                empresa.setApellidos(rs.getString("apellidos"));
                empresa.setEmail(rs.getString("email"));
                empresa.setImg(rs.getString("img"));

                empresa.setDireccion(rs.getString("direccion"));
                empresa.setInicioJornada(rs.getString("inicioJornada"));
                empresa.setFinJornada(rs.getString("finJornada"));
                empresa.setTiempoServicio(rs.getString("tiempoServicio"));
            }

            return empresa;

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Se ha producido un error.");
            return empresa;
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

            query = "select distinct cliente.nombreUser, cliente.fechaNac, usuario.nombre, usuario.apellidos, usuario.email, usuario.img from cliente join servicio on cliente.nombreUser = servicio.cliente and servicio.empresa = '" + nombreEmpresa + "' join usuario on cliente.nombreUser = usuario.nombreUser;";

            Statement st = conn.createStatement(); //creamos el statement -> nos permite sacar los datos obtenidos de la select
            ResultSet rs = st.executeQuery(query); //ejecutamos la query

            while (rs.next())
            {
                Cliente cliente = new Cliente();
                //NO SE POR QUE MUESTRA ANTES LA FECHA QUE EL NOMBRE EN EL JSON FINAL
                cliente.nombreUser = rs.getString("nombreUser");

                DateFormat dateFormatFecha = new SimpleDateFormat("yyyy-MM-dd"); //se necesita para la conversión de la BBDD (Date) a String
                cliente.fechaNac = dateFormatFecha.format(rs.getDate("fechaNac"));

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

    // Formato de tiempo-> HH:mm
    public String getHoraTexto(String tiempo){
        String[] partes = tiempo.split(":");
        int hora = Integer.parseInt(partes[0]);
        Format f = new SimpleDateFormat("HH");
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, hora);
        Date date = cal.getTime();
        String resultado = f.format(date);
        return resultado;
    }

    // Formato de tiempo-> HH:mm
    public String getMinutosTexto(String tiempo){
        String[] partes = tiempo.split(":");
        int minutos = Integer.parseInt(partes[1]);
        Format f = new SimpleDateFormat("mm");
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.MINUTE, minutos);
        Date date = cal.getTime();
        String resultado = f.format(date);
        return resultado;
    }

    // Formato de tiempo-> HH:mm
    public int getHora(String tiempo){
        String[] partes = tiempo.split(":");
        int hora = Integer.parseInt(partes[0]);
        Format f = new SimpleDateFormat("HH");
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, hora);
        Date date = cal.getTime();
        String resultado = f.format(date);
        return Integer.parseInt(resultado);
    }

    // Formato de tiempo-> HH:mm
    public int getMinutos(String tiempo){
        String[] partes = tiempo.split(":");
        int minutos = Integer.parseInt(partes[1]);
        Format f = new SimpleDateFormat("mm");
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.MINUTE, minutos);
        Date date = cal.getTime();
        String resultado = f.format(date);
        return Integer.parseInt(resultado);
    }

    // metodo para ver si la actividad cabe en la franja horaria que marca inicio-fin
    public boolean cabeActividad(String inicio, String fin, String actividad) {
        /* Los formatos que recibimos son:
            inicio-> hh:mm
            fin-> hh:mm
            actividad-> x minutos
        */


        return true;
    }
    /*
    public boolean generarDia(Empresa empresa, String nombreServicio, String direccionServicio, double precio, String fecha) {
        Connection conn = SQL.conectarMySQL();  // Nos conectamos a la BBDD
        boolean resultado = false;

        try {
            Servicio servicio = new Servicio();
            List<Servicio> listaServicios = servicio.getServiciosPorFecha(empresa.getNombreUser(), fecha);

            while()
            for(int i=0; i<listaServicios.size(); i++) {

            }



                Servicio servicio = new Servicio();


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
    }*/

}
