package co.edu.javeriana.as.personapp.application.port.in;

import co.edu.javeriana.as.personapp.common.annotations.Port;
import co.edu.javeriana.as.personapp.domain.Profession;

import java.util.List;

@Port
public interface ProfessionInputPort {
    Profession create(Profession profession);
    Profession edit(Integer id, Profession profession);
    Boolean delete(Integer id);
    List<Profession> findAll();
    Profession findOne(Integer id);
}
