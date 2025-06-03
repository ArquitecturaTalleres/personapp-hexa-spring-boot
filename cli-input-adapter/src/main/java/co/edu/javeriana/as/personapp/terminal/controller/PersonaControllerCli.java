package co.edu.javeriana.as.personapp.terminal.controller;

import co.edu.javeriana.as.personapp.terminal.adapter.PersonaInputAdapterCli;
import co.edu.javeriana.as.personapp.terminal.model.PersonaModelCli; 
import co.edu.javeriana.as.personapp.terminal.model.PersonaRequestCli; 


import java.util.Scanner;

public class PersonaControllerCli {
    private final PersonaInputAdapterCli personaInput;

    public PersonaControllerCli(PersonaInputAdapterCli personaInput) {
        this.personaInput = personaInput;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese nombre:");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese edad:");
        int edad = scanner.nextInt();

        PersonaRequestCli request = new PersonaRequestCli(nombre, edad);
        personaInput.crearPersona(request);
    }
}

