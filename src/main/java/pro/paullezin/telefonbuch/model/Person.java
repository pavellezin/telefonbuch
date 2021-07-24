package pro.paullezin.telefonbuch.model;

import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@ToString
@NoArgsConstructor
@Table(name = "person", uniqueConstraints = {@UniqueConstraint(columnNames = "name", name = "unique_person")})
public class Person extends NamedEntity {

    public Person(Integer id, String name) {
        super(id, name);
    }
}