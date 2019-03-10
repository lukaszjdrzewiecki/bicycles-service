package p76.bicycles.service;

import org.junit.Before;
import org.junit.Test;
import p76.bicycles.dto.Bicycle;

import java.util.List;

import static org.junit.Assert.*;

public class BicycleGeneratorTest {

    private BicycleGenerator random;

    @Before
    public void setup(){
        random = new BicycleGenerator();
    }

    @Test
    public void generateRandomBicycles() {
        List<Bicycle> randomBikes = random.generateRandomBicycles(3);
        assertNotNull(randomBikes.get(0));
        assertNotNull(randomBikes.get(1));
        assertNotNull(randomBikes.get(2));
    }

    @Test
    public void getRandomManufacturer() {
        String actual = random.getRandomManufacturer();
        String expected = "Scott, Kross, Orbea, Cube, Fuji";
        boolean check = expected.contains(actual);
        assertTrue(check);
    }

    @Test
    public void getRandomPartSeries() {
        String actual = random.getRandomPartSeries();
        String expected = "Altus, Alivio, Deore, XT, XTR";
        boolean check = expected.contains(actual);
        assertTrue(check);
    }
}