package co.colco.medicalrepresentative.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "medical-representative")
@Data
public class Representative {
    @Id
    private String id;
    private String representativeName;
    private List<DrugDetail> drugs;

    public Representative(String representativeName, List<DrugDetail> drugs) {
        this.representativeName = representativeName;
        this.drugs = drugs;
    }

    public Representative() { }
}
