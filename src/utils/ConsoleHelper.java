package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConsoleHelper {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static void close() throws IOException {
        reader.close();
    }
    /*
    * Утилитный метод для чтения строки текста с консоли.
    *  Ошибка ввода вывода пробрасывается выше, т.к. иначе нужно было бы возвращать null при перехвате ошибки*/
    public static String readFromConsole() throws IOException {
        return reader.readLine();


    }

    /*
     * Утилитный метод для чтения массива строк указанной длины на основе текста, введенного с консоли.
     * Если размер массива строк не совпадает с переданным аргументов то цикл ввода повторяется
     *  Ошибка ввода вывода пробрасывается выше, т.к. иначе нужно было бы возвращать null при перехвате ошибки*/
    public static String[] readStringArrayFromConsole(int size) throws IOException {
            while(true) {
                try {
                    String line = readFromConsole().trim();
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
    /*
     * Написал клевый гибкий метод с участием генериков и рефлекта, который парсит введенную строку в лист необходимых чисел*/
    public static <T extends Number> List<T> readListOfNumbersFromConsole(Class<T> type, boolean notNegative) throws IOException {
        while(true) {
            try {
                String line = readFromConsole().trim();
                String[] words = line.split("\\s+");
                if (words.length == 0) {
                    throw new NumberFormatException();
                }
                List<T> list = new ArrayList<>();
                for (String s : words) {
                    try {
                        T t = (T)type.getMethod("valueOf",String.class).invoke(null,s);
                        list.add(t);
                       if (notNegative &&t.doubleValue()<0) {
                            throw new NumberFormatException();
                        }
                    }
                    catch (ReflectiveOperationException e) {
                        throw new NumberFormatException();
                    }

                }
                return list;
            } catch (NumberFormatException e) {
                writeToConsole("Неверный формат ввода. Повторите ввод");
            }
        }

    }
    /*Утилитный метод для чтения строки и парсинга ее в лонг.
    Если выкидывается исключение NumberFormatException то ввод повторяется.
    Ошибка ввода вывода пробрасывается выше, т.к. иначе нужно было бы возвращать null при перехвате ошибки
    Аргмуент метода отвечает за дополнительную проверку на отрицательность числа*/
    public static Long readLongFromConsole(boolean notNegative) throws IOException {
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

    /*Утилитный метод для чтения строки и парсинга ее в Integer.
Если выкидывается исключение NumberFormatException то ввод повторяется.
Ошибка ввода вывода пробрасывается выше, т.к. иначе нужно было бы возвращать null при перехвате ошибки
Аргмуент метода отвечает за дополнительную проверку на отрицательность числа*/
    public static Integer readIntegerFromConsole(boolean notNegative) throws IOException {
        while(true){
            try {
                Integer number = Integer.parseInt(reader.readLine());
                if(notNegative && number<0){
                    throw new NumberFormatException();
                }
                return number;
            } catch (NumberFormatException e) {
                writeToConsole("Неверный формат ввода. Повторите ввод");
            }
        }
    }
    /*Утилитный метод для чтения строки и парсинга ее в дабл.
       Если выкидывается исключение NumberFormatException то ввод повторяется.
       Ошибка ввода вывода пробрасывается выше, т.к. иначе нужно было бы возвращать null при перехвате ошибки
       Аргмуент метода отвечает за дополнительную проверку на отрицательность числа*/
    public static Double readDoubleFromConsole(boolean notNegative) throws IOException{
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

    public static String formatDouble(double d) {
        DecimalFormat decimalFormat = new DecimalFormat("0.###########################################################################");
        return decimalFormat.format(d);
    }

}
