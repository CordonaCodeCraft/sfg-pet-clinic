package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Owner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import java.util.Set;

class OwnerMapServiceTest {

    OwnerMapService ownerMapService;
    Long ownerId = 1L;

    @BeforeEach
    void setUp() {

        MockitoAnnotations.openMocks(this);
        ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetMapService());
        ownerMapService.save(Owner.builder().id(ownerId).build());
    }

    @Test
    void findAll() {
        Set<Owner> owners = ownerMapService.findAll();
        Assertions.assertEquals(owners.size(), 1);
    }

    @Test
    void deleteById() {
    }

    @Test
    void saveWithIdProvided() {
        Owner ownerWithId = Owner.builder().id(2L).build();
        ownerMapService.save(ownerWithId);
        Assertions.assertNotNull(ownerMapService.findById(2L));

    }

    @Test
    void saveWithIdNotProvided() {

        Long generatedId = ownerMapService.findAll().size() + 1L;

        Owner ownerWithNoId = new Owner();

        Owner savedOwner = ownerMapService.save(ownerWithNoId);

        Assertions.assertEquals(generatedId, savedOwner.getId());

    }

    @Test
    void delete() {
        Owner deletedOwner = Owner.builder().id(2L).build();
        ownerMapService.save(deletedOwner);
        ownerMapService.delete(deletedOwner);
        Assertions.assertNull(ownerMapService.findById(2L));

    }

    @Test
    void findById() {
        Owner owner = ownerMapService.findById(ownerId);
        Assertions.assertEquals(ownerId, owner.getId());
    }

    @Test
    void findByLastName() {
        String lastName = "Smith";
        Owner owner = ownerMapService.save(Owner.builder().lastName(lastName).build());
        Owner foundOwner = ownerMapService.findByLastName(lastName);
        Assertions.assertNotNull(foundOwner);
    }

    @Test
    void findByLastNameNotFound() {
        String lastName = "Smith";
        String invalidLastName = "Doe";
        ownerMapService.save(Owner.builder().lastName(lastName).build());

        Owner invalidOwner = ownerMapService.findByLastName(invalidLastName);

        Assertions.assertNull(invalidOwner);
    }
}