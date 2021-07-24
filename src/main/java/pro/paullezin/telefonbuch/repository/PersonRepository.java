package pro.paullezin.telefonbuch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.paullezin.telefonbuch.model.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {
}
