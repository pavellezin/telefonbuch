package pro.paullezin.telefonbuch.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "phone", uniqueConstraints = {@UniqueConstraint(columnNames = {"code", "number"}, name = "unique_phone")})
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Phone extends BaseEntity {

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "person_id", nullable = false)
    @NotNull
    private Person person;

    @NotNull
    @Column(name = "code", nullable = false)
    private int code;

    @NotNull
    @Column(name = "number", nullable = false)
    private String number;

    public Phone(Integer id, Person person, Integer code, String number) {
        super(id);
        this.person = person;
        this.code = code;
        this.number = number;
    }
}