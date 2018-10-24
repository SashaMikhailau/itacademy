package theme2_flow_control.task12;

import utils.ConsoleHelper;

import java.io.IOException;

import static utils.ConsoleHelper.*;

public class Task12 {
    /*Имеется целое число, следует вывести его в бухгалтерском формате.
    Т.Е, начиная справа каждые три позиции отделяются пробелом.
    Например число 20023143 должно быть выведено как 20 023 143*/
    public static void main(String[] args) throws IOException {
        writeToConsoleWithDecorator("Введите число для вывода его в бухгалтерском формате");
        long number = readLongFromConsole(false);
        String numberIntString = String.valueOf(number);
        /*Долго подбирал регекс. Каждые от 1 до 3 цифр являются шаблоном, при условии наличии впереди (через lookaround от 0 до бесконечности
        * цифр по ТРИ и при отсутствии каких либо цифр после цифр по 3.  */
        String parsedNumber = numberIntString.replaceAll("(\\d{1,3})(?=(\\d{3})*(?!\\d))","$1 ");
        writeToConsoleWithDecorator(String.format("Бухгалтерский вывод: %s",parsedNumber));
    }
}
