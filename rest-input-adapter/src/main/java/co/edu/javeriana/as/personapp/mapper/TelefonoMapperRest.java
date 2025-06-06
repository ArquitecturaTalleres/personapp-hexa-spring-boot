package co.edu.javeriana.as.personapp.mapper;

import co.edu.javeriana.as.personapp.common.annotations.Mapper;
import co.edu.javeriana.as.personapp.domain.Person;
import co.edu.javeriana.as.personapp.domain.Phone;
import co.edu.javeriana.as.personapp.model.request.TelefonoRequest;
import co.edu.javeriana.as.personapp.model.response.TelefonoResponse;

@Mapper
public class TelefonoMapperRest {

    public TelefonoResponse fromDomainToAdapterRestMaria(Phone phone) {
        return fromDomainToAdapterRest(phone, "MariaDB");
    }

    public TelefonoResponse fromDomainToAdapterRestMongo(Phone phone) {
        return fromDomainToAdapterRest(phone, "MongoDB");
    }

    public TelefonoResponse fromDomainToAdapterRest(Phone phone, String database) {
        return new TelefonoResponse(
                phone.getNumber(),
                phone.getCompany(),
                phone.getOwner().getIdentification().toString(),
                database,
                "OK");
    }

    public Phone fromAdapterToDomain(TelefonoRequest request, Person owner) {
        Phone phone = new Phone();
        phone.setNumber(request.getNumero());
        phone.setCompany(request.getCompania());
        phone.setOwner(owner);
        return phone;
    }
}
