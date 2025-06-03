package co.edu.javeriana.as.personapp.application.port.out;

import java.util.List;

import co.edu.javeriana.as.personapp.domain.Phone;

public interface PhoneOutputPort {
    Phone save(Phone phone);

    Boolean delete(String number);

    List<Phone> find();

    List<Phone> findAll();

    Phone findByNumber(String number);
}
