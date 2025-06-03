package co.edu.javeriana.as.personapp.terminal.validator;
import co.edu.javeriana.as.personapp.terminal.model.PersonaRequestCli; 



public class PersonaRequestCliValidator implements RequestCliValidator<PersonaRequestCli> {

    @Override
    public void validate(PersonaRequestCli request) {
        if (request.getNombre() == null || request.getNombre().isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        if (request.getEdad() < 0 || request.getEdad() > 120) {
            throw new IllegalArgumentException("La edad debe estar entre 0 y 120");
        }
        // Puedes validar otros campos...
    }
}
