package reservas;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import reservas.model.Usuario;
import reservas.model.UsuarioRepository;
import static org.junit.Assert.assertEquals;

public class ClienteTest {

    //Logger logger = LoggerFactory.getLogger(UsuarioTest.class);

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Test
    @Transactional(readOnly = true)
    public void buscarUsuarioEnBaseDatos() {

        // WHEN

        Usuario usuario = usuarioRepository.findByNombreUser("taesCliente").orElse(null);
        //System.out.println(usuario.getNombreUser());

        // THEN
        assertEquals(usuario.getNombreUser(), "taesCliente");
    }

}
