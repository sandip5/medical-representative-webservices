package co.colco.medicalrepresentative.dao;

import co.colco.medicalrepresentative.model.Representative;
import co.colco.medicalrepresentative.repository.RepresentativeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.NoSuchElementException;

@Component
@AllArgsConstructor
public class RepresentativeDao {
    private final RepresentativeRepository representativeRepository;

    public List<Representative> getRepresentatives() {
        return representativeRepository.findAll();
    }

    public Representative getRepresentative(String representativeId) {
        return representativeRepository.findById(representativeId).get();
    }

    public Representative createRepresentative(Representative representative) {
        return representativeRepository.insert(representative);
    }

    public Representative updateRepresentative(String representativeId, Representative representative) {
        Representative updatedRepresentative = getRepresentative(representativeId);
        updatedRepresentative.setRepresentativeName(representative.getRepresentativeName());
        updatedRepresentative.setDrugs(representative.getDrugs());
        return representativeRepository.save(updatedRepresentative);
    }

    public void deleteRepresentativeUsingId(String representativeId) {
        try {
            representativeRepository.deleteById(representativeId);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }
}
