package p76.bicycles.service.compatibility;

import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class DataService {

    public boolean allEqual(int... integers) {
        return Arrays.stream(integers)
                .boxed()
                .collect(Collectors.toSet()).size() == 1;
    }

    boolean allTrue(Boolean... booleans) {
        return Arrays.stream(booleans).allMatch(val -> val);

    }
}
