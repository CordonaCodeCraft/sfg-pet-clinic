package guru.springframework.sfgpetclinic.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.CascadeType.ALL;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity(name = "Pet")
@Table(name = "pets")
public class Pet extends BaseEntity {

    @Builder
    public Pet(Long id, String name, PetType petType, LocalDate birthDate, Owner owner, Set<Visit> visits) {
        super(id);
        this.name = name;
        this.petType = petType;
        this.birthDate = birthDate;
        this.owner = owner;
        this.visits = visits;
    }

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
