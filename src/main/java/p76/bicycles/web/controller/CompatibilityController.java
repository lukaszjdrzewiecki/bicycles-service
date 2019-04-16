package p76.bicycles.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import p76.bicycles.db.entity.Bicycle;
import p76.bicycles.db.repository.BicycleRepository;
import p76.bicycles.service.CompatibilityService;

import java.util.Optional;

@RestController
@RequestMapping(path = "/compatibility")
public class CompatibilityController {

    @Autowired
    private CompatibilityService service;

    @Autowired
    private BicycleRepository repository;

    public void checkCompatibiltiy(Bicycle bicycle) {
        service.bicycleCheck(bicycle);
    }

    @GetMapping("{id}")
    public ResponseEntity findBicycle(@PathVariable("id") Long id) {
        Optional<Bicycle> bicycle = repository.findById(id);
        if (!bicycle.isPresent()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        return ResponseEntity.ok(service.bicycleCheck(bicycle.get()));
    }

}
