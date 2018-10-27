package theme4_classes_and_objects.task24.supplies.kitchensupplies;

import theme4_classes_and_objects.task24.supplies.Appliances;

import java.math.BigDecimal;

public abstract class KitchenSupply extends Appliances {
    public KitchenSupply(String brand, String model, double width, double height, double length, BigDecimal price) {
        super(brand, model, width, height, length, price);
    }

    /*Техника для кухни*/
}
