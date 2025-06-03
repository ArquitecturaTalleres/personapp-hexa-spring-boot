package co.edu.javeriana.as.personapp.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EstudioRequest {
    private String idPersona;
    private String idProfesion;
    private String fechaGraduacion;
    private String universidad;
    private String database;
}
