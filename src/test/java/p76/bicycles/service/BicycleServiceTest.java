package p76.bicycles.service;

import org.junit.Before;
import org.junit.Test;
import p76.bicycles.dto.Bicycle;
import p76.bicycles.service.BicycleService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class BicycleServiceTest {

    private BicycleService service;
    private Bicycle bicycle;
    private Bicycle bicycle2;

    @Before
    public void setup() {
        service = new BicycleService();
        bicycle = createBicycle("Sportster 2017", "SCOTT");
        bicycle2 = createBicycle("Tormenda Lady", "ACCENT");
    }

    private Bicycle createBicycle(String name, String manufacturer) {
        Bicycle bicycle = new Bicycle();
        bicycle.setName(name);
        bicycle.setManufacturer(manufacturer);
        return bicycle;
    }

    @Test
    public void addBicycles() {
        List<Bicycle> rowery = new ArrayList<>();
        rowery.add(bicycle);
        rowery.add(bicycle2);
        service.addBicycles(rowery);
        assertEquals(rowery, service.findAllBicycles());
    }

    @Test
    public void findBicycle() {
        service.addBicycle(bicycle);
        assertEquals(service.findBicycle("Sportster 2017"), bicycle);
        assertNull(service.findBicycle(null));
    }

    @Test //Passing object
    public void addBicycle() {
        service.addBicycle(bicycle);
        assertEquals(service.findBicycle("Sportster 2017"), bicycle);
    }

}


