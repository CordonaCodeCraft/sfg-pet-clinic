package guru.springframework.sfgpetclinic.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.FetchType.EAGER;

@Getter
@Setter

@Entity
@Table(name = "vets")
public class Vet extends Person {

    @ManyToMany(fetch = EAGER)
    @JoinTable(
            name = "vets_specialities",
            joinColumns = @JoinColumn(name = "vet_id"),
            inverseJoinColumns = @JoinColumn(name = "speciality_id") )
    private Set<Speciality> specialities = new HashSet<>();

}
