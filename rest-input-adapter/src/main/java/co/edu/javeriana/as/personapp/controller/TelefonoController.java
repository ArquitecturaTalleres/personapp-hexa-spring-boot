package co.edu.javeriana.as.personapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import co.edu.javeriana.as.personapp.adapter.TelefonoInputAdapterRest;
import co.edu.javeriana.as.personapp.model.request.TelefonoRequest;
import co.edu.javeriana.as.personapp.model.response.TelefonoResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/v1/telefono")
public class TelefonoController {

    @Autowired
    private TelefonoInputAdapterRest telefonoInputAdapterRest;

    @ResponseBody
    @GetMapping(path = "/{database}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TelefonoResponse> telefonos(@PathVariable String database) {
        log.info("Into telefonos REST API");
        return telefonoInputAdapterRest.historial(database.toUpperCase());
    }

    @ResponseBody
    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public TelefonoResponse crearTelefono(@RequestBody TelefonoRequest request) {
        log.info("Into crearTelefono REST API");
        return telefonoInputAdapterRest.crearTelefono(request);
    }

    @ResponseBody
    @PutMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public TelefonoResponse actualizarTelefono(@RequestBody TelefonoRequest request) {
        log.info("Into actualizarTelefono REST API");
        return telefonoInputAdapterRest.actualizarTelefono(request);
    }

    @ResponseBody
    @DeleteMapping(path = "/{numero}/{database}", produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean eliminarTelefono(@PathVariable String numero, @PathVariable String database) {
        log.info("Into eliminarTelefono REST API");
        return telefonoInputAdapterRest.eliminarTelefono(numero, database.toUpperCase());
    }
}
