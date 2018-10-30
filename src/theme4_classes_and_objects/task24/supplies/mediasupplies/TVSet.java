package theme4_classes_and_objects.task24.supplies.mediasupplies;

import theme4_classes_and_objects.task24.Model;

import java.math.BigDecimal;

public class TVSet extends MediaSupply {
    private final double diagonal;

    public TVSet(Model model, String brand, String mark, double width, double height, double length, BigDecimal price, double diagonal) {
        super(model, brand, mark, width, height, length, price);
        this.diagonal = diagonal;
    }

    @Override
    protected String makeWork() {
        return String.format("Showing The Game of Thrones on big %f inch monitor", diagonal);
    }
}
