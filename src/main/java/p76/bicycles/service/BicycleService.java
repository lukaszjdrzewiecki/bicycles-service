package p76.bicycles.service;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import p76.bicycles.db.entity.Bicycle;
import p76.bicycles.db.entity.drivetrain.Chainring;
import p76.bicycles.db.entity.drivetrain.Crank;
import p76.bicycles.db.entity.drivetrain.RearDerailleur;
import p76.bicycles.db.entity.suspension.Fork;
import p76.bicycles.db.repository.BicycleRepository;
import p76.bicycles.db.repository.CrankRepository;
import p76.bicycles.db.repository.CrankRestRepository;

@Data
@Component
public class BicycleService {

    @Autowired
    BicycleRepository repository;

    @Autowired
    CrankRepository crankRepository;

    @Autowired
    BicyclePartsService partsService;


    public List<Bicycle> findBicycle(String name) {
        return repository.findByName(name);
    }

    public Bicycle addBicycle(Bicycle newBicycle) {
        newBicycle.setRearDerailleur(
                partsService.findByProductId(RearDerailleur.class, newBicycle.getRearDerailleurInfo())
        );
        newBicycle.setFork(
                partsService.findByProductId(Fork.class, newBicycle.getForkInfo())
        );
        newBicycle.setCrank(
                partsService.findByProductId(Crank.class, newBicycle.getCrankInfo())
        );
        return repository.save(newBicycle);
    }

    public Crank addCrank(Crank newCrank) {
        newCrank.setBigGear(
                partsService.findByProductId(Chainring.class, newCrank.getBigGearInfo())
        );
        return crankRepository.save(newCrank);
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


