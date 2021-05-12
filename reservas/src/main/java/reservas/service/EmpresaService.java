package reservas.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import reservas.model.Cliente;
import reservas.model.Empresa;
import reservas.model.Servicio;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.sql.*;
import java.util.*;

import java.text.Format;
import java.util.Date;

@Service
public class EmpresaService extends UsuarioService{

    Logger logger = LoggerFactory.getLogger(EmpresaService.class);

    // Creamos la cadena para conectar a la BBDD
    private ConexionMySQL SQL = new ConexionMySQL();

    private static String  ENCRYPT_KEY="passwordpassword";

    private static String encript(String text) throws Exception {
        Key aesKey = new SecretKeySpec(ENCRYPT_KEY.getBytes(), "AES");

        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, aesKey);

        byte[] encrypted = cipher.doFinal(text.getBytes());
        return Base64.getEncoder().encodeToString(encrypted);
    }

    public boolean crearEmpresa(Empresa empresa) {
        Connection conn = SQL.conectarMySQL();  // Nos conectamos a la BBDD
        boolean resultado = false;

        try {

            if(empresa.existe()) {
                System.out.println("Esa empresa ya existe");
            }else {
                String contrasenyaEncriptada = encript(empresa.getPassword());  // Esta línea será para encriptar cuando tengamos el método
                // String contrasenyaEncriptada = empresa.getPassword();

                // query para insertar en la tabla usuario
                String query1 = "insert into usuario values ('" + empresa.getNombreUser() + "', '" + contrasenyaEncriptada + "', '" +
                        empresa.getNombre() + "', '" + empresa.getApellidos() + "', '" + empresa.getEmail() + "', default);";

                // query para insertar en la tabla empresa
                String query2 = "insert into empresa (`nombreUser`, `direccion`, `categoria`) values ('" + empresa.getNombreUser() +
                        "', '" + empresa.getDireccion() + "', '"+ empresa.getCategoria() + "');";

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
            String query = "select distinct empresa.nombreUser, empresa.direccion, empresa.categoria, empresa.inicioJornada, empresa.finJornada, " +
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
                empresa.setCategoria(rs.getString("categoria"));
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

    public List<Empresa> getEmpresasPorCategoria(String categoryName){
        Connection conn = SQL.conectarMySQL();  // Nos conectamos a la BBDD
        List<Empresa> empresas = new ArrayList<>();

        try {
            /*
            También se puede:
            select empresa.nombreUser, empresa.direccion, empresa.inicioJornada, empresa.finJornada,
                    empresa.tiempoServicio, usuario.password, usuario.nombre, usuario.apellidos, usuario.email,
                    usuario.img from empresa inner join usuario on empresa.nombreUser = usuario.nombreUser;
            */
            String query = "select distinct empresa.nombreUser, empresa.direccion, empresa.categoria, usuario.email," +
                    "usuario.img from empresa, usuario where empresa.nombreUser = usuario.nombreUser and empresa.categoria = '" + categoryName + "';";

            Statement st = conn.createStatement(); //creamos el statement -> nos permite sacar los datos obtenidos de la select
            ResultSet rs = st.executeQuery(query); //ejecutamos la query

            while(rs.next()) {
                Empresa empresa = new Empresa();
                empresa.setNombreUser(rs.getString("nombreUser"));
                empresa.setEmail(rs.getString("email"));
                empresa.setImg(rs.getString("img"));
                empresa.setDireccion(rs.getString("direccion"));
                empresa.setCategoria(rs.getString("categoria"));

                empresas.add(empresa);
            }

            return empresas;

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Se ha producido un error.");
            return empresas;
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

    // Método para ver si la actividad cabe en la franja horaria que marca inicio-fin
    public boolean cabeActividad(String inicio, String fin, String duracion) {
        int horasASumar = Integer.parseInt(duracion)/60;
        int minutosASumar = Integer.parseInt(duracion)%60;

        Calendar cal = Calendar.getInstance();

        String[] partes = inicio.split(":");
        int hora = Integer.parseInt(partes[0]);
        int minutos = Integer.parseInt(partes[1]);
        Format f = new SimpleDateFormat("HH:mm");
        cal.set(Calendar.HOUR_OF_DAY, hora);
        cal.set(Calendar.MINUTE, minutos);
        cal.add(Calendar.HOUR, horasASumar);
        cal.add(Calendar.MINUTE, minutosASumar);
        Date date = cal.getTime();
        inicio = f.format(date);

        if(getHora(inicio) < getHora(fin)) {
            return true;
        }else if(getHora(inicio) == getHora(fin)) {
            if(getMinutos(inicio) < getMinutos(fin) || getMinutos(inicio) == getMinutos(fin)) {
                return true;
            }else {
                return false;
            }
        }else {
            return false;
        }
    }

    public void generarDia(Empresa empresa, String nombreServicio, String direccionServicio, double precio, String fecha) {
        Connection conn = SQL.conectarMySQL();  // Nos conectamos a la BBDD

        try {
            Servicio servicio;

            String iteradorTiempo = empresa.getInicioJornada();
            int horasASumar = Integer.parseInt(empresa.getTiempoServicio())/60;
            int minutosASumar = Integer.parseInt(empresa.getTiempoServicio())%60;

            while(cabeActividad(iteradorTiempo, empresa.getFinJornada(), empresa.getTiempoServicio())){

                String horaInicioServicio = iteradorTiempo;

                // Sumamos la duración del servicio a la variable iteradora
                Calendar cal = Calendar.getInstance();

                String[] partes = iteradorTiempo.split(":");
                int hora = Integer.parseInt(partes[0]);
                int minutos = Integer.parseInt(partes[1]);
                Format f = new SimpleDateFormat("HH:mm");
                cal.set(Calendar.HOUR_OF_DAY, hora);
                cal.set(Calendar.MINUTE, minutos);
                cal.add(Calendar.HOUR, horasASumar);
                cal.add(Calendar.MINUTE, minutosASumar);
                Date date = cal.getTime();
                iteradorTiempo = f.format(date);

                String horaFinServicio = iteradorTiempo;

                /*
                    Creación servicio para esa franja
                */
                servicio = new Servicio(nombreServicio, direccionServicio, precio, fecha, horaInicioServicio, horaFinServicio, Servicio.ServicioEstado.LIBRE, empresa.getNombreUser(), null);
                servicio.createService();

            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Se ha producido un error.");
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
