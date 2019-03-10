package p76.bicycles.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import p76.bicycles.dto.*;
import p76.bicycles.repository.BicycleRepository;

@Data
@Component
public class BicycleService {

    @Autowired
    BicycleRepository repository;

    public void addBicycles(List<Bicycle> bicycles) {
        for(Bicycle bicycle : bicycles) {
            addBicycle(bicycle);
        }
    }

    public List<Bicycle> findBicycle(String name) {
        return repository.findByName(name);
    }

    public Bicycle addBicycle(Bicycle newBicycle) {
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


