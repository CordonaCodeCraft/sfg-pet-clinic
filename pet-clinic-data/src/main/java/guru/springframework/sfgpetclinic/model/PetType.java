package guru.springframework.sfgpetclinic.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity(name = "Type")
@Table(name = "types")
public class PetType extends BaseEntity {

    private String name;


}
