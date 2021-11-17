package co.colco.medicalrepresentative.dao;

import co.colco.medicalrepresentative.model.Representative;
import co.colco.medicalrepresentative.repository.RepresentativeRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Component
public class RepresentativeDao {
    private final RepresentativeRepository representativeRepository;

    public RepresentativeDao(RepresentativeRepository representativeRepository) {
        this.representativeRepository = representativeRepository;
    }

    public List<Representative> getRepresentatives() {
        return representativeRepository.findAll();
    }

    public Representative getRepresentative(String representativeId) {
        return representativeRepository.findById(representativeId).get();
    }

    public Representative createRepresentative(Representative representative) {
        return representativeRepository.save(representative);
    }

    public Representative updateRepresentative(String representativeId, Representative representative) {
        return representativeRepository.save(representative);
    }

    public void deleteRepresentativeUsingId(String representativeId) {
        try {
            representativeRepository.deleteById(representativeId);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }
}
