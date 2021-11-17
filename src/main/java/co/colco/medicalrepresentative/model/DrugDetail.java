package co.colco.medicalrepresentative.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DrugDetail {
    private String drugName;
    private int price;
    private int amount;
}
