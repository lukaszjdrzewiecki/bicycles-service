package p76.bicycles.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import p76.bicycles.dto.*;
import p76.bicycles.entity.Greeting;
import p76.bicycles.service.BicycleCompatibility;
import p76.bicycles.service.BicycleGenerator;
import p76.bicycles.service.BicycleService;

import java.util.List;

@RestController
@RequestMapping(path = "/bicycle")
public class BicycleController {

    @Autowired
    BicycleService service;

    @GetMapping
    public List<Bicycle> getAllBicycles() {
        return service.getBicycles();
    }

    @PostMapping(path= "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Bicycle> addEmployee(@RequestBody Bicycle bicycle)
    {
        service.addBicycle(bicycle);
        return ResponseEntity.ok(bicycle);
    }
}
