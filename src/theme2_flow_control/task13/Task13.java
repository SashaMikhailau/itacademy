package theme2_flow_control.task13;

import java.io.IOException;

import static utils.ConsoleHelper.*;


public class Task13 {
    /*
    * Решить задание на поиск простых чисел с использованием break*/
    public static void main(String[] args) throws IOException {
        writeToConsoleWithDecorator("Введите число, чтобы определеить является ли оно простым");
        int number = readIntegerFromConsole(false);
        String result = isSimpleWithBreak(number) ? "" : " НЕ";
        writeToConsoleWithDecorator(String.format("Число %d%s является простым",number,result));

    }
    /*Эта задача отличается от задачи 11 использованием break  как указано в условии*/
    private static boolean isSimpleWithBreak(int number) {
        int absNumber = Math.abs(number);
        boolean result = true;
        if (absNumber < 2) {
            result = false;
        } else {
            for (int i = 2; i < absNumber; i++) {
                if (absNumber % i == 0) {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }
}
