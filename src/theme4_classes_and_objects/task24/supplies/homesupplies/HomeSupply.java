package theme4_classes_and_objects.task24.supplies.homesupplies;

import theme4_classes_and_objects.task24.supplies.Appliances;

import java.math.BigDecimal;

public abstract class HomeSupply extends Appliances {
    public HomeSupply(String brand, String model, double width, double height, double length, BigDecimal price) {
        super(brand, model, width, height, length, price);
    }
    /*Бытовая техника для дома*/
}
