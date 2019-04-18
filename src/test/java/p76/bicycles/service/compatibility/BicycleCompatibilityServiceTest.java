package p76.bicycles.service.compatibility;

import org.junit.Test;
import p76.bicycles.service.compatibility.CompatibilityService;

import static org.junit.Assert.*;

public class BicycleCompatibilityServiceTest {
    private Common common = new Common();

    @Test
    public void allEqual() {
        int a = 10;
        int b = 10;
        int c = 10;
        int d = 11;
        boolean actual = common.allEqual(a, b, c);
        assertTrue(actual);
        boolean actual2 = common.allEqual(a, b, c, d);
        assertFalse(actual2);
    }
}