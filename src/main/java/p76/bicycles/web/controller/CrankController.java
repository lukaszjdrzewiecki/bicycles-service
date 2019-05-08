package p76.bicycles.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import p76.bicycles.db.entity.Bicycle;
import p76.bicycles.db.entity.drivetrain.Crank;
import p76.bicycles.db.repository.BicycleRepository;
import p76.bicycles.db.repository.CrankRestRepository;
import p76.bicycles.service.BicycleService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/cranks")
public class CrankController {

    @Autowired
    BicycleService service;

    @Autowired
    CrankRestRepository crankRepository;

    @GetMapping
    public List<Crank> getAllCranks() {
        return service.findAllCranks();
    }

    @PostMapping(path= "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Crank> addCrank(@RequestBody Crank crank)
    {
        service.addCrank(crank);
        return ResponseEntity.ok(crank);
    }

    @GetMapping("{id}")
    public ResponseEntity findCrank(@PathVariable("id") Long id) {
        Optional<Crank> crank = crankRepository.findById(id);
        if (!crank.isPresent()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        return ResponseEntity.ok(crank.get());
    }
}
