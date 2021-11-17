package co.colco.medicalrepresentative.service;

import co.colco.medicalrepresentative.dao.RepresentativeDao;
import co.colco.medicalrepresentative.model.DrugDetail;
import co.colco.medicalrepresentative.model.Representative;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class RepresentativeService {
    private final RepresentativeDao representativeDao;

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
        Representative updatedRepresentative = new Representative();
        if(!(Objects.equals(representative.getRepresentativeName(), "") || representative.getRepresentativeName() == null)) {
            updatedRepresentative.setRepresentativeName(representative.getRepresentativeName());
        }
        List<DrugDetail> dbDrugDetail = dbFetchedRepresentative.getDrugs();
        List<DrugDetail> bodyDrugDetail = representative.getDrugs();
        for(DrugDetail dbDrug : dbDrugDetail)  {
            for(DrugDetail bodyDrug : bodyDrugDetail) {
                if(dbDrug.getDrugName().equals(bodyDrug.getDrugName())) {
                    dbDrug.setAmount(dbDrug.getAmount() + bodyDrug.getAmount());
                }
            }
        }
        for(DrugDetail bodyDrug : bodyDrugDetail) {
            if(dbDrugDetail.stream()
                    .noneMatch(element  -> element.getDrugName().equals(bodyDrug.getDrugName()))) {
                dbDrugDetail.add(bodyDrug);
            }
        }
        updatedRepresentative.setDrugs(dbDrugDetail);
        return representativeDao.updateRepresentative(representativeId, updatedRepresentative);
    }

    public void deleteRepresentative(String representativeId) {
        representativeDao.deleteRepresentativeUsingId(representativeId);
    }
}
