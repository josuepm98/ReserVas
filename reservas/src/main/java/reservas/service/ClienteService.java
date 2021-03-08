package reservas.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reservas.model.Cliente;
import reservas.model.ClienteRepository;

import java.util.Optional;


@Service
public class ClienteService {

    Logger logger = LoggerFactory.getLogger(ClienteService.class);

    public enum LoginStatus {LOGIN_OK, USER_NOT_FOUND, ERROR_PASSWORD}

    private ClienteRepository clienteRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Transactional(readOnly = true)
    public LoginStatus login(String email, String password) {
        Optional<Cliente> cliente = clienteRepository.findByEmail(email);
        if (!cliente.isPresent()) {
            return LoginStatus.USER_NOT_FOUND;
        } else if (!cliente.get().getPassword().equals(password)) {
            return LoginStatus.ERROR_PASSWORD;
        } else {
            return LoginStatus.LOGIN_OK;
        }
    }

    // Se añade un usuario en la aplicación.
    // El email y password del usuario deben ser distinto de null
    // El email no debe estar registrado en la base de datos
    @Transactional
    public Cliente registrar(Cliente cliente) {
        Optional<Cliente> clienteRegistrado = clienteRepository.findByEmail(cliente.getEmail());
        if (clienteRegistrado.isPresent())
            throw new ClienteServiceException("El usuario " + cliente.getEmail() + " ya está registrado");
        else if (cliente.getEmail() == null)
            throw new ClienteServiceException("El usuario debe tener un email");
        else if (cliente.getPassword() == null)
            throw new ClienteServiceException("El usuario debe tener una contraseña");
        else return clienteRepository.save(cliente);
    }
}