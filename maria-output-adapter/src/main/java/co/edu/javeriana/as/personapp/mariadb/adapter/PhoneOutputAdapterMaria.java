package co.edu.javeriana.as.personapp.mariadb.adapter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import co.edu.javeriana.as.personapp.application.port.out.PhoneOutputPort;
import co.edu.javeriana.as.personapp.domain.Phone;
import co.edu.javeriana.as.personapp.mariadb.entity.TelefonoEntity;
import co.edu.javeriana.as.personapp.mariadb.mapper.TelefonoMapperMaria;
import co.edu.javeriana.as.personapp.mariadb.repository.TelefonoRepositoryMaria;

@Component
@Qualifier("phoneOutputAdapterMaria")
public class PhoneOutputAdapterMaria implements PhoneOutputPort {

    @Autowired
    private TelefonoRepositoryMaria repository;

    @Autowired
    private TelefonoMapperMaria mapper;
    private final TelefonoRepositoryMaria telefonoRepositoryMaria = null;
    private final TelefonoMapperMaria telefonoMapperMaria = new TelefonoMapperMaria();

    @Override
    public Phone save(Phone phone) {
    TelefonoEntity entity = telefonoMapperMaria.toEntity(phone);
    TelefonoEntity savedEntity = telefonoRepositoryMaria.save(entity);
    return telefonoMapperMaria.fromAdapterToDomain(savedEntity);
}

    @Override
    public Boolean delete(String number) {
        if (!repository.existsById(number)) return false;
        repository.deleteById(number);
        return true;
    }

    @Override
    public List<Phone> find() {
        return repository.findAll().stream()
            .map(mapper::fromAdapterToDomain)
            .collect(Collectors.toList());
    }

    @Override
    public Phone findByNumber(String number) {
        return repository.findById(number)
            .map(mapper::fromAdapterToDomain)
            .orElse(null);
    }

    @Override
    public List<Phone> findAll() {
        return telefonoRepositoryMaria.findAll()
            .stream()
            .map(telefonoMapperMaria::fromAdapterToDomain)
            .collect(Collectors.toList());
    }
}
