package guru.springframework.sfgpetclinic.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

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

        if (visits == null || visits.size() > 0)
            this.visits = visits;
    }

    private String name;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private PetType petType;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;

    @ManyToOne
    private Owner owner;

    @OneToMany(mappedBy = "pet", cascade = ALL)
    private Set<Visit> visits = new HashSet<>();


}
