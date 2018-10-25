package theme3_arrays_and_strings.task17;

import java.io.IOException;

import static utils.ConsoleHelper.*;

public class Task17 {
    /*Создать двухмерный массив и заполнить его бабочкой, т.е.
     * 11111
     * 01110
     * 00100
     * 01110
     * 11111*/
    public static void main(String[] args) throws IOException {
        /*Ограничение в 33 просто для красоты, чтобы бабочка не была слишком большой*/
        writeToConsoleWithDecorator("Введите размер бабочки (нечетное целое число от 5 до 33");
        int size = readIntegerFromConsole(true);
        if (size < 3 || size > 33) {
            writeToConsole("Неверный размер бабочки");
            main(args);
        } else {
            /*формирование бабочки. Заполняются сразу четыре четверти бабочки в проходке до середины*/
            int[][] butterfly = new int[size][size];
            for (int i = 0; i < size / 2 +1 ; i++) {
                for (int z = i; z < size / 2 +1; z++) {
                    butterfly[i][z] = 1;
                    butterfly[size - i - 1][z] = 1;
                    butterfly[i][size - z -1] = 1;
                    butterfly[size- i - 1][size - z - 1] = 1;
                }
            }
            /*Вывод бабочки на экран*/
            for (int[] line : butterfly) {
                for (int i : line) {
                    writeToConsoleInOneLine(i+" ");
                }
                writeToConsole("");
            }
        }
    }
}
