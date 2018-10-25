package theme3_arrays_and_strings.task14;

import java.io.IOException;

import static utils.ConsoleHelper.*;

public class Task14 {
    /*В задаче на поиск максимальной оценки, вывести не саму оценку, а ее номер.*/
    public static void main(String[] args) throws IOException {
        writeToConsoleWithDecorator("Введите целочисленные оценки, разделенные пробелами");
        Integer[] numbers = readListOfNumbersFromConsole(Integer.class, true).toArray(new Integer[1]);
        int maxIndex = getMaxIndex(numbers);
        writeToConsoleWithDecorator(String.format("Порядковый номер (начиная с 1) максимальной оценки - %d",maxIndex));
    }

    private static int getMaxIndex(Integer[] numbers) {
        int maxIndex = 0;
        for (int i =1; i < numbers.length;i++) {
            if (numbers[i]>numbers[maxIndex]) {
                maxIndex = i;
            }
        }
        /*Единица добавляется чтобы выводился не индекс (начиная с 0) а порядковый номер (начиная с 1)*/
        return maxIndex+1;
    }
}
