package theme4_classes_and_objects.task23;


import java.io.IOException;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

import static utils.ConsoleHelper.*;

public class Task23 {
    /*Создать класс и объекты, описывающие банкомат.
    Набор купюр находящихся в банкомате должен задаваться тремя свойсвами: количеством купюр номиналом 20 50 100.
    Сделать методы для добавленя денег в банкомат.
    Сделать функцию снимающую деньги. На вход пережается сумма денег.
    На выход булевское значение (операция удалась или нет).
     При снятии денег функция должна распечатывать каким количеством купюр какого номинала выдается сумма.
     Создать конструктор с тремя параметрами - количеством купюр.
     Прочее - на ваше усмотрение.*/
    public static void main(String[] args) throws IOException {
        CopyOnWriteArrayList<ATM> atmList = new CopyOnWriteArrayList<>();
        /*создаем банкоматы, они наследуют от нитей и автоматом запускаются при создании*/
        try {
            atmList.add(new ATM(20,40,60));
            atmList.add(new ATM(20,40,60));

        /*Пока в списке банкоматов есть работающие то блок кода выполняется*/
            while (atmList.stream().filter(atm -> atm.isWorking()).count()>0) {
                for (ATM atm : atmList) {
                    /*При добавлении купюр выхода из текущей панели не происходит.
                    * При выключении банкомата либо других клавишах переходит программа к панели следующего банкомата в списке*/
                    OUTER: while (true) {
                    /*Вывод контрольной панели*/
                        atm.printControlpanel();
                        try {
                            Integer integer = readIntegerFromConsole(true);
                            switch (integer) {
                                case 1:
                                    atm.stopATM();
                                    atmList.remove(atm);
                                    break OUTER;
                                case 2:
                                        writeToConsoleWithDecorator("Введите количество купюр по 100, которое вы ходите загрузить в банкомат");
                                        atm.put100(readIntegerFromConsole(true));
                                    break;
                                case 3:
                                        writeToConsoleWithDecorator("Введите количество купюр по 50, которое вы ходите загрузить в банкомат");
                                        atm.put50(readIntegerFromConsole(true));
                                    break;
                                case 4:
                                        writeToConsoleWithDecorator("Введите количество купюр по 20, которое вы ходите загрузить в банкомат");
                                        atm.put20(readIntegerFromConsole(true));

                                    break;
                                    default:
                                       break OUTER;
                            }
                        } catch (NumberFormatException e) {
                            writeToConsole("Неверный формат ввода");
                        }
                    }

                }
                /*Ожидание добавлено чтобы результаты выполнения не вклинивались в выод контрольной панели,
                а также чтобы дать время завершитсья потокам*/
                try {
                    TimeUnit.MILLISECONDS.sleep(400);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            writeToConsoleWithDecorator("Все банкоматы не работают. Программа завершает работу");
        } catch (WrongMoneyCountException e) {
            writeToConsole("Количество купюр не может быть отрицательным");
        }
    }
}
