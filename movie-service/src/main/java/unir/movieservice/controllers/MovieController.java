package unir.movieservice.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import unir.movieservice.model.dto.MovieRequest;
import unir.movieservice.model.dto.MovieResponse;
import unir.movieservice.model.entities.Movie;
import unir.movieservice.servicies.IMoveService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/movies")
@RequiredArgsConstructor
public class MovieController {

    @Qualifier("IMoveService")
    private final IMoveService service;

    @GetMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Movie> getById (@PathVariable Integer id){
        return this.service.getById(id);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Object> remove(@PathVariable Integer id){
        boolean Ok = this.service.remove(id);
        String response = "";
        if (Ok){
            response ="Movie con Id " + id + " eliminado exitosamente";

        }else{
            response =  "Error al eliminar Movie con id " + id;
        }
        Map<String, Object> map = new HashMap<>();
        map.put("respuesta", response);
        return map;
    }

    @PostMapping(path = "/movie")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody MovieRequest movieRequest){
        service.addMovie(movieRequest);
    }

    @GetMapping(path = "/movies")
    @ResponseStatus(HttpStatus.OK)
    public List<MovieResponse> getAllMovies(){
        return this.service.getAllMovies();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Movie updateProduct(@PathVariable Integer id, @RequestBody Movie movie) {
        return service.updateProduct(id, movie);
    }

}
