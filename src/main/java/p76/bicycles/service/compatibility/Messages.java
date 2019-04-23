package p76.bicycles.service.compatibility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import p76.bicycles.db.entity.Bicycle;
import p76.bicycles.db.entity.Wheels.Wheel;

@Component
class Messages {

    @Autowired
    WheelCompatibilityService wheelCompatibilityService;

    @Autowired
    DrivetrainCompatibilityService drivetrainCompatibilityService;

    protected static final String BICYCLE_CHECK = "[BICYCLE CHECK]";

    protected static final String DRIVETRAIN = "DRIVETRAIN";
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

    String printMessage(Boolean compatible) {
        try {
            if (compatible) {
                return COMPATIBLE_ALL;
            }
            return COMPATIBLE_NOT;
        } catch (Exception e) {
            return null;
        }
    }

    String printMessage(Boolean compatible, String errorMessage) {
        try {
            if (compatible) {

                return COMPATIBLE_ALL;
            }
            return COMPATIBLE_NOT + errorMessage;
        } catch (Exception e) {
            return null;
        }
    }

    //------------- WHEEL MESSAGES ---------------------

    static final String wheelHolesMessage(Wheel wheel) {
        try {
            return ": number of holes in your rim equals " + wheel.getRim().getHoles() +
                    " and number of holes in your hub equals " + wheel.getHub().getHoles();
        } catch (Exception e) {
            return null;
        }
    }

    static final String wheelDiameterMessage(Wheel wheel) {
        try {
            return ": your rim diameter equals " + wheel.getRim().getDiameter() +
                    " and your tyre diameter equals " + wheel.getTyre().getDiameter();
        } catch (Exception e) {
            return null;
        }
    }

    final String rimTyreMessage(Wheel wheel) {
        try {
            return ": your rim width equals " + wheel.getRim().getInnerWidth() +
                    " mm and thus recommended size of a tyre is " +
                    wheelCompatibilityService.tyreRimRange(wheel).get(0) + " - " +
                    wheelCompatibilityService.tyreRimRange(wheel).get(1) + " mm";
        } catch (Exception e) {
            return null;
        }
    }

    //------------- WHEEL MESSAGES ---------------------

    //------------- FRAME MESSAGES ---------------------

    static public String rearHubWidthMessage(Bicycle bicycle) {
        try {
            return ": hub width " + bicycle.getRearWheel().getHub().getWidth() +
                    " frame space " + bicycle.getFrame().getRearWheelWidth();
        } catch (Exception e) {
            return null;
        }
    }

    static final String forkHeadSetCheckMessage(Bicycle bicycle) {
        try {
            return ": headset inner top " + bicycle.getHeadSet().getTopHeadTubeDiameter() + " fork top " + bicycle.getFork().getHeadTubeTopDiameter() + " | " +
                    " headset inner bottom " + bicycle.getHeadSet().getBottomHeadTubeDiameter() + " fork bottom " + bicycle.getFork().getHeadTubeBottomDiameter();
        } catch (Exception e) {
            return null;
        }
    }

    static public String frameHeadSetMessage(Bicycle bicycle) {
        try {
            return ": frame top " + bicycle.getFrame().getTopHeadSetDiameter() + " headset outer top " + bicycle.getHeadSet().getTopFrameDiameter() + " | " +
                    "frame bottom " + (bicycle.getFrame().getBottomHeadSetDiameter() + " headset outer bottom " + bicycle.getHeadSet().getBottomFrameDiameter());
        } catch (Exception e) {
            return null;
        }
    }

    static public String totalHeadSetMessage(Bicycle bicycle) {
        try {
            return ": must meet the requirements of every other headset test";
        } catch (Exception e) {
            return null;
        }
    }

    static public String forkTaperMessage(Bicycle bicycle) {
        try {
            return ": frame tapered " + bicycle.getFrame().getTapered() + " | fork tapered " + bicycle.getFork().getTapered();
        } catch (Exception e) {
            return null;
        }
    }

    //------------- FRAME MESSAGES -------------------

    //------------- DRIVETRAIN MESSAGES ----------------

    final public String maxCassetteMessage(Bicycle bicycle) {
        try {
            return " Biggest possible gear in your cassette is " + ((bicycle.getRearDerailleur().getCapacity() - drivetrainCompatibilityService.drivetrainCapacity(bicycle) + bicycle.getCassette().getMaximum()));
        } catch (Exception e) {
            return null;
        }
    }

    final public String drivetrainCapacityMessage(Bicycle bicycle) {
        try {
            return " Rear derailleur capacity: " + ((bicycle.getRearDerailleur().getCapacity() +
                    " | Drivetrain requires: " + drivetrainCompatibilityService.drivetrainCapacity(bicycle)));
        } catch (Exception e) {
            return null;
        }
    }

    static final public String speedsMessage(Bicycle bicycle) {
        try {
            return " Cassette speeds: " + bicycle.getCassette().getSpeeds() +
                    " | Rear Derailleur speeds: " + bicycle.getRearDerailleur().getSpeeds() +
                    " | Crank Speeds " + bicycle.getCrank().getSpeed() +
                    " | Front Derailleur speeds " + bicycle.getFrontDerailleur().getSpeeds();
        } catch (Exception e) {
            return null;
        }
    }

    //------------- DRIVETRAIN MESSAGES ----------------


}
