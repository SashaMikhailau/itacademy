package theme2_flow_control.task7;

import static utils.ConsoleHelper.*;

public class FormattableRegion {
    private double x;
    private double y;

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
        return String.format("%s x %s", formatDouble(x),formatDouble(y));
    }
}
