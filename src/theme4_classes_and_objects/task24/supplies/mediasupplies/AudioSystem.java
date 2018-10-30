package theme4_classes_and_objects.task24.supplies.mediasupplies;

import theme4_classes_and_objects.task24.Model;

import java.math.BigDecimal;

public class AudioSystem extends MediaSupply{
    private final double maxDecibells;

    public AudioSystem(Model model, String brand, String mark, double width, double height, double length, BigDecimal price, double decibells) {
        super(model, brand, mark, width, height, length, price);
        this.maxDecibells= decibells;
    }

    @Override
    protected String makeWork() {
        return String.format("sounding Led Zeppelin on %f decibells", maxDecibells);
    }
}
