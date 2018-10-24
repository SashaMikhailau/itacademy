package theme2_flow_control.task6;

import utils.ConsoleHelper;

import java.io.IOException;

import static utils.ConsoleHelper.*;

/*Имеется три числа - день, месяц и год. Вывести в виде трех чисел дату следующего дня.
* Можно было легко решить с помощью Localdate и метода plus() но тут фишка в другом поэтому пошел сложным путем*/
public class Task6 {
    public static void main(String[] args) {
        try {
            writeToConsole("Введите день месяц год в виде чисел (Например 31 1 2018)");
            String[] elements = readStringArrayFromConsole(3);
            int day = Integer.parseInt(elements[0]);
            int month = Integer.parseInt(elements[1]);
            int year = Integer.parseInt(elements[2]);
            MyDate myDate = new MyDate(day, month, year);
            writeToConsole("Введите: \n exit для выхода\n + для добавления одного дня\n out для вывода даты");
            OUTER:while (true) {
                String command = readFromConsole();
                switch (command) {
                    case "exit":
                        break OUTER;
                    case "+":
                        myDate.plusOneDay();
                        break;
                    case "out":
                        writeToConsole(myDate.toString());
                        break;

                    default:
                        break;
                }
            }
            close();
        } catch (IOException e) {
            writeToConsole("Ошибка ввода/вывода");
        } catch (MyDateException e) {
            writeToConsole("Неверный формат ввода даты ");
        }

    }

}
