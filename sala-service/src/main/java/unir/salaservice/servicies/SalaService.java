package unir.salaservice.servicies;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import unir.salaservice.model.dto.BaseResponse;
import unir.salaservice.model.dto.SalaRequest;
import unir.salaservice.model.dto.SalaResponse;
import unir.salaservice.model.entities.Sala;
import unir.salaservice.repositories.SalaRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class SalaService implements ISalaService{

    private final SalaRepository repository;
    private final WebClient.Builder webClientBuilder;
    @Override
    public Optional<Sala> getById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public Boolean remove(Integer id) {
        try {
            repository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Boolean addSala(SalaRequest movieRequest) {
        boolean _validar = movieExists(movieRequest.getId_movie());
        boolean response = false;
        if (_validar)
        {
            var sala = Sala.builder()
                    .numero_asiento(movieRequest.getNumero_asiento())
                    .numero_sala(movieRequest.getNumero_sala())
                    .Estado(movieRequest.getEstado())
                    .Id_movie(movieRequest.getId_movie())
                    .horario(movieRequest.getHorario())
                    .build();
            repository.save(sala);
            log.info("Sala added: {}", sala);
            response = true;
        }
        return response;
    }

    @Override
    public List<SalaResponse> getAllSalas() {
        var salas = repository.findAll();
        return salas.stream().map(this:: mapToSalaResponse).toList();
    }

    private SalaResponse mapToSalaResponse (Sala sala){
        return SalaResponse.builder()
                .IdSala(sala.getIdSala())
                .numero_asiento(sala.getNumero_asiento())
                .numero_sala(sala.getNumero_sala())
                .Estado(sala.getEstado())
                .Id_movie(sala.getId_movie())
                .horario(sala.getHorario())
                .build();
    }

    public Boolean movieExists(Integer IdMovie) {
        boolean response = false;

        BaseResponse result = this.webClientBuilder.build()
                .get()
                .uri("lb://movie-service/api/movies/" + IdMovie)
                .retrieve()
                .bodyToMono(BaseResponse.class)
                .block();
        if (result != null && !result.hasErrors()) {
            response = true;
        }
        return response;
    }

    @Override
    public Sala updateProduct(Integer id, Sala sala) {
        getById(id); // Check if the product exists
        sala.setIdSala(id);
        return repository.save(sala);
    }
}
