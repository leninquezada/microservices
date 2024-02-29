package unir.salaservice.model.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table
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
}
