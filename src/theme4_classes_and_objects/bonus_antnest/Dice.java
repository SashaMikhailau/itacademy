package theme4_classes_and_objects.bonus_antnest;

import java.util.Random;

public class Dice {
    //Первый рандом используется для задания случайности во втором рандоме.
    private static Random seedRandom = new Random();
    private static Random random = new Random(seedRandom.nextInt());
    //возвращает случайное значение от 1 до указанного числа
    public static int rollDice(int max){
        int result = random.nextInt(max)+1;
        return result;
    }
}
