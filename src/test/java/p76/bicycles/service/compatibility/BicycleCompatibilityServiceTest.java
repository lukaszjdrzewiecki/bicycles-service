package p76.bicycles.service.compatibility;

import org.junit.Test;

import static org.junit.Assert.*;

public class BicycleCompatibilityServiceTest {
    private DataService dataService = new DataService();

    @Test
    public void allEqual() {
        int a = 10;
        int b = 10;
        int c = 10;
        int d = 11;
        boolean actual = dataService.allEqual(a, b, c);
        assertTrue(actual);
        boolean actual2 = dataService.allEqual(a, b, c, d);
        assertFalse(actual2);
    }
}