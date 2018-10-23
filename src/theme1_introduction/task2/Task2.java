package theme1_introduction.task2;

import static utils.ConsoleHelper.*;
/*
Расчет и вывод суток, недель, часов, минут и секунд в количестве введенных секунд
*/

public class Task2 {
    public static void main(String[] args) {
        writeToConsole("Введите количество секунд для перевода в другие единицы времени");
        long seconds = Math.abs(readLongFromConsole());
        StringBuilder resultingtext = new StringBuilder(String.format("В введенном числе (%d)", seconds));
        int[] dividers = {60, 60, 24, 7};
        long[] results = new long[dividers.length+1];
        String[] timeUnits = {"секунд", "минут", "часов", "суток", "недель"};
        for (int i = 0; i < dividers.length; i++) {
            results[i] = seconds % dividers[i];
            seconds = (seconds - results[i]) / dividers[i];
        }
        results[results.length - 1] = seconds;
        for (int i = results.length - 1; i > 0; i--) {
            resultingtext.append(String.format(" %d %s,", results[i], timeUnits[i]));
        }
        resultingtext.append(String.format(" %d %s", results[0], timeUnits[0]));
        writeToConsoleWithDecorator(resultingtext.toString());

    }

}
