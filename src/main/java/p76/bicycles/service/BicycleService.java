package p76.bicycles.service;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import p76.bicycles.db.entity.Bicycle;
import p76.bicycles.db.entity.drivetrain.RearDerailleur;
import p76.bicycles.db.repository.BicycleRepository;

@Data
@Component
public class BicycleService {

    @Autowired
    BicycleRepository repository;

    @Autowired
    BicyclePartsService partsService;


    public List<Bicycle> findBicycle(String name) {
        return repository.findByName(name);
    }

    public Bicycle addBicycle(Bicycle newBicycle) {
        newBicycle.setRearDerailleur(
                partsService.findByProductId(RearDerailleur.class, newBicycle.getRearDerailleurInfo())
        );
        return repository.save(newBicycle);
    }

    public Bicycle addBicycle(String name, String brand) {
        Bicycle newBicycle = new Bicycle();
        newBicycle.setName(name);
        newBicycle.setManufacturer(brand);
        return repository.save(newBicycle);
    }

    public List<Bicycle> findAllBicycles() {
        Iterable<Bicycle> iterable = repository.findAll();
        List<Bicycle> bicycles = new ArrayList();
        for(Bicycle bicycle : iterable) {
            bicycles.add(bicycle);
        }
        return bicycles;
    }
}


