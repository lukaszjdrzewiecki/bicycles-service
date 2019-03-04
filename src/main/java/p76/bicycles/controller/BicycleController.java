package p76.bicycles.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import p76.bicycles.dto.*;
import p76.bicycles.entity.Greeting;
import p76.bicycles.service.BicycleCompatibility;
import p76.bicycles.service.BicycleGenerator;
import p76.bicycles.service.BicycleService;

import java.util.List;

@RestController("/bicycle")
public class BicycleController {

    @GetMapping
    public List<Bicycle> getAllBicycles() {

        BicycleService service = new BicycleService();
        BicycleGenerator random = new BicycleGenerator();
        BicycleCompatibility compatibility = new BicycleCompatibility();


        service.addBicycle("Sportster 2017", "Scott");
        service.addBicycle("Tormenta Lady", "Accent");
        service.addBicycle("Scale Unique", "Scott");
        service.addBicycle("Trans Siberian 2015", "Kross");

        service.findBicycle("Sportster 2017").setCrank(new Crank("Deore", 3, 42, 36, 22, 10));
        service.findBicycle("Sportster 2017").setRearDerailleur(new RearDerailleur("RD-M8000", 10, "Long", 47));
        service.findBicycle("Sportster 2017").setCasette(new Casette("M590", 11, 36, 10));
        service.findBicycle("Sportster 2017").setFrontWheel(new FrontWheel(
                new Rim("Shimano HB900", 20, 25, 32, true, true, 622),
                new Hub("HOPE HB4", 28, 130, true, 15),
                new Tyre("Continental Baron", 27, true, 622)));

        return service.getBicycles();
    }
}
