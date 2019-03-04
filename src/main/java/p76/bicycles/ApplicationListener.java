package p76.bicycles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import p76.bicycles.dto.*;
import p76.bicycles.service.BicycleService;

@Component
public class ApplicationListener {

    @Autowired
    BicycleService service;

    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) {
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
        System.out.println("HALOHALOHALOHALOHALO                 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!11");
    }
}
