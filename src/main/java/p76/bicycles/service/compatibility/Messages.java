package p76.bicycles.service.compatibility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import p76.bicycles.db.entity.Bicycle;

@Component
class Messages {

    @Autowired
    CompatibilityWheelService compatibilityWheelService;

    @Autowired
    CompatibilityDrivetrainService compatibilityDrivetrainService;

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

    //------------- FRONT WHEEL MESSAGES ---------------------

    static final String wheelHolesMessageFront(Bicycle bicycle) {
        try {
            return ": number of holes in your rim equals " + bicycle.getRimFront().getHoles() +
                    " and number of holes in your hub equals " + bicycle.getHubFront().getHoles();
        } catch (Exception e) {
            return null;
        }
    }

    static final String wheelDiameterMessageFront(Bicycle bicycle) {
        try {
            return ": your rim diameter equals " + bicycle.getRimFront().getDiameter() +
                    " and your tyre diameter equals " + bicycle.getTyreFront().getDiameter();
        } catch (Exception e) {
            return null;
        }
    }

    final String rimTyreMessageFront(Bicycle bicycle) {
        try {
            return ": your rim width equals " + bicycle.getRimFront().getInnerWidth() +
                    " mm and thus recommended size of a tyre is " +
                    compatibilityWheelService.tyreRimRangeFront(bicycle).get(0) + " - " +
                    compatibilityWheelService.tyreRimRangeFront(bicycle).get(1) + " mm";
        } catch (Exception e) {
            return null;
        }
    }

    //------------- FRONT WHEEL MESSAGES ---------------------

    //-------------- REAR WHEEL MESSAGES ---------------------

    static final String wheelHolesMessageRear(Bicycle bicycle) {
        try {
            return ": number of holes in your rim equals " + bicycle.getRimRear().getHoles() +
                    " and number of holes in your hub equals " + bicycle.getHubRear().getHoles();
        } catch (Exception e) {
            return null;
        }
    }

    static final String wheelDiameterMessageRear(Bicycle bicycle) {
        try {
            return ": your rim diameter equals " + bicycle.getRimRear().getDiameter() +
                    " and your tyre diameter equals " + bicycle.getTyreRear().getDiameter();
        } catch (Exception e) {
            return null;
        }
    }

    final String rimTyreMessageRear(Bicycle bicycle) {
        try {
            return ": your rim width equals " + bicycle.getRimRear().getInnerWidth() +
                    " mm and thus recommended size of a tyre is " +
                    compatibilityWheelService.tyreRimRangeFront(bicycle).get(0) + " - " +
                    compatibilityWheelService.tyreRimRangeFront(bicycle).get(1) + " mm";
        } catch (Exception e) {
            return null;
        }
    }


    // ------------------ REAR WHEEL MESSAGES -------------------------------
    //------------- FRAME MESSAGES ---------------------

    public String rearHubWidthMessage(Bicycle bicycle) {
        try {
            return ": hub width " + bicycle.getHubRear().getAxleDiameter() +
                    " frame space " + bicycle.getFrame().getRearWheelAxleSize();
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
            return ": frame tapered " + bicycle.getFrame().getForkTubeType() + " | fork tapered " + bicycle.getFork().getForkTubeType();
        } catch (Exception e) {
            return null;
        }
    }

    //------------- FRAME MESSAGES -------------------

    //------------- DRIVETRAIN MESSAGES ----------------

    final public String maxCassetteMessage(Bicycle bicycle) {
        try {
            return " Biggest possible gear in your cassette is " + ((bicycle.getRearDerailleur().getCapacity() - compatibilityDrivetrainService.drivetrainCapacity(bicycle) + bicycle.getCassette().getBiggest()));
        } catch (Exception e) {
            return null;
        }
    }

    final public String drivetrainCapacityMessage(Bicycle bicycle) {
        try {
            return " Rear derailleur capacity: " + ((bicycle.getRearDerailleur().getCapacity() +
                    " | drivetrain requires: " + compatibilityDrivetrainService.drivetrainCapacity(bicycle)));
        } catch (Exception e) {
            return null;
        }
    }

    static final public String speedsMessage(Bicycle bicycle) {
        try {
            return " Cassette speeds: " + bicycle.getCassette().getSpeeds() +
                    " | Rear Derailleur speeds: " + bicycle.getRearDerailleur().getSpeeds() +
                    " | Crank Speeds " + bicycle.getCrank().getSpeeds() +
                    " | Front Derailleur speeds " + bicycle.getFrontDerailleur().getSpeeds();
        } catch (Exception e) {
            return null;
        }
    }

    //------------- DRIVETRAIN MESSAGES ----------------


}
