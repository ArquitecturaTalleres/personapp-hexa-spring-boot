package co.edu.javeriana.as.personapp.terminal.validator;
import co.edu.javeriana.as.personapp.terminal.model.EstudioModelCli;

public class EstudioRequestCliValidator {

    public boolean validate(EstudioCli estudio) {
        if (estudio == null) {
            return false;
        }
        if (estudio.getId() == null || estudio.getId().isEmpty()) {
            return false;
        }
        if (estudio.getNombre() == null || estudio.getNombre().isEmpty()) {
            return false;
        }
        // Más reglas de validación si es necesario
        return true;
    }
}

}
