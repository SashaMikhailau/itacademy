package theme2_flow_control.task7;

import utils.ConsoleHelper;

import java.io.IOException;

import static utils.ConsoleHelper.*;

public class Task7 {
    /*Имеется два дома размерами a на b и c на d. Имеется участок размерами e на f. ПРоверить помещаются ли эти дома на данном участке.
    Стороны домов- параллельны сторонам участка, в остальном размещение может быть любым.*/
    public static void main(String[] args) throws IOException {
        writeToConsoleWithDecorator("Введите размеры участка (два вещественных числа разделенных пробелами)");
        String[] sizes = readStringArrayFromConsole(2);
        Part part = new Part(Double.parseDouble(sizes[0]), Double.parseDouble(sizes[1]));
        writeToConsoleWithDecorator("Введите размеры первого дома (два вещественных числа разделенных пробелами)");
        sizes = readStringArrayFromConsole(2);
        House firstHouse = new House(Double.parseDouble(sizes[0]), Double.parseDouble(sizes[1]));
        writeToConsoleWithDecorator("Введите размеры второго дома (два вещественных числа разделенных пробелами)");
        sizes = readStringArrayFromConsole(2);
        House secondHouse = new House(Double.parseDouble(sizes[0]), Double.parseDouble(sizes[1]));
        String result = part.checkHouses(firstHouse, secondHouse)?" ":" НЕ ";
        writeToConsoleWithDecorator(String.format("В участок размерами %s%sпоместятся два дома размерами %s  и %s",
                part.toString(),result,firstHouse.toString(),secondHouse.toString()));

    }
}
