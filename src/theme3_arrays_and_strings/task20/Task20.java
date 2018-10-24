package theme3_arrays_and_strings.task20;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;


import static utils.ConsoleHelper.readFromConsole;
import static utils.ConsoleHelper.writeToConsoleWithDecorator;

public class Task20 {
    /*Имеется строка с текстом. Вывести текст, составленный из последних  букв всех слов.*/
    public static void main(String[] args) throws IOException {
        writeToConsoleWithDecorator("Введите строку");
        String line = readFromConsole().trim();
        //Проводится проверка на пустоту строки
        if (line.isEmpty()) {
            writeToConsoleWithDecorator("Введенная строка пуста");
        } else {
            writeToConsoleWithDecorator(String.format("Полученное слово из последних букв строки - %s",getHybridFromLastLetters(line)));
        }
    }
    /*Метод составляющий строку из переданной строки*/
    public static String getHybridFromLastLetters(String line) {
        String[] elements = line.trim().split("[\\s\\p{Punct}]+");
        StringBuilder sb = new StringBuilder();
        for (String s : elements) {
                sb.append(s.charAt(s.length() - 1));
        }
        return sb.toString();
    }
}
