package co.edu.javeriana.as.personapp.mariadb.adapter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import co.edu.javeriana.as.personapp.application.port.out.StudyOutputPort;
import co.edu.javeriana.as.personapp.domain.Phone;
import co.edu.javeriana.as.personapp.domain.Study;
import co.edu.javeriana.as.personapp.mariadb.entity.EstudiosEntity;
import co.edu.javeriana.as.personapp.mariadb.entity.EstudiosEntityPK;
import co.edu.javeriana.as.personapp.mariadb.mapper.EstudiosMapperMaria;
import co.edu.javeriana.as.personapp.mariadb.repository.EstudiosRepositoryMaria;

@Component
@Qualifier("studyOutputAdapterMaria")
public class StudyOutputAdapterMaria implements StudyOutputPort {

    @Autowired
    private EstudiosRepositoryMaria repository;

    @Autowired
    private EstudiosMapperMaria mapper;

    @Override
    public Study save(Study study) {
        EstudiosEntity entity = repository.save(mapper.toEntity(study));
        return mapper.fromAdapterToDomain(entity);
    }

    @Override
    public Boolean delete(Integer personId, Integer professionId) {
        EstudiosEntityPK id = new EstudiosEntityPK(personId, professionId);
        if (!repository.existsById(id)) return false;
        repository.deleteById(id);
        return true;
    }

    @Override
    public List<Study> find() {
        return repository.findAll().stream()
            .map(mapper::fromAdapterToDomain)
            .collect(Collectors.toList());
    }

    @Override
    public Study findById(Integer personId, Integer professionId) {
        return repository.findById(new EstudiosEntityPK(personId, professionId))
            .map(mapper::fromAdapterToDomain)
            .orElse(null);
    }

    @Override
    public List<Study> findAll() {
        return repository.findAll()
            .stream()
            .map(mapper::fromAdapterToDomain)
            .collect(Collectors.toList());
    }
}
