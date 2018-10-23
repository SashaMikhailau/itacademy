package theme2_flow_control.task6;

public enum Months {
    JANUARY(1,31),FEBRUARY(2,28),VIS_FEBRUARY(2,29),
    MARCH(3,31),APRIL(4,30),MAY(5,31),
    JUNE(6,30),JULY(7,31),AUGUST(8,31),
    SEPTEMBER(9,30),OCTOBER(10,31),NOVEMBER(11,30), DECEMBER(12,31),
    ;
    private final int numberOfDays;
    private final int ordinalNumber;

    Months(int ordinalNumber, int numberOfDays) {
        this.ordinalNumber = ordinalNumber;
        this.numberOfDays = numberOfDays;
    }

    public int getOrdinalNumber() {
        return ordinalNumber;
    };

    public static Months getByOrdinal(int ordinalNumber, boolean visYear) {
        if (ordinalNumber == 3) {
            if(visYear){
                return VIS_FEBRUARY;
            } else {
                return FEBRUARY;
            }
        }
        for (Months month : values()) {
            if (ordinalNumber == month.ordinalNumber) {
                return month;
            }
        }
        return null;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }


}
