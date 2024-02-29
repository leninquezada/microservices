package unir.movieservice.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MovieResponse {
    private Integer Id_Movie;
    private String Titulo;
    private String Calificacion;
    private String Director;
    private String Actores;
    private String Imagen;
    private String Fecha;
    private String Duracion;
    private String Descripcion;
}
