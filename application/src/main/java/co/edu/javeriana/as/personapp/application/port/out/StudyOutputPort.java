package co.edu.javeriana.as.personapp.application.port.out;

import java.util.List;

import co.edu.javeriana.as.personapp.domain.Study;

public interface StudyOutputPort {
    Study save(Study study);

    Boolean delete(Integer personId, Integer professionId);

    List<Study> find();

    List<Study> findAll();

    Study findById(Integer personId, Integer professionId);
}