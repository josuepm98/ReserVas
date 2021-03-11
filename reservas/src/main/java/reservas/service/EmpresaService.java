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
                        empresa.getNombre() + "', '" + empresa.getApellidos() + "', '" + empresa.getEmail() + "');";

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

    // Se añade un usuario en la aplicación.
    // El email y password del usuario deben ser distinto de null
    // El email no debe estar registrado en la base de datos
    /*@Transactional
    public Cliente registrar(Cliente cliente) {
        Optional<Usuario> clienteRegistrado = usuarioRepository.findByNombreUser(cliente.getNombreUser());
        if (clienteRegistrado.isPresent())
            throw new ClienteServiceException("El usuario " + cliente.getNombreUser() + " ya está registrado");
        else if (cliente.getNombreUser() == null)
            throw new ClienteServiceException("El usuario debe tener un nombre de usuario");
        else if (cliente.getEmail() == null)
            throw new ClienteServiceException("El usuario debe tener un email");
        else if (cliente.getPassword() == null)
            throw new ClienteServiceException("El usuario debe tener una contraseña");
        else if (cliente.getNombre() == null)
            throw new ClienteServiceException("El usuario debe tener nombre");
        else if (cliente.getApellidos() == null)
            throw new ClienteServiceException("El usuario debe tener apellidos");
        else return usuarioRepository.save(cliente);
    }*/
}
