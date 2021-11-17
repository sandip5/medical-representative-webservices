package co.colco.medicalrepresentative.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;
import java.util.Map;

@Document(collection = "medical-representative")
public class Representative {
    @Id
    private String representativeId;
    private String representativeName;
    private Map<String, Integer> drugWithQuantity = new HashMap<>();

    public Representative(@JsonProperty("id") String representativeId, @JsonProperty("name") String representativeName,
                          @JsonProperty("drug-detail") Map<String, Integer> drugWithQuantity) {
        this.representativeId = representativeId;
        this.representativeName = representativeName;
        this.drugWithQuantity = drugWithQuantity;
    }

    public Representative(String representativeId, String representativeName) {
        this.representativeId = representativeId;
        this.representativeName = representativeName;
    }

    public String getRepresentativeId() {
        return representativeId;
    }

    public void setRepresentativeId(String representativeId) {
        this.representativeId = representativeId;
    }

    public String getRepresentativeName() {
        return representativeName;
    }

    public void setRepresentativeName(String representativeName) {
        this.representativeName = representativeName;
    }

    public Map<String, Integer>  getDrugDetails() {
        return drugWithQuantity;
    }

    public void setDrugDetails(Map<String, Integer>  drugWithQuantity) {
        this.drugWithQuantity = drugWithQuantity;
    }
}
