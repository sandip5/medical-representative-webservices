package co.colco.medicalrepresentative;

import co.colco.medicalrepresentative.model.DrugDetail;
import co.colco.medicalrepresentative.model.Representative;
import co.colco.medicalrepresentative.repository.RepresentativeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class MedicalrepresentativeApplication {
	public static void main(String[] args) {
		SpringApplication.run(MedicalrepresentativeApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(RepresentativeRepository repository) {
		return args -> {
			DrugDetail paracetamol = new DrugDetail("Paracetamol", 5, 2);
			DrugDetail atropine = new DrugDetail("atropine", 1, 10);
			Representative representative = new Representative(
				"Abhishek",
					Arrays.asList(paracetamol, atropine)
			);
			repository.insert(representative);
		};
	}
}
