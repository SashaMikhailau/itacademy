package theme2_flow_control.task7;

public class Part extends FormattableRegion {
    public static final int FIRST_HOUSE = 0;
    public static final int SECOND_HOUSE= 1;

    public Part(double x, double y) {
        super(x, y);
    }

    /*Проверка влезут ли два дома в указанный участок. Возвращает boolean*/
    public boolean checkHouses(House firstHouse, House secondHouse) {
        if (firstHouse==null||secondHouse==null) {
            throw new NumberFormatException();
        }
        return (firstHouse.getX() + secondHouse.getX()) <= getX() || (firstHouse.getY() + secondHouse.getY()) <= getY();
    }
}
