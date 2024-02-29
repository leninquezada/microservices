package unir.movieservice.servicies;

import org.springframework.stereotype.Service;
import unir.movieservice.model.dto.MovieRequest;
import unir.movieservice.model.dto.MovieResponse;
import unir.movieservice.model.entities.Movie;

import java.util.List;
import java.util.Optional;
@Service
public interface IMoveService {

    Optional<Movie> getById(Integer id);

    Boolean remove(Integer id);

    void addMovie(MovieRequest movieRequest);

    List<MovieResponse> getAllMovies();

    Movie updateProduct(Integer id, Movie movie);

}
