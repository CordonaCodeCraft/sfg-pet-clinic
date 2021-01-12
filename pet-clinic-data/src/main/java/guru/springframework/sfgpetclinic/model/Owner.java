package guru.springframework.sfgpetclinic.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.CascadeType.ALL;

@Getter
@Setter

@Entity(name = "Owner")
@Table(name = "owners")
public class Owner extends Person {

    private String address;

    private String city;

    private String telephone;

    @OneToMany(mappedBy = "owner", cascade = ALL)
    private Set<Pet> pets = new HashSet<>();
}
