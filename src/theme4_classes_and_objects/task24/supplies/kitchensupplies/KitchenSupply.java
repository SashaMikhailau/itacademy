package theme4_classes_and_objects.task24.supplies.kitchensupplies;

import theme4_classes_and_objects.task24.Model;
import theme4_classes_and_objects.task24.supplies.Appliances;

import java.math.BigDecimal;

public abstract class KitchenSupply extends Appliances {
    public KitchenSupply(Model model, String brand, String mark, double width, double height, double length, BigDecimal price) {
        super(model, brand, mark, width, height, length, price);
    }
    /*Техника для кухни*/
}
