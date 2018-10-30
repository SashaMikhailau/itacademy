package theme4_classes_and_objects.task24.supplies.homesupplies;

import theme4_classes_and_objects.task24.Model;
import theme4_classes_and_objects.task24.supplies.Appliances;

import java.math.BigDecimal;

public abstract class HomeSupply extends Appliances {
    public HomeSupply(Model model, String brand, String mark, double width, double height, double length, BigDecimal price) {
        super(model, brand, mark, width, height, length, price);
    }
    /*Бытовая техника для дома*/
}
