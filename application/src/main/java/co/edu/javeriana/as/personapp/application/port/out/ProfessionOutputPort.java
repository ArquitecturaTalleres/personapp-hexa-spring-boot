package co.edu.javeriana.as.personapp.application.port.out;

import co.edu.javeriana.as.personapp.domain.Profession;

import java.util.List;

public interface ProfessionOutputPort {
    Profession save(Profession profession);
    Profession update(Integer id, Profession profession);
    Boolean delete(Integer id);
    List<Profession> findAll();
    Profession findById(Integer id);
}
