package pro.paullezin.telefonbuch.model;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@NoArgsConstructor
@Table(name = "person", uniqueConstraints = {@UniqueConstraint(columnNames = "name", name = "unique_person")})
public class Person extends NamedEntity {

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "person")
    private Set<Phone> phones;

    public Person(Integer id, String name) {
        super(id, name);
    }

    public String toString() {
        return "Person(name=" + super.name + ")";
    }
}