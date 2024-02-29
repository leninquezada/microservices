package unir.movieservice.model.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "movie")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Movie")
    private Integer Id_Movie;

    private String Titulo;
    private String Calificacion;
    private String Director;
    private String Actores;
    private String Imagen;
    private String Fecha;
    private String Duracion;
    private String Descripcion;

    @Override
    public String toString() {
        return "Movie{" +
                "Id_Movie=" + Id_Movie +
                ", Titulo=" + Titulo + '\'' +
                ", Calificacion=" + Calificacion + '\'' +
                ", Actores=" + Actores + '\'' +
                ", Imagen=" + Imagen + '\'' +
                ", Fecha=" + Fecha + '\'' +
                ", Duracion=" + Duracion + '\'' +
                ", Descripcion=" + Descripcion + '\'' +
                "}";
    }
}
