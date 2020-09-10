package workshop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import workshop.db.dto.BicycleDto;
import workshop.db.entity.Bicycle;
import workshop.db.repository.BicycleRepository;
import workshop.db.repository.CrankRepository;
import workshop.service.BicycleService;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/bicycles")
public class BicycleController {

    private final BicycleService service;

    @GetMapping
    public List<BicycleDto> getAllBicycles() {
        return service.findAllBicycles();
    }

    @GetMapping("/{bicycleUid}")
    public List<BicycleDto> getAllBicycles(@PathVariable String bicycleUid) {
        return service.findAllBicycles();
    }

    @PostMapping
    public Bicycle addBicycle(@RequestBody Bicycle bicycle) {
        return service.addBicycle(bicycle);
    }

}
