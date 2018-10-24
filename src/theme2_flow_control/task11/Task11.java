package theme2_flow_control.task11;

import java.io.IOException;

import static utils.ConsoleHelper.*;

public class Task11 {
    /*Имеется целое число, определить является ли это число простым, т.е. делится без остатка только на 1 и себя
    * */
    public static void main(String[] args) throws IOException {
        writeToConsoleWithDecorator("Введите число, чтобы определеить является ли оно простым");
        int number = readIntegerFromConsole(false);
        String result = isSimple(number) ? "" : " НЕ";
        writeToConsoleWithDecorator(String.format("Число %d%s является простым",number,result));
    }
    /*Методя для опредления являются ли числа простыми
    * */
    private static boolean isSimple(int number) {
        int absNumber = Math.abs(number);
        if(absNumber<2) return false;
        for (int i = 2; i < absNumber; i++) {
            if (absNumber % i == 0) {
                return false;
            }
        }
        return true;
    }
}
