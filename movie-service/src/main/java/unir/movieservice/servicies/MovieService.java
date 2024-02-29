package unir.movieservice.servicies;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import unir.movieservice.model.dto.MovieRequest;
import unir.movieservice.model.dto.MovieResponse;
import unir.movieservice.model.entities.Movie;
import unir.movieservice.repositories.MovieRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class MovieService implements IMoveService {

    final
    MovieRepository repository;
    @Override
    public Optional<Movie> getById(Integer id) {
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
    public void addMovie(MovieRequest movieRequest){
        var movie = Movie.builder()
                .Titulo(movieRequest.getTitulo())
                .Calificacion(movieRequest.getCalificacion())
                .Director(movieRequest.getDirector())
                .Actores(movieRequest.getActores())
                .Imagen(movieRequest.getImagen())
                .Fecha(movieRequest.getFecha())
                .Duracion(movieRequest.getDuracion())
                .Descripcion(movieRequest.getDescripcion())
                .build();
        repository.save(movie);

        log.info("Movie added: {}", movie);
    }

    @Override
    public List<MovieResponse> getAllMovies() {
        var movies = repository.findAll();
        return movies.stream().map(this:: mapToMovieResponse).toList();
    }

    private MovieResponse mapToMovieResponse (Movie movie){
        return MovieResponse.builder()
                .Id_Movie(movie.getId_Movie())
                .Titulo(movie.getTitulo())
                .Calificacion(movie.getCalificacion())
                .Director(movie.getDirector())
                .Actores(movie.getActores())
                .Imagen(movie.getImagen())
                .Fecha(movie.getFecha())
                .Duracion(movie.getDuracion())
                .Descripcion(movie.getDescripcion())
                .build();
    }

    @Override
    public Movie updateProduct(Integer id, Movie movie) {
        getById(id); // Check if the product exists
        movie.setId_Movie(id);
        return repository.save(movie);
    }

}