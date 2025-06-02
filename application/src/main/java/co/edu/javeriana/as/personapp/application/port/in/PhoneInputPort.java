package co.edu.javeriana.as.personapp.application.port.in;

import java.util.List;
import co.edu.javeriana.as.personapp.domain.Phone;

public interface PhoneInputPort {
    Phone create(Phone phone);
    List<Phone> findAll();
    Phone findByNumber(String number);
    Phone update(String number, Phone phone);
    void delete(String number);
}