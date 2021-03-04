package reservas.model;

import org.springframework.data.repository.CrudRepository;
import java.util.Optional;

//permitimos la búsqueda en controller a través de la interfaz
public interface ClienteRepository extends CrudRepository<Cliente, String> {
    Optional<Cliente> findByEmail(String s);
}
