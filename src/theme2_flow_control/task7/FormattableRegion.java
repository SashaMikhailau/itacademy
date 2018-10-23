package theme2_flow_control.task7;

import java.text.DecimalFormat;

public class FormattableRegion {
    protected double x;
    protected double y;

    public FormattableRegion(double x, double y) {
        if (x <= 0 || y <= 0) {
            throw new NumberFormatException();
        }
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
    /*Переопределяем для вывод размеров в форматируемом видк*/
    @Override
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("0.#######");
        return String.format("%s x %s",decimalFormat.format(x),decimalFormat.format(y));
    }
}
