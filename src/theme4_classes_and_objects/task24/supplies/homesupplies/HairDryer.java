package theme4_classes_and_objects.task24.supplies.homesupplies;

import theme4_classes_and_objects.task24.Model;

import java.math.BigDecimal;

public class HairDryer extends HomeSupply {
    /*Фен*/
    private final int maxFlowSpeed;

    public HairDryer(Model model, String brand, String mark, double width, double height, double length, BigDecimal price, int maxFlowSpeed) {
        super(model, brand, mark, width, height, length, price);
        this.maxFlowSpeed = maxFlowSpeed;
    }

    @Override
    protected String makeWork() {
        return String.format("drying hair with flow speed %d", maxFlowSpeed);
    }
}
