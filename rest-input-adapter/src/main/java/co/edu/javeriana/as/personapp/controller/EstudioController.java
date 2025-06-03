package co.edu.javeriana.as.personapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import co.edu.javeriana.as.personapp.adapter.EstudioInputAdapterRest;
import co.edu.javeriana.as.personapp.adapter.PersonaInputAdapterRest;
import co.edu.javeriana.as.personapp.adapter.ProfesionInputAdapterRest;
import co.edu.javeriana.as.personapp.domain.Gender;
import co.edu.javeriana.as.personapp.domain.Person;
import co.edu.javeriana.as.personapp.domain.Profession;
import co.edu.javeriana.as.personapp.model.request.EstudioRequest;
import co.edu.javeriana.as.personapp.model.response.EstudioResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/v1/estudio")
public class EstudioController {

    @Autowired
    private EstudioInputAdapterRest estudioInputAdapterRest;

    @Autowired
    private PersonaInputAdapterRest personaInputAdapterRest;

    @Autowired
    private ProfesionInputAdapterRest profesionInputAdapterRest;

    @ResponseBody
    @GetMapping(path = "/{database}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<EstudioResponse> estudios(@PathVariable String database) {
        log.info("Entrando al método GET de estudios con base de datos: {}", database);
        return estudioInputAdapterRest.historial(database.toUpperCase());
    }

    @ResponseBody
    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public EstudioResponse crearEstudio(@RequestBody EstudioRequest request) {
        log.info("Entrando al método POST de estudio");

        // TODO: Obtener objetos `Person` y `Profession` desde sus
        String db = request.getDatabase().toUpperCase();

        List<Person> personas = personaInputAdapterRest.historial(db).stream()
                .filter(p -> p.getDni().equals(request.getIdPersona()))
                .map(p -> {
                    Person person = new Person();
                    person.setIdentification(Integer.parseInt(p.getDni()));
                    person.setFirstName(p.getFirstName());
                    person.setLastName(p.getLastName());

                    Gender genderEnum = "F".equalsIgnoreCase(p.getSex()) ? Gender.FEMALE
                            : "M".equalsIgnoreCase(p.getSex()) ? Gender.MALE : Gender.OTHER;
                    person.setGender(genderEnum);

                    person.setAge(Integer.parseInt(p.getAge()));
                    return person;
                }).toList();

        if (personas.isEmpty()) {
            throw new RuntimeException("Persona no encontrada con id: " + request.getIdPersona());
        }

        Person persona = personas.get(0);

        List<Profession> profesiones = profesionInputAdapterRest.historial(db).stream()
                .filter(p -> p.getId().equals(request.getIdProfesion()))
                .map(p -> {
                    Profession profession = new Profession();
                    profession.setIdentification(Integer.parseInt(p.getId()));
                    profession.setName(p.getName());
                    profession.setDescription(p.getDescription());
                    return profession;
                }).toList();

        if (profesiones.isEmpty()) {
            throw new RuntimeException("Profesión no encontrada con id: " + request.getIdProfesion());
        }

        Profession profesion = profesiones.get(0);

        return estudioInputAdapterRest.crearEstudio(request, persona, profesion);
    }
}
