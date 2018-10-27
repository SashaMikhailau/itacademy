package theme4_classes_and_objects.task24.supplies.mediasupplies;

import theme4_classes_and_objects.task24.supplies.Appliances;

import java.math.BigDecimal;

public abstract class MediaSupply extends Appliances {
    /*Мультимедийная техника*/

    public MediaSupply(String brand, String model, double width, double height, double length, BigDecimal price) {
        super(brand, model, width, height, length, price);
    }
}
