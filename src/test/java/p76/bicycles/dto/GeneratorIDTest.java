package p76.bicycles.dto;

import org.junit.Test;
import p76.bicycles.service.BicycleService;

import static org.junit.Assert.*;

public class GeneratorIDTest {

    @Test
    public void generateNewId() {
        BicycleService service = new BicycleService();
        Bicycle bicycle = new Bicycle("Sportster 2017", "SCOTT");
        Bicycle bicycle2 = new Bicycle("Tormenda Lady", "ACCENT");
        service.addBicycle(bicycle);
        service.addBicycle(bicycle2);
        GeneratorID generatorID = new GeneratorID(service.bicycles);
        assertEquals(1, bicycle.getId());
        assertEquals(2, bicycle2.getId());

    }
}