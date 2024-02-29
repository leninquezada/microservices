package unir.salaservice.servicies;

import org.springframework.stereotype.Service;
import unir.salaservice.model.dto.SalaRequest;
import unir.salaservice.model.dto.SalaResponse;
import unir.salaservice.model.entities.Sala;

import java.util.List;
import java.util.Optional;

@Service
public interface ISalaService {
    Optional<Sala> getById(Integer id);

    Boolean remove(Integer id);

    Boolean addSala(SalaRequest movieRequest);

    List<SalaResponse> getAllSalas();

    Sala updateProduct(Integer id, Sala sala);
}
