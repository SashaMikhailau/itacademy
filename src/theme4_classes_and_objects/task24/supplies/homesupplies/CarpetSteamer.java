package theme4_classes_and_objects.task24.supplies.homesupplies;

import theme4_classes_and_objects.task24.Model;

import java.math.BigDecimal;

public class CarpetSteamer extends HomeSupply {
    private final int maxSteamTemperature;

    public CarpetSteamer(Model model, String brand, String mark, double width, double height, double length, BigDecimal price, int maxStreamTemperature) {
        super(model, brand, mark, width, height, length, price);
        this.maxSteamTemperature = maxStreamTemperature;
    }

    @Override
    protected String makeWork() {

        return String.format("steaming carpet with temperature %d", maxSteamTemperature);
    }
}
