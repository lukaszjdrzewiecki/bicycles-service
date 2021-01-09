package workshop.service;

import lombok.experimental.UtilityClass;
import org.springframework.util.StringUtils;
import workshop.db.entity.Frame;
import workshop.db.entity.Fork;
import workshop.enums.PartSpec;
import workshop.enums.PartType;

import java.util.Map;

@UtilityClass
public class PartNamingUtils {

    private static final String DASH = "-";

    static final Map<Object, PartSpec> PART_SPECIALIZATIONS = Map.ofEntries(
            Map.entry(PartType.FRAME, new PartSpec<>(PartType.FRAME, "frame", "FRM", Frame.class)),
            Map.entry(PartType.FORK, new PartSpec<>(PartType.FORK, "fork", "FRK", Fork.class))
    );


    static String createProductId(PartType type, String brand, String model, String series, String wheelSize, String other1, String other2) {
        String prefix = PART_SPECIALIZATIONS.get(type).getPrefix();
        StringBuilder builder = new StringBuilder();

        builder.append(prefix);
        builder.append(DASH);

        builder.append(trimToProperLenght(brand, 5));
        builder.append(DASH);

        builder.append(trimToProperLenght(model, 5));
        builder.append(DASH);

        builder.append(trimToProperLenght(series, 5));
        builder.append(DASH);

        builder.append(trimToProperLenght(wheelSize, 2));
        builder.append(DASH);

        builder.append(other1);
        builder.append(DASH);

        builder.append(other2);
        return builder.toString().toUpperCase();
    }

    private String trimToProperLenght(String str, int length) {
        String trimmed = str.length() > length ? str.substring(0, length) : str;
        String removedDots = trimmed.replace(".0", "").replace(",0", "");
        return StringUtils.trimAllWhitespace(removedDots);
    }
}
