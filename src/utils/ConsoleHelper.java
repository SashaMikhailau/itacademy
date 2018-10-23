package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {
    /*
    * Утилитный метод для чтения строки текста с консоли*/
    public static String readFromConsole() {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            return reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Long readLongFromConsole() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while(true){
                try {
                    return Long.parseLong(reader.readLine());
                } catch (NumberFormatException e) {
                    writeToConsole("Неверный формат ввода. Повторите ввод");
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Double readDoubleFromConsole() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while(true){
                try {
                    return Double.parseDouble(reader.readLine());
                } catch (NumberFormatException e) {
                    writeToConsole("Неверный формат ввода. Повторите ввод");
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
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
