package workshop.config.security.enums;

import java.util.Arrays;

public enum Roles {
    CUSTOMER, ADMIN;

    public static boolean contains(String roleName) {
        return Arrays.stream(Roles.values())
                .map(Enum::name)
                .anyMatch(roleName::equals);
    }
}