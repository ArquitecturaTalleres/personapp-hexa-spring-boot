package co.edu.javeriana.as.personapp.terminal.controller;

import co.edu.javeriana.as.personapp.terminal.model.EstudioModelCli;
import co.edu.javeriana.as.personapp.terminal.validator.EstudioRequestCliValidator;

public class EstudioControllerCli {

    private EstudioRequestCliValidator validator;

    public EstudioControllerCli() {
        this.validator = new EstudioRequestCliValidator();
    }

    public boolean crearEstudio(EstudioModelCli estudio) {
        if (validator.validate(estudio)) {
            // Aquí podría guardarlo en BD o hacer alguna acción
            System.out.println("Estudio válido creado: " + estudio);
            return true;
        } else {
            System.out.println("Estudio inválido, no se puede crear.");
            return false;
        }
    }

    // Otros métodos (actualizar, eliminar, buscar) pueden ir aquí

}
