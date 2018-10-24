package theme2_flow_control.task10;

import java.io.IOException;

import static utils.ConsoleHelper.*;

public class Task10 {
    /*Имеется целое число. Следует посчитать сумму цифр данного числа*/
    public static void main(String[] args) throws IOException {
        writeToConsoleWithDecorator("Введите любое число (функционал расширен и до дробного числа)");
        double number = readDoubleFromConsole(false);
        double absNumber =Math.abs(number);
        long sum = 0;
        try {
            //Число делится на часть до и после запятой
            String[] values = String.valueOf(absNumber).split("[,.]");
            long leftPart = Long.parseLong(values[0]);
            sum+=calculateSum(leftPart);
            //Правая часть может включать E и - поэтому они исключаются как незначащие для наших целей
            long rightPart = Long.parseLong(values[1].replaceAll("E-?\\d{1,2}",""));
            sum+=calculateSum(rightPart);
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }

        writeToConsoleWithDecorator(String.format("Сумма цифр введенного числа %s составляет %d",
                formatDouble(number), sum));


    }
    /*Высчитывается сумма цифр отдельно для кадой части*/
    private static long calculateSum(long part) {
        long result = 0;
        while(true){
            result+=part%10;
            if((part/=10) == 0){
                break;
            }
        }
        return result;
    }

}
