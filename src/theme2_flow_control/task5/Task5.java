package theme2_flow_control.task5;


import java.io.IOException;

import static utils.ConsoleHelper.*;

public class Task5 {
    /*Имеется целое число (любое), это число - сумма денег в рублях.
    Вывести это число, добавив к нему слово "рублей" в правильном падеже*/
    public static void main(String[] args) throws IOException {
        writeToConsoleWithDecorator("Введите сумму для добавления к нему слова \"рубль\" в правильном падеже");
        Long number = readLongFromConsole(true);
        writeToConsoleWithDecorator(generateRuble(number));
        close();
    }

    /*Непосредственно метод для генерирования слово рубль в нужном адеже в зависимости от суммы*/
    private static String generateRuble(long number) {
        StringBuilder sb = new StringBuilder();
        sb.append(number).append(" рубл");
       if(!(number>4 && number <21) && number%10==1){
           sb.append("ь");
       } else if (!(number > 4 && number < 21) && number % 10 > 1 && number % 10 < 5) {
           sb.append("я");
       } else {
           sb.append("ей");
       }
        return sb.toString();
    }

}
