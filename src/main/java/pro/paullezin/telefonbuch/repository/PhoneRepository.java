package pro.paullezin.telefonbuch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.paullezin.telefonbuch.model.Phone;

public interface PhoneRepository extends JpaRepository<Phone, Integer> {
}
