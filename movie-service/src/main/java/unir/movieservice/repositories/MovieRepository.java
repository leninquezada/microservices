package unir.movieservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import unir.movieservice.model.entities.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
}