package theme3_arrays_and_strings.task15;

import java.io.IOException;

import static utils.ConsoleHelper.*;

public class Task15 {
    /*Определите сумму элементов массива, расположенных между минимальным и максимальным значением*/
    public static void main(String[] args) throws IOException {
        writeToConsoleWithDecorator("Введите целые числа разделенные пробелом");
        Integer[] numbers = readListOfNumbersFromConsole(Integer.class, false).toArray(new Integer[0]);
        int minIndex = 0;
        int maxIndex = 0;
        for (int i = 1; i<numbers.length; i++) {
            if (numbers[i] > numbers[maxIndex]) {
                maxIndex = i;
            } else if (numbers[i] < numbers[minIndex]) {
                minIndex = i;
            }
        }
        String result;
        if (Math.abs(maxIndex - minIndex)==0) {
           result = "Максимальное и минимальное значения равны";
        } else if (Math.abs(maxIndex - minIndex) == 1) {
            result = "Минимальное и максимальное значения смежны (между ними нет элементов)";
        } else {
            int startIndex;
            int endindex;
            int sum = 0;
            if (maxIndex > minIndex) {
                endindex = maxIndex;
                startIndex = minIndex;
            } else {
                endindex = minIndex;
                startIndex = maxIndex;
            }
            for (int i = startIndex+1; i < endindex; i++) {
                sum += numbers[i];
            }
            result = String.format("Сумма элементов между минимальным и максимальным значениями %d",sum);
        }
        writeToConsoleWithDecorator(result);
    }
}
