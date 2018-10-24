package theme3_arrays_and_strings.task14;

import java.io.IOException;

import java.util.List;

import static utils.ConsoleHelper.*;

public class Task14 {
    /*В задаче на поиск максимальной оценки, вывести не саму оценку, а ее номер.*/
    public static void main(String[] args) throws IOException {
        writeToConsoleWithDecorator("Введите целочисленные оценки, разделенные пробелами");
        List<Integer> list = readListOfNumbersFromConsole(Integer.class, true);
        int maxIndex = getMaxIndex(list);

        writeToConsoleWithDecorator(String.format("Порядковый номер (начиная с 1) максимальной оценки - %d",maxIndex));
    }

    private static int getMaxIndex(List<Integer> list) {
        Integer maxInteger = list.get(0);
        for (Integer rate : list) {
            if (rate > maxInteger) {
                maxInteger = rate;
            }
        }
        /*Единица добавляется чтобы выводился не индекс (начиная с 0) а порядковый номер (начиная с 1)*/
        return list.indexOf(maxInteger)+1;
    }
}
