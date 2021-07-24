package pro.paullezin.telefonbuch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import pro.paullezin.telefonbuch.model.Phone;

import java.util.List;

public interface PhoneRepository extends JpaRepository<Phone, Integer> {

    @RestResource(rel = "by-number", path = "by-number")
    List<Phone> findPhoneByNumberContains(String number);
}
