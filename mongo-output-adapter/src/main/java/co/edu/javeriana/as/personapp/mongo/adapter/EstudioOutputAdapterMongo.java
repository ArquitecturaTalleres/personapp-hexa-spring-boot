package co.edu.javeriana.as.personapp.mongo.adapter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.mongodb.MongoWriteException;

import co.edu.javeriana.as.personapp.application.port.out.StudyOutputPort;
import co.edu.javeriana.as.personapp.common.annotations.Adapter;
import co.edu.javeriana.as.personapp.domain.Study;
import co.edu.javeriana.as.personapp.mongo.document.EstudiosDocument;
import co.edu.javeriana.as.personapp.mongo.mapper.EstudiosMapperMongo;
import co.edu.javeriana.as.personapp.mongo.repository.EstudioRepositoryMongo;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Adapter("studyOutputAdapterMongo")
public class EstudioOutputAdapterMongo implements StudyOutputPort {

    @Autowired
    private EstudioRepositoryMongo estudiosRepositoryMongo;

    @Autowired
    private EstudiosMapperMongo estudiosMapperMongo;

    @Override
    public Study save(Study study) {
        log.debug("Into save on Adapter MongoDB (Estudios)");
        try {
            EstudiosDocument persisted = estudiosRepositoryMongo.save(estudiosMapperMongo.fromDomainToAdapter(study));
            return estudiosMapperMongo.fromAdapterToDomain(persisted);
        } catch (MongoWriteException e) {
            log.warn(e.getMessage());
            return study;
        }
    }

    @Override
    public Boolean delete(Integer personId, Integer professionId) {
        log.debug("Into delete on Adapter MongoDB (Estudios)");
        String id = personId + "-" + professionId;
        estudiosRepositoryMongo.deleteById(id);
        return estudiosRepositoryMongo.findById(id).isEmpty();
    }

    @Override
    public List<Study> find() {
        log.debug("Into find on Adapter MongoDB (Estudios)");
        return estudiosRepositoryMongo.findAll().stream()
                .map(estudiosMapperMongo::fromAdapterToDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Study findById(Integer personId, Integer professionId) {
        log.debug("Into findById on Adapter MongoDB (Estudios)");
        String id = personId + "-" + professionId;
        return estudiosRepositoryMongo.findById(id)
                .map(estudiosMapperMongo::fromAdapterToDomain)
                .orElse(null);
    }

    @Override
    public List<Study> findAll() {
        return find();
    }
}
