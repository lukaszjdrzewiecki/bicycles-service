package p76.bicycles.service.compatibility;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class DataService {

    public boolean allEqual(int a, int... integers) {
        for (int i : integers) {
            if (i != a) {
                return false;
            }
        }
        return true;
    }

    boolean allTrue(boolean a, boolean... booleans) {
        for (boolean i : booleans) {
            if (i != a) {
                return false;
            }
        }
        return true;
    }

    Map<Integer, List<Integer>> diameterMap() {
        Map<Integer, List<Integer>> diameters = new HashMap<>();
        diameters.put(13, new ArrayList<>(Arrays.asList(18, 25)));
        diameters.put(15, new ArrayList<>(Arrays.asList(23, 32)));
        diameters.put(17, new ArrayList<>(Arrays.asList(25, 52)));
        diameters.put(19, new ArrayList<>(Arrays.asList(28, 62)));
        diameters.put(21, new ArrayList<>(Arrays.asList(35, 62)));
        diameters.put(23, new ArrayList<>(Arrays.asList(37, 62)));
        diameters.put(25, new ArrayList<>(Arrays.asList(42, 62)));
        diameters.put(29, new ArrayList<>(Arrays.asList(47, 62)));
        diameters.put(30, new ArrayList<>(Arrays.asList(52, 62)));
        diameters.put(35, new ArrayList<>(Arrays.asList(60, 75)));
        diameters.put(40, new ArrayList<>(Arrays.asList(65, 75)));
        diameters.put(45, new ArrayList<>(Arrays.asList(70, 75)));
        return diameters;
    }
}
