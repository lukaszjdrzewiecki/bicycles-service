package p76.bicycles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import p76.bicycles.db.entity.*;
import p76.bicycles.service.BicycleService;
import p76.bicycles.service.compatibility.CompatibilityService;

@Component
public class ApplicationListener {

    @Autowired
    BicycleService service;

    @Autowired
    CompatibilityService compatibility;

    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) {
        service.addBicycle("Tormenta Lady", "Accent");
        service.addBicycle("Scale Unique", "Scott");
        service.addBicycle("Trans Siberian 2015", "Kross");

        Bicycle bicycle = createBicycle("Sportster 2017", "Scott");



        bicycle.setCrank(new Crank("Deore", 3, 42, 36, 22, 10));
        bicycle.setRearDerailleur(new RearDerailleur("RD-M8000", 10, "Long", 47));
        bicycle.setCassette(new Cassette("M590", 11, 36, 10));
        bicycle.setFrontWheel(new FrontWheel(
                new Rim("Shimano HB900", 20, 25, 32, true, true, 622),
                new Hub("HOPE HB4", 28, 130, true, 15),
                new Tyre("Continental Baron", 27, true, 622)));

        service.addBicycle(bicycle);

        System.out.println(service.findAllBicycles());

        System.out.println(compatibility.bicycleCheck(bicycle));
    }

    private Bicycle createBicycle(String name, String manufacturer) {
        Bicycle bicycle = new Bicycle();
        bicycle.setName(name);
        bicycle.setManufacturer(manufacturer);
        return bicycle;
    }
}
