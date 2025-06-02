package co.edu.javeriana.as.personapp.application.usecase;

import co.edu.javeriana.as.personapp.application.port.in.StudyInputPort;
import co.edu.javeriana.as.personapp.application.port.out.StudyOutputPort;
import co.edu.javeriana.as.personapp.domain.Study;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class StudyUseCase implements StudyInputPort {

    private final StudyOutputPort studyPersistence;

    @Override
    public Study create(Study study) {
        return studyPersistence.save(study);
    }

    @Override
    public List<Study> findAll() {
        return studyPersistence.findAll();
    }

    @Override
    public Study findById(Integer professionId, Integer personId) {
        return studyPersistence.findById(professionId, personId);
    }

    @Override
    public Study update(Integer professionId, Integer personId, Study study) {
        return studyPersistence.save(study);
    }

    @Override
    public void delete(Integer professionId, Integer personId) {
        studyPersistence.delete(professionId, personId);
    }
}
