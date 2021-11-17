package co.colco.medicalrepresentative.repository;

import co.colco.medicalrepresentative.model.Representative;
import org.springframework.data.mongodb.repository.MongoRepository;

import javax.annotation.Resource;

@Resource
public interface RepresentativeRepository extends MongoRepository<Representative, String> {
}
