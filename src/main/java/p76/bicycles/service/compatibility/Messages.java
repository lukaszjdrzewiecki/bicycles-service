package p76.bicycles.service.compatibility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import p76.bicycles.db.entity.Bicycle;
import p76.bicycles.db.entity.wheels.FrontWheel;
import p76.bicycles.db.entity.wheels.RearWheel;

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

    static final String wheelHolesMessage(FrontWheel frontWheel) {
        try {
            return ": number of holes in your rim equals " + frontWheel.getRim().getHoles() +
                    " and number of holes in your hub equals " + frontWheel.getFrontHub().getHoles();
        } catch (Exception e) {
            return null;
        }
    }

    static final String wheelDiameterMessage(FrontWheel frontWheel) {
        try {
            return ": your rim diameter equals " + frontWheel.getRim().getDiameter() +
                    " and your tyre diameter equals " + frontWheel.getTyre().getDiameter();
        } catch (Exception e) {
            return null;
        }
    }

    final String rimTyreMessage(FrontWheel frontWheel) {
        try {
            return ": your rim width equals " + frontWheel.getRim().getInnerWidth() +
                    " mm and thus recommended size of a tyre is " +
                    compatibilityWheelService.tyreRimRange(frontWheel).get(0) + " - " +
                    compatibilityWheelService.tyreRimRange(frontWheel).get(1) + " mm";
        } catch (Exception e) {
            return null;
        }
    }

    //------------- FRONT WHEEL MESSAGES ---------------------

    //-------------- REAR WHEEL MESSAGES ---------------------

    static final String wheelHolesMessage(RearWheel rearWheel) {
        try {
            return ": number of holes in your rim equals " + rearWheel.getRim().getHoles() +
                    " and number of holes in your hub equals " + rearWheel.getRearHub().getHoles();
        } catch (Exception e) {
            return null;
        }
    }

    static final String wheelDiameterMessage(RearWheel rearWheel) {
        try {
            return ": your rim diameter equals " + rearWheel.getRim().getDiameter() +
                    " and your tyre diameter equals " + rearWheel.getTyre().getDiameter();
        } catch (Exception e) {
            return null;
        }
    }

    final String rimTyreMessage(RearWheel rearWheel) {
        try {
            return ": your rim width equals " + rearWheel.getRim().getInnerWidth() +
                    " mm and thus recommended size of a tyre is " +
                    compatibilityWheelService.tyreRimRange(rearWheel).get(0) + " - " +
                    compatibilityWheelService.tyreRimRange(rearWheel).get(1) + " mm";
        } catch (Exception e) {
            return null;
        }
    }

    // ------------------ REAR WHEEL MESSAGES -------------------------------
    //------------- FRAME MESSAGES ---------------------

    static public String rearHubWidthMessage(Bicycle bicycle) {
        try {
            return ": hub width " + bicycle.getRearWheel().getRearHub().getWidth() +
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
