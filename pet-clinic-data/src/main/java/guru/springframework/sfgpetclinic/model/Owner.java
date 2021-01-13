package guru.springframework.sfgpetclinic.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.CascadeType.ALL;

@Getter
@Setter
@NoArgsConstructor

@Entity(name = "Owner")
@Table(name = "owners")
public class Owner extends Person {

    private String address;

    private String city;

    private String telephone;

    @Builder
    public Owner(Long id, String firstName, String lastName,
                 String address, String city, String telephone, Set<Pet> pets) {
        super(id, firstName, lastName);
        this.address = address;
        this.city = city;
        this.telephone = telephone;
        this.pets = pets;
    }

    public Owner(String address, String city, String telephone, Set<Pet> pets) {
        this.address = address;
        this.city = city;
        this.telephone = telephone;
        this.pets = pets;
    }

    @OneToMany(mappedBy = "owner", cascade = ALL)
    private Set<Pet> pets = new HashSet<>();
}
