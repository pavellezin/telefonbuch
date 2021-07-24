package pro.paullezin.telefonbuch.model;

import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Entity
@ToString
@NoArgsConstructor
@Table(name = "person", uniqueConstraints = {@UniqueConstraint(columnNames = "name", name = "unique_person")})
public class Person extends NamedEntity {

    @OneToMany(mappedBy = "person")
    private Set<Phone> phones;

    public Person(Integer id, String name) {
        super(id, name);
    }
}