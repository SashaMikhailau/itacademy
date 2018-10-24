package theme2_flow_control.task8;

import java.io.IOException;
import java.math.BigInteger;

import static utils.ConsoleHelper.*;

public class Task8 {
    /*Изменить пример с суммой чисел таким образом, чтобы рассчитывалась не сумма, а произведение, т.е. факториал числа*/
    public static void main(String[] args) throws IOException {
        writeToConsoleWithDecorator("Введите целое положительное число для вычисления его факториала");
        int number =readIntegerFromConsole(true);
        writeToConsoleWithDecorator(String.format("Факториал числа %d составляет %s", number, getFactorial(number)));
    }
    /*Метод для высчитывания факториала*/
    private static String getFactorial(int number) {
        BigInteger factorial = BigInteger.valueOf(1);
        for(int i=1;i<=Math.abs(number);i++){
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }
        return factorial.toString();
    }
}
