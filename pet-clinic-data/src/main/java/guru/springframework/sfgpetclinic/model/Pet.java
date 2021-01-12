package guru.springframework.sfgpetclinic.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.EAGER;

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

    @OneToMany(mappedBy = "pet", cascade = ALL)
    private Set<Visit> visits = new HashSet<>();


}
