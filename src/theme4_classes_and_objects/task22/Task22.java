package theme4_classes_and_objects.task22;

import utils.ConsoleHelper;

import static utils.ConsoleHelper.*;

public class Task22 {
    /*Создать класс и объекты описывающие промежуток времени. Сам промежуток в классе должен задаваться тремя свойствами: секундами, минутами, часами.
    Сделать методы для получения полного количества секунд в объекте, сравнения двух объектов(метод должен работать аналогично comapreTo в строках)
    Создать два конструктора - получающий общее количество секунд и часы, минуты и секунды по отдельности. Сделать метод для вывода данных.
    ПРочее на ваше усмотрение.

    !!!Из условия задачи непонятно могут ли часы быть больше 24, поэтому я сделал что только часы не имеют верхнего предела.
    Затем при вводе неверных значений минут и секунд можно было сделать переполнение,
    но логичнее выкидывать исключение
     */
    public static void main(String[] args) {
        try {
            Time time = new Time(13, 53, 20);
            writeToConsoleWithDecorator(time.toString());
            Time time2 = new Time(50500);
            writeToConsoleWithDecorator(time2.toString());
            writeToConsole(String.valueOf(time.compareTo(time2)));
        } catch (WrongTImeException e) {
            writeToConsole("Неверный формат даты");
        }



    }
}
