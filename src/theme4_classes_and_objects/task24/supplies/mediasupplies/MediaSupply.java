package theme4_classes_and_objects.task24.supplies.mediasupplies;

import theme4_classes_and_objects.task24.Model;
import theme4_classes_and_objects.task24.supplies.Appliances;

import java.math.BigDecimal;

public abstract class MediaSupply extends Appliances {
    /*Мультимедийная техника*/

    public MediaSupply(Model model, String brand, String mark, double width, double height, double length, BigDecimal price) {
        super(model, brand, mark, width, height, length, price);
    }
}
