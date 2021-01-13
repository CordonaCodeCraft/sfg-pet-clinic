package guru.springframework.sfgpetclinic.model;

import lombok.*;

import javax.persistence.MappedSuperclass;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@MappedSuperclass
public class Person extends BaseEntity {

    private String firstName;

    private String lastName;

    public Person(Long id, String firstName, String lastName) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
