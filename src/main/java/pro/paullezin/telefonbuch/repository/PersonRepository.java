package pro.paullezin.telefonbuch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RestResource;
import pro.paullezin.telefonbuch.model.Person;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Integer> {

    @RestResource(rel = "by-name", path = "by-name")
    @Query("SELECT p FROM Person p WHERE p.name LIKE CONCAT('%',:name,'%')")
    List<Person> findByName(String name);
}