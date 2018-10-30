package theme4_classes_and_objects.task24.supplies.kitchensupplies;

import theme4_classes_and_objects.task24.Model;

import java.math.BigDecimal;

public class Refrigirator extends KitchenSupply {
    private final int maxVolume;

    public Refrigirator(Model model, String brand, String mark, double width, double height, double length, BigDecimal price, int maxVolume) {
        super(model, brand, mark, width, height, length, price);
        this.maxVolume = maxVolume;
    }

    @Override
    protected String makeWork() {
        return String.format("refrigerating products by volume of %d. BRRRRR", maxVolume);
    }
}
