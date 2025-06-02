package co.edu.javeriana.as.personapp.application.port.in;

import java.util.List;
import co.edu.javeriana.as.personapp.domain.Study;

public interface StudyInputPort {
    Study create(Study study);
    List<Study> findAll();
    Study findById(Integer professionId, Integer personId);
    Study update(Integer professionId, Integer personId, Study study);
    void delete(Integer professionId, Integer personId);
}
