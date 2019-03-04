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
        bicycle = new Bicycle("Sportster 2017", "SCOTT");
        bicycle2 = new Bicycle("Tormenda Lady", "ACCENT");
    }

    @Test
    public void addBicycles() {
        List<Bicycle> rowery = new ArrayList<>();
        rowery.add(bicycle);
        rowery.add(bicycle2);
        service.addBicycles(rowery);
        assertEquals(rowery, service.bicycles);
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

    @Test //Creating object and adding to list
    public void addBicycle1() {
        service.addBicycle("Tormenta Lady", "ACCENT");
        assertEquals(service.bicycles.get(0), service.findBicycle("Tormenta Lady"));
    }

    @Test
    public void saveBicycles_loadBicycles() {
        List<Bicycle> rowery = new ArrayList<>();
        rowery.add(bicycle);
        rowery.add(bicycle2);
        service.addBicycle(bicycle);
        service.addBicycle(bicycle2);
        service.saveBicycles("TestBicycles");
        service.loadBicycles("TestBicycles");

        assertEquals(rowery, service.bicycles);
    }

}


