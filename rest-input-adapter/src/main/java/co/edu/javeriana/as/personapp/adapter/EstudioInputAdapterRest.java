package co.edu.javeriana.as.personapp.adapter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import co.edu.javeriana.as.personapp.application.port.in.StudyInputPort;
import co.edu.javeriana.as.personapp.application.port.out.StudyOutputPort;
import co.edu.javeriana.as.personapp.application.usecase.StudyUseCase;
import co.edu.javeriana.as.personapp.common.annotations.Adapter;
import co.edu.javeriana.as.personapp.common.exceptions.InvalidOptionException;
import co.edu.javeriana.as.personapp.common.setup.DatabaseOption;
import co.edu.javeriana.as.personapp.domain.Person;
import co.edu.javeriana.as.personapp.domain.Profession;
import co.edu.javeriana.as.personapp.domain.Study;
import co.edu.javeriana.as.personapp.mapper.EstudioMapperRest;
import co.edu.javeriana.as.personapp.model.request.EstudioRequest;
import co.edu.javeriana.as.personapp.model.response.EstudioResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Adapter
public class EstudioInputAdapterRest {

    @Autowired
    @Qualifier("estudioOutputAdapterMaria")
    private StudyOutputPort estudioOutputPortMaria;

    @Autowired
    @Qualifier("estudioOutputAdapterMongo")
    private StudyOutputPort estudioOutputPortMongo;

    @Autowired
    private EstudioMapperRest estudioMapperRest;

    private StudyInputPort estudioInputPort;

    private String setEstudioOutputPortInjection(String dbOption) throws InvalidOptionException {
        if (dbOption.equalsIgnoreCase(DatabaseOption.MARIA.toString())) {
            estudioInputPort = new StudyUseCase(estudioOutputPortMaria);
            return DatabaseOption.MARIA.toString();
        } else if (dbOption.equalsIgnoreCase(DatabaseOption.MONGO.toString())) {
            estudioInputPort = new StudyUseCase(estudioOutputPortMongo);
            return DatabaseOption.MONGO.toString();
        } else {
            throw new InvalidOptionException("Invalid database option: " + dbOption);
        }
    }

    public List<EstudioResponse> historial(String database) {
        log.info("Into historial EstudioEntity in Input Adapter");
        try {
            if (setEstudioOutputPortInjection(database).equalsIgnoreCase(DatabaseOption.MARIA.toString())) {
                return estudioInputPort.findAll().stream()
                        .map(estudioMapperRest::fromDomainToAdapterRestMaria)
                        .collect(Collectors.toList());
            } else {
                return estudioInputPort.findAll().stream()
                        .map(estudioMapperRest::fromDomainToAdapterRestMongo)
                        .collect(Collectors.toList());
            }
        } catch (InvalidOptionException e) {
            log.warn(e.getMessage());
            return new ArrayList<>();
        }
    }

    public EstudioResponse crearEstudio(EstudioRequest request, Person persona, Profession profesion) {
        try {
            setEstudioOutputPortInjection(request.getDatabase());

            Study study = estudioMapperRest.fromAdapterToDomain(request, persona, profesion);
            Study creado = estudioInputPort.create(study);

            return estudioMapperRest.fromDomainToAdapterRest(creado, request.getDatabase());
        } catch (InvalidOptionException e) {
            log.warn(e.getMessage());
        } catch (Exception e) {
            log.error("Error creando estudio: " + e.getMessage());
        }
        return null;
    }
}
