package co.colco.medicalrepresentative.service;

import co.colco.medicalrepresentative.dao.RepresentativeDao;
import co.colco.medicalrepresentative.model.Representative;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RepresentativeService {
    private final RepresentativeDao representativeDao;


    public RepresentativeService(RepresentativeDao representativeDao) {
        this.representativeDao = representativeDao;
    }

    public List<Representative> getRepresentatives() {
        return representativeDao.getRepresentatives();
    }

    public Representative getRepresentative(String representativeId) {
        return representativeDao.getRepresentative(representativeId);
    }

    public Representative createRepresentative(Representative representative) {
        return representativeDao.createRepresentative(representative);
    }

    public Representative updateRepresentative(String representativeId, Representative representative) {
        Representative dbFetchedRepresentative = getRepresentative(representativeId);
        if(!(Objects.equals(representative.getRepresentativeName(), "") || representative.getRepresentativeName().equals(null))) {
            dbFetchedRepresentative.setRepresentativeName(representative.getRepresentativeName());
        }
        Map<String, Integer> updatedRepresentativeDrugDetail = new HashMap<>();
        Map<String, Integer> dbRepresentativeDrugDetail = dbFetchedRepresentative.getDrugDetails();
        Map<String, Integer> bodyRepresentativeDrugDetail = representative.getDrugDetails();
        for(Map.Entry<String, Integer> bodyDrugDetail : bodyRepresentativeDrugDetail.entrySet()) {
            for (Map.Entry<String, Integer> dbDrugDetail : dbRepresentativeDrugDetail.entrySet()) {
                if (Objects.equals(dbDrugDetail.getKey(), bodyDrugDetail.getKey())) {
                    updatedRepresentativeDrugDetail.put(dbDrugDetail.getKey(), dbDrugDetail.getValue() + bodyDrugDetail.getValue());
                } else {
                    updatedRepresentativeDrugDetail.put(bodyDrugDetail.getKey(), bodyDrugDetail.getValue());
                }
            }
        }
        dbFetchedRepresentative.setDrugDetails(updatedRepresentativeDrugDetail);
        return representativeDao.updateRepresentative(representativeId, dbFetchedRepresentative);
    }

    public void deleteRepresentative(String representativeId) {
        representativeDao.deleteRepresentativeUsingId(representativeId);
    }
}
