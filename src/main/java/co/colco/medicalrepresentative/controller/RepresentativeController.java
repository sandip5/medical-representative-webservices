package co.colco.medicalrepresentative.controller;

import co.colco.medicalrepresentative.model.Representative;
import co.colco.medicalrepresentative.service.RepresentativeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/representative")
public class RepresentativeController {
    private final Logger LOG = LoggerFactory.getLogger(getClass());
    private final RepresentativeService representativeService;

    public RepresentativeController(RepresentativeService representativeService) {
        this.representativeService = representativeService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity getRepresentatives() {
        LOG.info("Get All Representatives");
        return new ResponseEntity(representativeService.getRepresentatives(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{representativeId}", method = RequestMethod.GET)
    public ResponseEntity<Representative> getRepresentative(@PathVariable String representativeId) {
        LOG.info("Getting representative by Id: {}", representativeId);
        return new ResponseEntity(representativeService.getRepresentative(representativeId), HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<Representative> createRepresentative(@RequestBody Representative representative) {
        LOG.info("Create Representative");
        return new ResponseEntity(representativeService.createRepresentative(representative), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{representativeId}", method = RequestMethod.PUT)
    public ResponseEntity<Representative> updateRepresentative(@PathVariable String representativeId,
                                                               @RequestBody Representative representative) {
        LOG.info("Update Representative");
        return new ResponseEntity(representativeService.updateRepresentative(representativeId, representative), HttpStatus.OK);
    }

    @RequestMapping(value = "/{representativeId}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteRepresentative(@PathVariable String representativeId) {
        LOG.info("Delete representative by Id: {}", representativeId);
        return new ResponseEntity("Deleted", HttpStatus.OK);
    }
}
