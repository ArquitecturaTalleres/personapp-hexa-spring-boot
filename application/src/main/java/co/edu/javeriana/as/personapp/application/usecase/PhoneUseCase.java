package co.edu.javeriana.as.personapp.application.usecase;

import co.edu.javeriana.as.personapp.application.port.in.PhoneInputPort;
import co.edu.javeriana.as.personapp.application.port.out.PhoneOutputPort;
import co.edu.javeriana.as.personapp.domain.Phone;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class PhoneUseCase implements PhoneInputPort {

    private final PhoneOutputPort phonePersistence;

    @Override
    public Phone create(Phone phone) {
        return phonePersistence.save(phone);
    }

    @Override
    public List<Phone> findAll() {
        return phonePersistence.findAll();
    }

    @Override
    public Phone findByNumber(String number) {
        return phonePersistence.findByNumber(number);
    }

    @Override
    public Phone update(String number, Phone phone) {
        phone.setNumber(number);
        return phonePersistence.save(phone);
    }

    @Override
    public void delete(String number) {
        phonePersistence.delete(number);
    }
}
