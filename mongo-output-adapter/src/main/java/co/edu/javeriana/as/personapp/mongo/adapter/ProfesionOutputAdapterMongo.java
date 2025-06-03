package co.edu.javeriana.as.personapp.mongo.adapter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.mongodb.MongoWriteException;

import co.edu.javeriana.as.personapp.application.port.out.ProfessionOutputPort;
import co.edu.javeriana.as.personapp.common.annotations.Adapter;
import co.edu.javeriana.as.personapp.domain.Profession;
import co.edu.javeriana.as.personapp.mongo.document.ProfesionDocument;
import co.edu.javeriana.as.personapp.mongo.mapper.ProfesionMapperMongo;
import co.edu.javeriana.as.personapp.mongo.repository.ProfesionRepositoryMongo;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Adapter("professionOutputAdapterMongo")
public class ProfesionOutputAdapterMongo implements ProfessionOutputPort {

    @Autowired
    private ProfesionRepositoryMongo profesionRepositoryMongo;

    @Autowired
    private ProfesionMapperMongo profesionMapperMongo;

    @Override
    public Profession save(Profession profession) {
        log.debug("Into save on Adapter MongoDB (Profesion)");
        try {
            ProfesionDocument persisted = profesionRepositoryMongo
                    .save(profesionMapperMongo.fromDomainToAdapter(profession));
            return profesionMapperMongo.fromAdapterToDomain(persisted);
        } catch (MongoWriteException e) {
            log.warn(e.getMessage());
            return profession;
        }
    }

    @Override
    public Boolean delete(Integer identification) {
        log.debug("Into delete on Adapter MongoDB (Profesion)");
        profesionRepositoryMongo.deleteById(identification);
        return profesionRepositoryMongo.findById(identification).isEmpty();
    }

    @Override
    public Profession findById(Integer identification) {
        log.debug("Into findById on Adapter MongoDB (Profesion)");
        return profesionRepositoryMongo.findById(identification)
                .map(profesionMapperMongo::fromAdapterToDomain)
                .orElse(null);
    }

    @Override
    public List<Profession> findAll() {
        log.debug("Into findAll on Adapter MongoDB (Profesion)");
        return profesionRepositoryMongo.findAll().stream()
                .map(profesionMapperMongo::fromAdapterToDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Profession update(Integer id, Profession profession) {
        log.debug("Into update on Adapter MongoDB (Profesion)");
        return profesionRepositoryMongo.findById(id)
                .map(existing -> {
                    ProfesionDocument updatedDoc = profesionMapperMongo.fromDomainToAdapter(profession);
                    updatedDoc.setId(id);
                    ProfesionDocument saved = profesionRepositoryMongo.save(updatedDoc);
                    return profesionMapperMongo.fromAdapterToDomain(saved);
                })
                .orElse(null);
    }

}
