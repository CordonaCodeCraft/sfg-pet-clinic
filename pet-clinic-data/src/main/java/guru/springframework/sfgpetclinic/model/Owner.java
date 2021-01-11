package guru.springframework.sfgpetclinic.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class Owner extends Person {

    private String address;
    private String city;
    private String telephone;

    private Set<Pet> pets;
}
