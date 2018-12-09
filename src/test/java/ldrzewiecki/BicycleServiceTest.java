package ldrzewiecki;

import org.junit.Test;

import static org.junit.Assert.*;

public class BicycleServiceTest {


    @Test
    public void testAddBicycle() {
        BicycleService service = new BicycleService();
        service.addBicycle("a");
        try {
            service.addBicycle("a");
            fail("Should throw exception because i am trying to add the same name two times");
        } catch (Exception e) {
            //OK
        }

        assertEquals(1, service.getNoOfBicycles());
    }

    @Test
    public void addBicycle() throws Exception{


    }

    @Test
    public void addBicyclePart() {
    }

    @Test
    public void saveBicycles() {
    }

    @Test
    public void loadBicycles() {
    }

    @Test
    public void printBicycles() {
    }
}