package unir.salaservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import unir.salaservice.model.entities.Sala;
@Repository
public interface SalaRepository extends JpaRepository<Sala, Integer> {
}
