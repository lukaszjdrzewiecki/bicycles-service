package p76.bicycles.service;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;
import p76.bicycles.db.entity.Bicycle;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@Ignore
@RunWith(SpringRunner.class)
public class BicycleServiceTest {

    @Autowired
    private BicycleService service;
    private Bicycle bicycle;
    private Bicycle bicycle2;

    @Before
    public void setup() {
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


