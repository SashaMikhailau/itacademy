package theme4_classes_and_objects.task24.supplies.homesupplies;

import theme4_classes_and_objects.task24.Model;
import theme4_classes_and_objects.task24.supplies.Appliances;

import java.math.BigDecimal;

public class Iron extends Appliances {
    /*Утюг*/
    private final int maxTemperature;
    public Iron(Model model, String brand, String mark, double width, double height, double length, BigDecimal price, int maxTemperature) {
        super(model, brand, mark, width, height, length, price);
        this.maxTemperature = maxTemperature;
    }

    @Override
    protected String makeWork() {
        return String.format("ironing clothes with temperature %d", maxTemperature);
    }


}
