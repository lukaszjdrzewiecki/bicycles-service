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
                new Rim("Shimano HB900", 20, 25, 28, true, true, 29),
                new Hub("HOPE HB4", 32, 135, true, 15),
                new Tyre("Continental Baron", 22, true, 26)));
        bicycle.setFrame(new Frame(
                "Scott",
                "Sportster 2017",
                2.10,
                40.0,
                48.7,
                68,
                25,
                true,
                false,
                false,
                142,
                9,
                31.8,
                "Mount",
                "Disc",
                true));

        bicycle.setHeadSet(new HeadSet("FSA", "Headset Pro", 0.120, 28.7, 41.2, 49.3, 28.5, 38.2, true, "semi-integrated"));

        bicycle.setFork(new Fork("Reba", "Rock Shox", 1.58, "2017", 100, 50.0, 28.6, 38.1, false, "Air", "Oil/Coil", 100, 15, "Magnesium", "27,5''", "Disc"));

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
