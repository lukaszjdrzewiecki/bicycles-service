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
        bicycle.setRearWheel(new RearWheel(
                new Rim("Shimano HB900", 20, 25, 32, true, true, 622),
                new Hub("HOPE HB4", 32, 135, true, 15),
                new Tyre("Continental Baron", 45, true, 622)));
        bicycle.setFrame(new Frame(
                "Scott",
                "Sportster 2017",
                28.6,
                38.1,
                28.6,
                120,
                68,
                25,
                true,
                false,
                false,
                135,
                9,
                31.8,
                "Mount",
                "Disc"));

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
