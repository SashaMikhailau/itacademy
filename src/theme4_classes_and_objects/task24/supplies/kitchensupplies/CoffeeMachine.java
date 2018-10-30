package theme4_classes_and_objects.task24.supplies.kitchensupplies;

import theme4_classes_and_objects.task24.Model;
import theme4_classes_and_objects.task24.supplies.mediasupplies.MediaSupply;

import java.math.BigDecimal;

public class CoffeeMachine extends KitchenSupply{
    private final int maxCoffeeVolume;

    public CoffeeMachine(Model model, String brand, String mark, double width, double height, double length, BigDecimal price, int maxCoffeeVolume) {
        super(model, brand, mark, width, height, length, price);
        this.maxCoffeeVolume = maxCoffeeVolume;
    }

    @Override
    protected String makeWork() {
        return String.format("making flavour espresso of %d ml volume", maxCoffeeVolume);
    }
}
