package theme4_classes_and_objects.task24.supplies.homesupplies;

import java.math.BigDecimal;

public class CarpetSteamer extends HomeSupply {
    public CarpetSteamer(String brand, String model, double width, double height, double length, BigDecimal price) {
        super(brand, model, width, height, length, price);
    }

    @Override
    protected String makeWork() {
        return "steaming carpet... PsssssH";
    }
}
