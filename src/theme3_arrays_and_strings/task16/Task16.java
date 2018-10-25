package theme3_arrays_and_strings.task16;


import java.util.Arrays;
import java.util.Random;

import static utils.ConsoleHelper.*;

public class Task16 {
    /*Создать массив, заполнить его случайными элементами, распечатать, перевернуть, и снова распечатать
    (при переворачивании нежелательно создавать еще один массив*/
    public static void main(String[] args) {
        Random random = new Random(456);
       int[] numbers = new int[11];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(100);
        }
        writeToConsoleWithDecorator(Arrays.toString(numbers));
        int size = numbers.length;
        /*Переворот*/
        for (int i = 0; i < size/2; i++) {
            int temp = numbers[i];
            numbers[i] = numbers[size - i - 1];
            numbers[size - i - 1] = temp;
        }
        writeToConsoleWithDecorator(Arrays.toString(numbers));
    }
}
