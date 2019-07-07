package p76.bicycles.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import p76.bicycles.db.entity.Bicycle;
import p76.bicycles.db.entity.drivetrain.Crank;
import p76.bicycles.db.repository.BicycleRepository;
import p76.bicycles.db.repository.CrankRestRepository;
import p76.bicycles.service.BicycleService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/bicycle")
public class BicycleController {

    @Autowired
    private BicycleService service;

    @Autowired
    private BicycleRepository repository;

    @Autowired
    private CrankRestRepository crankRepository;

    @GetMapping
    public List<Bicycle> getAllBicycles() {
        return service.findAllBicycles();
    }

    @PostMapping(path= "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Bicycle> addEmployee(@RequestBody Bicycle bicycle)
    {
        service.addBicycle(bicycle);
        return ResponseEntity.ok(bicycle);
    }

    @GetMapping("{id}")
    public ResponseEntity findBicycle(@PathVariable("id") Long id) {
        Optional<Bicycle> bicycle = repository.findById(id);
        if (!bicycle.isPresent()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        return ResponseEntity.ok(bicycle.get());
    }
}
