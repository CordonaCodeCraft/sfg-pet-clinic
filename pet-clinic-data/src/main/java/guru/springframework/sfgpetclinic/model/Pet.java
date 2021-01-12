package guru.springframework.sfgpetclinic.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@Getter
@Setter

@Entity(name = "Pet")
@Table(name = "pets")
public class Pet extends BaseEntity {

    private String name;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private PetType petType;

    private LocalDate birthDate;

    @ManyToOne
    private Owner owner;


}
