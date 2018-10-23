package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {
    private static BufferedReader reader;

    /*
    * Утилитный метод для чтения строки текста с консоли.
    *  Ошибка ввода вывода пробрасывается выше, т.к. иначе нужно было бы возвращать null при перехвате ошибки*/
    public static String readFromConsole() throws IOException {

        if (reader == null) {
            reader = new BufferedReader(new InputStreamReader(System.in));
        }
        String line =  reader.readLine();
        reader.close();
        return line;


    }

    /*
     * Утилитный метод для чтения массива строк указанной длины на основе текста, введенного с консоли.
     * Если размер массива строк не совпадает с переданным аргументов то цикл ввода повторяется
     *  Ошибка ввода вывода пробрасывается выше, т.к. иначе нужно было бы возвращать null при перехвате ошибки*/
    public static String[] readStringArrayFromConsole(int size) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while(true) {
                try {
                    String line = reader.readLine().trim();
                    String[] words = line.split("\\s+");
                    if (words.length != size) {
                        throw new NumberFormatException();
                    }
                    return words;
                } catch (NumberFormatException e) {
                    writeToConsole("Неверный формат ввода. Повторите ввод");
                }
            }
        }
    }

    /*Утилитный метод для чтения строки и парсинга ее в лонг.
    Если выкидывается исключение NumberFormatException то ввод повторяется.
    Ошибка ввода вывода пробрасывается выше, т.к. иначе нужно было бы возвращать null при перехвате ошибки
    Аргмуент метода отвечает за дополнительную проверку на отрицательность числа*/
    public static Long readLongFromConsole(boolean notNegative) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while(true){
                try {
                    Long number = Long.parseLong(reader.readLine());
                    if(notNegative && number<0){
                        throw new NumberFormatException();
                    }
                    return number;
                } catch (NumberFormatException e) {
                    writeToConsole("Неверный формат ввода. Повторите ввод");
                }
            }

        }
    }
    /*Утилитный метод для чтения строки и парсинга ее в дабл.
       Если выкидывается исключение NumberFormatException то ввод повторяется.
       Ошибка ввода вывода пробрасывается выше, т.к. иначе нужно было бы возвращать null при перехвате ошибки
       Аргмуент метода отвечает за дополнительную проверку на отрицательность числа*/
    public static Double readDoubleFromConsole(boolean notNegative) throws IOException{
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while(true){
                try {
                    Double number = Double.parseDouble(reader.readLine());
                    if(notNegative && number<0){
                        throw new NumberFormatException();
                    }
                    return number;
                } catch (NumberFormatException e) {
                    writeToConsole("Неверный формат ввода. Повторите ввод");
                }
            }

        }
    }

    /*Утилитный метод для вывода строки в консоль*/
    public static void writeToConsole(String message) {
        System.out.println(message);
    }
    /*Утилитный метод для вывода строки в консоль с обрамлением в виде двух строк с =*/
    public static void writeToConsoleWithDecorator(String message) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            sb.append("=");
        }
        writeToConsole(sb.toString());
        writeToConsole(message);
        writeToConsole(sb.toString());
    }

}
