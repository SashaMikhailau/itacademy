package theme3_arrays_and_strings.task18;

import java.io.IOException;

import static utils.ConsoleHelper.readFromConsole;
import static utils.ConsoleHelper.writeToConsoleWithDecorator;

public class Task18 {
    public static void main(String[] args) throws IOException {
        writeToConsoleWithDecorator("Введите строку для подсчета знаков или 'exit' для выхода");
        String line = readFromConsole();
        writeToConsoleWithDecorator(String.format("В введенной строке %d знаков пунктуации",countPunct(line)));
    }
    //Выяснил что если не привожу явно к чар, то чар неявно расширяется к инт и строка преобразует все символы в числовой их код
    //Также почему то line.chars() работает а Stream.of(line.toCharArray()) не считает нормально символы
    private static long countPunct(String line) {
        return  line.chars().filter(ch -> String.valueOf((char)ch).matches("\\p{Punct}")).count();
    }
}
