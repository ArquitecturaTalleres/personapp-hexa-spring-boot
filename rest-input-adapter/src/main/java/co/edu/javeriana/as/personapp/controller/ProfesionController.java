package co.edu.javeriana.as.personapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import co.edu.javeriana.as.personapp.adapter.ProfesionInputAdapterRest;
import co.edu.javeriana.as.personapp.model.request.ProfesionRequest;
import co.edu.javeriana.as.personapp.model.response.ProfesionResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/v1/profesion")
public class ProfesionController {

    @Autowired
    private ProfesionInputAdapterRest profesionInputAdapterRest;

    @ResponseBody
    @GetMapping(path = "/{database}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ProfesionResponse> profesiones(@PathVariable String database) {
        log.info("Into profesiones REST API");
        return profesionInputAdapterRest.historial(database.toUpperCase());
    }

    @ResponseBody
    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ProfesionResponse crearProfesion(@RequestBody ProfesionRequest request) {
        log.info("En el método crearProfesion en el controller del API");
        return profesionInputAdapterRest.crearProfesion(request);
    }

    @ResponseBody
    @PutMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ProfesionResponse editarProfesion(@PathVariable String id, @RequestBody ProfesionRequest request) {
        log.info("En el método editarProfesion en el controller del API");
        return profesionInputAdapterRest.editarProfesion(id, request);
    }

    @ResponseBody
    @DeleteMapping(path = "/{database}/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean eliminarProfesion(@PathVariable String database, @PathVariable String id) {
        log.info("En el método eliminarProfesion en el controller del API");
        return profesionInputAdapterRest.eliminarProfesion(database.toUpperCase(), id);
    }
}
