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
import p76.bicycles.service.BicycleService;
import p76.bicycles.service.compatibility.CompatibilityResult;
import p76.bicycles.service.compatibility.CompatibilityService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/compatibility")
public class CompatibilityController {

    @Autowired
    private CompatibilityService compatibility;

    @Autowired
    private BicycleRepository repository;

    @Autowired
    private BicycleService service;

    @GetMapping
    public List<List<CompatibilityResult>> getAllBicycles() {
        return compatibility.bicycleCheckAll();
    }

    @GetMapping("{id}")
    public ResponseEntity findBicycle(@PathVariable("id") Long id) {
        Optional<Bicycle> bicycle = repository.findById(id);
        if (!bicycle.isPresent()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        return ResponseEntity.ok(compatibility.bicycleCheck(bicycle.get()));
    }

}
