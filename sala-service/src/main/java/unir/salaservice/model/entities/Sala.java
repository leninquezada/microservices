package unir.salaservice.model.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "sala")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Sala {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sala")
    private Integer IdSala;

    private Integer numero_asiento;
    private Integer numero_sala;
    private Boolean Estado;
    private Integer Id_movie;
    private String horario;

    @Override
    public String toString() {
        return "Movie{" +
                "IdSala=" + IdSala +
                ", numero_asiento=" + numero_asiento +
                ", Estado=" + Estado + '\'' +
                ", horario=" + horario + '\'' +
                ", numero_sala=" + numero_sala +
                ", Id_movie=" + Id_movie +
                "}";
    }
}
