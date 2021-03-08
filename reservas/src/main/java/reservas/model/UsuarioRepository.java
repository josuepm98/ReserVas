package reservas.model;

import org.springframework.data.repository.CrudRepository;
import java.util.Optional;

//permitimos la búsqueda en controller a través de la interfaz
public interface UsuarioRepository extends CrudRepository<Usuario, String> {
    Optional<Usuario> findByNombreUser(String s);
}
