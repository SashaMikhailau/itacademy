package theme3_arrays_and_strings.task19;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static utils.ConsoleHelper.*;

public class Task19 {
    /*Имеется строка с текстом. Подсчитать количество слов в тексте.
    Желательно учесть, что слова могут разделяться несколькими пробелами, в начале и конце текста также могут быть пробелы, но могут и отсутствовать */
    public static void main(String[] args) throws IOException {
        writeToConsoleWithDecorator("Введите строку");
        String line = readFromConsole();
        int wordCount = countWordsWithSpaces(line);
        int wordCountExtended= countWordsWithSpacesAndPuncts(line);
        writeToConsoleWithDecorator(String.format("Количество слов только учитывая пробелы в введенной строке (как по условию задачи) - %d",wordCount));
        writeToConsoleWithDecorator(String.format("Количество слов же учитывая и пробелы и знаки препинания - %d",wordCountExtended));
        List<Number> list = new ArrayList<>();

    }

    private static int countWordsWithSpacesAndPuncts(String line) {
        String[] elements = line.trim().split("[\\s\\p{Punct}]+");
        return elements.length;
    }

    private static int countWordsWithSpaces(String line) {
        String[] elements = line.trim().split("\\s+");
        return elements.length;
    }
}
