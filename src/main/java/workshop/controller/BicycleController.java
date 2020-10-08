package workshop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import workshop.db.dto.BicycleDto;
import workshop.db.entity.Bicycle;
import workshop.service.BicycleService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/{userName}/bicycles")
public class BicycleController {

    private final BicycleService service;

    @GetMapping
    public List<BicycleDto> getAllBicycles() {
        return service.findAllBicycles();
    }

    @GetMapping("/{bicycleName}")
    public Bicycle getBicycle(@PathVariable String bicycleName) {
        return service.getBicycleByName(bicycleName);
    }

    @PostMapping
    public Bicycle addBicycle(@RequestBody Bicycle bicycle) {
        return service.addBicycle(bicycle);
    }

    @PutMapping("/{bicycleName}")
    public Bicycle updateBicycle(@PathVariable String bicycleName, @RequestBody Bicycle bicycle) {
        return service.updateBicycle(bicycleName, bicycle);
    }

    @DeleteMapping("/{bicycleName}")
    public void updateBicycle(@PathVariable String bicycleName) {
        service.deleteBicycle(bicycleName);
    }

}
