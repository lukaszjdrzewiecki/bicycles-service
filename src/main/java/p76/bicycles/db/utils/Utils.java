package p76.bicycles.db.utils;

import org.springframework.stereotype.Component;

@Component
public class Utils {

    private static final String COMPATIBLE_NOT = "NOT COMPATIBLE";
    private static final String COMPATIBLE_ALL = "ALL COMPATIBLE";

    public String printMessage(Boolean compatible, String errorMessage) {
        return compatible ? COMPATIBLE_ALL
                : COMPATIBLE_NOT + errorMessage;
    }
}
