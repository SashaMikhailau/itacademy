package theme2_flow_control.task3;

import static utils.ConsoleHelper.*;

import java.io.BufferedReader;
import java.io.IOException;

public class Task3 {
    /*Создайте число. Определеите- является ли последняя цифра числа семеркой.*/
    public static void main(String[] args) throws IOException {
            writeToConsoleWithDecorator("Введите число");
            Long number = readLongFromConsole(false);
            String variative = isLastDigitSeven(number) ? "" : "НЕ";
            writeToConsoleWithDecorator(String.format("Последняя цифра введенного вами числа %d %s является 7", number,variative));
    }
    /*Метод определяющий является ли последняя цифра числа 7 */
    public static boolean isLastDigitSeven(long number) {
        return number%10==7;
    }
}
