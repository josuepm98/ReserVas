package reservas.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reservas.model.Cliente;
import reservas.model.Usuario;
import reservas.model.UsuarioRepository;
import java.util.Optional;

@Service
public class ClienteService extends UsuarioService{

    Logger logger = LoggerFactory.getLogger(ClienteService.class);

    private UsuarioRepository usuarioRepository;

    @Autowired
    public ClienteService(UsuarioRepository usuarioRepository) {
        //super(usuarioRepository);
    }

    // Se añade un usuario en la aplicación.
    // El email y password del usuario deben ser distinto de null
    // El email no debe estar registrado en la base de datos
    @Transactional
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
    }
}
