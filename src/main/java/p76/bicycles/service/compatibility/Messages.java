package p76.bicycles.service.compatibility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import p76.bicycles.db.entity.Wheel;

@Component
class Messages {

    @Autowired
    WheelCompatibilityService wheelCompatibilityService;

    protected static final String BICYCLE_CHECK = "[BICYCLE CHECK]";

    protected static final String DRIVETRAIN_CHECK = "[DRIVETRAIN CHECK";
    protected static final String DRIVETRAIN_EXPLANATION = " : Biggest possible gear of the cassette in this bicycle is ";

    protected static final String CHANGING_COMPONENT = "[CHANGING COMPONENT]";

    protected static final String NUMBER_SPEEDS_CHECK = "[NUMBER OF SPEEDS CHECK]";
    protected static final String DIAMETER = "[DIAMETER]";
    protected static final String NUMBER_OF_HOLES = "[NUMBER_OF_HOLES]";
    protected static final String RIM_TYRE_CHECK = "[RIM & TYRE WIDTH CHECK]";

    protected static final String COMPATIBLE_NOT = "NOT COMPATIBLE";
    protected static final String COMPATIBLE_ALL = "ALL COMPATIBLE";
    protected static final String NON_SPECIFIED = "Parts not specified";

    protected static final String CHECK = " CHECK";
    protected static final String WHEEL = " WHEEL";
    protected static final String FRONT_WHEEL = " FRONT" + WHEEL;
    protected static final String REAR_WHEEL = " REAR" + WHEEL;
    protected static final String FRAME = " FRAME";

    String compatibilityRimTyreMessage(Boolean compatible, Wheel wheel) {
        try {
            int min = wheelCompatibilityService.tyreRimRange(wheel).get(0);
            int max = wheelCompatibilityService.tyreRimRange(wheel).get(1);
            if (compatible) {
                return COMPATIBLE_ALL;
            }
            return COMPATIBLE_NOT +
                    ": your rim width equals " + wheel.getRim().getInnerWidth() +
                    " mm and thus recommended size of a tyre is " + min + " - " + max + " mm";
        } catch (Exception e) {
            return null;
        }
    }

    String compatibilityDiameterMessage(Boolean compatible, Wheel wheel) {
        try {
            if (compatible) {
                return COMPATIBLE_ALL;
            }
            return COMPATIBLE_NOT +
                    ": your rim diameter equals " + wheel.getRim().getDiameter() +
                    " and your tyre diameter equals " + wheel.getTyre().getDiameter();
        } catch (Exception e) {
            return null;
        }
    }

    String compatibilityHolesMessage(Boolean compatible, Wheel wheel) {
        try {
            if (compatible) {
                return COMPATIBLE_ALL;
            }
            return COMPATIBLE_NOT +
                    ": number of holes in your rim equals " + wheel.getRim().getHoles() +
                    " and number of holes in your hub equals " + wheel.getHub().getHoles();
        } catch (Exception e) {
            return null;
        }
    }

    String compatibilityMessage(Boolean compatible) {
        try {
            if (compatible) {
                return COMPATIBLE_ALL;
            }
            return COMPATIBLE_NOT;
        } catch (Exception e) {
            return null;
        }
    }


}
