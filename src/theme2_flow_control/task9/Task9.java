package theme2_flow_control.task9;

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

import static utils.ConsoleHelper.*;

public class Task9 {
    /*Как в прмиере, имеется последовательность случайных чисел, найти и вывести наибольшее из них*/
    public static void main(String[] args) throws IOException {
        writeToConsoleWithDecorator("Введите количество чисел (больше 0), которые хотите сгенерировать случайным образом");
        try {
            int num = readIntegerFromConsole(true);
            if(num==0) throw new NumberFormatException();
            Random random = new Random();
            int[] numbers = new int[num];
            for(int i = 0; i<numbers.length;i++){
                numbers[i] = random.nextInt();
            }
            int max = numbers[0];
            for (int i : numbers) {
                if(i>max)max = i;
            }
            writeToConsoleWithDecorator(String.format("Было сгенерировано множество %s.%nНаибольшее число из сгенерированного множества это %d",
                    Arrays.toString(numbers),max));

        } catch (NumberFormatException e) {
            writeToConsole("Введен 0");
        }

    }
}
