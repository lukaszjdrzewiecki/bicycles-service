package p76.bicycles.enums;

public enum BrakeCaliperType {
    DISC_HYDRAULIC("disc hydraulic"),
    DISC_MECHANIC("disc mechanical"),
    ROAD("road"),
    ROAD_DISC("road disc"),
    ROAD_DISC_MECHANIC("road disc mechanical"),
    V_BRAKE("v-brake");

    private String text;

    BrakeCaliperType(String text) {
        this.text = text;
    }

    public static BrakeCaliperType getBrakeCaliperTypeString (String text) {
        for (BrakeCaliperType brakeCaliperType : BrakeCaliperType.values()) {
            if (brakeCaliperType.text.equalsIgnoreCase(text)) {
                return brakeCaliperType;
            }
        }
        return null;
    }
}
