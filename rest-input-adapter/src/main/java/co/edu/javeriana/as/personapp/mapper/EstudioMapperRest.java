package co.edu.javeriana.as.personapp.mapper;

import java.time.LocalDate;

import co.edu.javeriana.as.personapp.common.annotations.Mapper;
import co.edu.javeriana.as.personapp.domain.Person;
import co.edu.javeriana.as.personapp.domain.Profession;
import co.edu.javeriana.as.personapp.domain.Study;
import co.edu.javeriana.as.personapp.model.request.EstudioRequest;
import co.edu.javeriana.as.personapp.model.response.EstudioResponse;

@Mapper
public class EstudioMapperRest {

    public EstudioResponse fromDomainToAdapterRestMaria(Study study) {
        return fromDomainToAdapterRest(study, "MariaDB");
    }

    public EstudioResponse fromDomainToAdapterRestMongo(Study study) {
        return fromDomainToAdapterRest(study, "MongoDB");
    }

    public EstudioResponse fromDomainToAdapterRest(Study study, String database) {
        return new EstudioResponse(
                String.valueOf(study.getPerson().getIdentification()),
                String.valueOf(study.getProfession().getIdentification()),
                study.getGraduationDate() != null ? study.getGraduationDate().toString() : "",
                study.getUniversityName(),
                database,
                "OK");
    }

    public Study fromAdapterToDomain(EstudioRequest request, Person person, Profession profession) {
        Study study = new Study();
        study.setPerson(person);
        study.setProfession(profession);
        study.setUniversityName(request.getUniversidad());

        if (request.getFechaGraduacion() != null && !request.getFechaGraduacion().isEmpty()) {
            study.setGraduationDate(LocalDate.parse(request.getFechaGraduacion()));
        }

        return study;
    }
}
