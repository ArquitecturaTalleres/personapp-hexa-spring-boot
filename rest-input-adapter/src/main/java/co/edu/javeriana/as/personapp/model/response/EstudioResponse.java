package co.edu.javeriana.as.personapp.model.response;

import co.edu.javeriana.as.personapp.model.request.EstudioRequest;

public class EstudioResponse extends EstudioRequest {

    private String status;

    public EstudioResponse(String idPersona, String idProfesion, String fechaGraduacion, String universidad,
            String database, String status) {
        super(idPersona, idProfesion, fechaGraduacion, universidad, database);
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
