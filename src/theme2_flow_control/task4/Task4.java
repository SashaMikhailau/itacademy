package theme2_flow_control.task4;

import java.io.IOException;
import java.text.DecimalFormat;

import static utils.ConsoleHelper.*;

public class Task4 {
    /*Имеется прямоугольное отверстие размерами a и b.
     Определеить, можно ли его полностью закрыть круглой картонкой радиусом r*/
    public static void main(String[] args) throws IOException {
        writeToConsole("Введите три числа, разделенных пробелами \n" +
                "Сторону А прямоугольника, сторону Б прямоугольника, радиус картонки");
        String[] elements = readStringArrayFromConsole(3);
        try {
            double rectangleSizeA = Double.parseDouble(elements[0]);
            double rectangleSizeB = Double.parseDouble(elements[1]);
            double cardRadius = Double.parseDouble(elements[2]);
            if (rectangleSizeA <= 0 || rectangleSizeB <= 0 || cardRadius <= 0) {
                throw new NumberFormatException();
            }
            DecimalFormat decimalFormat = new DecimalFormat("0.#######");
            String answer = canCardCloseRectangle(rectangleSizeA, rectangleSizeB, cardRadius) ? "МОЖНО" : "НЕЛЬЗЯ";
            writeToConsole(String.format("Круглой картонкой радиусом %s %s закрыть прямоугольной отверстие размерами сторон %s и %s",
                    decimalFormat.format(cardRadius), answer, decimalFormat.format(rectangleSizeA), decimalFormat.format(rectangleSizeB)));
        } catch (NumberFormatException e) {
            writeToConsole("Введены неверные параметры. Перезапустите программу");
        }
        close();
    }

    /*Непосредственно метод определения можно ли круглой картонкой картонкой закрыть прямоугольное отверстие.
     * Считается что можно закрыть если диаметр картонки больше диагонали прямоугольника */
    private static boolean canCardCloseRectangle(double rectangleSizeA, double rectangleSizeB, double cardRadius) {
        double diagonalOfRectangle = Math.sqrt(Math.pow(rectangleSizeA,2)+Math.pow(rectangleSizeB,2));
        return cardRadius*2>=diagonalOfRectangle;

    }

}
