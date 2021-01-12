package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.repositories.VetRepository;
import guru.springframework.sfgpetclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class VetSDJpaService implements VetService {

    private final VetRepository vetRepository;

    @Autowired
    public VetSDJpaService(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }

    @Override
    public Set<Vet> findAll() {

        Set<Vet> allVets = new HashSet<>();

        vetRepository
                .findAll()
                .iterator()
                .forEachRemaining(allVets::add);

        return allVets;
    }

    @Override
    public Vet findById(Long id) {
        return this.vetRepository.findById(id).orElse(null);
    }

    @Override
    public Vet save(Vet vet) {
        return this.vetRepository.save(vet);
    }

    @Override
    public void delete(Vet vet) {
        this.vetRepository.delete(vet);
    }

    @Override
    public void deleteById(Long id) {
        this.vetRepository.deleteById(id);
    }
}
