package p76.bicycles.service;

import org.junit.Test;

import static org.junit.Assert.*;

public class BicycleCompatibilityServiceTest {
    private CompatibilityService compatibility = new CompatibilityService();

    @Test
    public void allEqual() {
        int a = 10;
        int b = 10;
        int c = 10;
        int d = 11;
        boolean actual = compatibility.allEqual(a, b, c);
        assertTrue(actual);
        boolean actual2 = compatibility.allEqual(a, b, c, d);
        assertFalse(actual2);
    }
}