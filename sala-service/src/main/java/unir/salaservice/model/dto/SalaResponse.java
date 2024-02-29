package unir.salaservice.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SalaResponse {
    private Integer IdSala;
    private Integer numero_asiento;
    private Integer numero_sala;
    private Boolean Estado;
    private Integer Id_movie;
    private String horario;
}
