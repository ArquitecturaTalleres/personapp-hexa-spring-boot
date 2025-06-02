package co.edu.javeriana.as.personapp.application.usecase;

import co.edu.javeriana.as.personapp.application.port.in.ProfessionInputPort;
import co.edu.javeriana.as.personapp.application.port.out.ProfessionOutputPort;
import co.edu.javeriana.as.personapp.common.annotations.UseCase;
import co.edu.javeriana.as.personapp.domain.Profession;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@UseCase
public class ProfessionUseCase implements ProfessionInputPort {

    private ProfessionOutputPort professionPersistence;

    public void setProfessionOutputPort(ProfessionOutputPort professionPersistence) {
        this.professionPersistence = professionPersistence;
    }

    @Override
    public Profession create(Profession profession) {
        log.debug("Creating profession {}", profession);
        return professionPersistence.save(profession);
    }

    @Override
    public Profession edit(Integer id, Profession profession) {
        log.debug("Editing profession {}", profession);
        return professionPersistence.update(id, profession);
    }

    @Override
    public Boolean delete(Integer id) {
        log.debug("Deleting profession with id {}", id);
        return professionPersistence.delete(id);
    }

    @Override
    public List<Profession> findAll() {
        log.debug("Finding all professions");
        return professionPersistence.findAll();
    }

    @Override
    public Profession findOne(Integer id) {
        log.debug("Finding profession with id {}", id);
        return professionPersistence.findById(id);
    }
}
