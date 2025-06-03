package co.edu.javeriana.as.personapp.terminal.model;


public class PersonaRequestCli {
    private final String nombre;
    private final int edad;

    public PersonaRequestCli(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }
}
