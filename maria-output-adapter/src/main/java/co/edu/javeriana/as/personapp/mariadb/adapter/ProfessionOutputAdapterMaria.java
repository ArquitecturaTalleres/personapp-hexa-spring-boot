package co.edu.javeriana.as.personapp.mariadb.adapter;

import co.edu.javeriana.as.personapp.application.port.out.ProfessionOutputPort;
import co.edu.javeriana.as.personapp.domain.Profession;
import co.edu.javeriana.as.personapp.mariadb.entity.ProfesionEntity;
import co.edu.javeriana.as.personapp.mariadb.mapper.ProfesionMapperMaria;
import co.edu.javeriana.as.personapp.mariadb.repository.ProfesionRepositoryMaria;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@Qualifier("professionOutputAdapterMaria")
@RequiredArgsConstructor
public class ProfessionOutputAdapterMaria implements ProfessionOutputPort {

    private final ProfesionRepositoryMaria repository;
    private final ProfesionMapperMaria mapper;

    @Override
    public Profession save(Profession profession) {
        ProfesionEntity entity = repository.save(mapper.fromDomainToEntity(profession));
        return mapper.fromEntityToDomain(entity);
    }

    @Override
    public Profession update(Integer id, Profession profession) {
        if (!repository.existsById(id)) return null;
        ProfesionEntity entity = mapper.fromDomainToEntity(profession);
        entity.setId(id);
        return mapper.fromEntityToDomain(repository.save(entity));
    }

    @Override
    public Boolean delete(Integer id) {
        if (!repository.existsById(id)) return false;
        repository.deleteById(id);
        return true;
    }

    @Override
    public List<Profession> findAll() {
        return repository.findAll().stream()
                .map(mapper::fromEntityToDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Profession findById(Integer id) {
        Optional<ProfesionEntity> entity = repository.findById(id);
        return entity.map(mapper::fromEntityToDomain).orElse(null);
    }
}
