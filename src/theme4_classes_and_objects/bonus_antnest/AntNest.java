package theme4_classes_and_objects.bonus_antnest;

import theme4_classes_and_objects.bonus_antnest.ants.Ant;
import theme4_classes_and_objects.bonus_antnest.ants.AntEgg;
import theme4_classes_and_objects.bonus_antnest.ants.AntLarvae;
import theme4_classes_and_objects.bonus_antnest.ants.AntQueen;

import java.util.ArrayList;
import java.util.List;


public class AntNest {
    private int turnCount;
    private List<Ant> antList = new ArrayList<>();
    //Первичное заселение муравейника муравьями
    public void initNest() {
        antList.add(new AntQueen());
        antList.add(new AntEgg());
        antList.add(new AntEgg());
        antList.add(new AntEgg());
        antList.add(new AntLarvae());
        antList.add(new AntLarvae());
        antList.add(new AntLarvae());
    }
    //Метод для проверки наличия муравьев в муравейнике и выводе сообщения о ходе
    public boolean checkNest() {
        if (antList.isEmpty()) {
            System.out.println(String.format("Муравейник ВЫМЕР на %d-й ход",turnCount));
            return false;
        } else {

            System.out.println(String.format("Муравейник живет уже %d-й ход",++turnCount));
            return true;
        }
    }
    //В ходе жизни муравьи, которые могут производить какое либо результативное действие производят его
    //Королевы откладывают яйца
    //Яйца превращаются в личинки
    //Личинки превращаются случайным образом в королев, солдат и рабочих
    public void lifeTurn() {
        List<Ant> tempList = new ArrayList<>(antList);
        for (Ant ant : antList) {
            switch (ant.getType()) {
                case ANT_QUEEN:
                   tempList.add(ant.doAction());
                    break;
                case ANT_EGG:
                case ANT_LARVAE:
                    tempList.add(ant.doAction());
                    tempList.remove(ant);
                    break;
            }
        }
        antList = tempList;
        printList(antList,"В КОНЦЕ ХОДА ЖИЗНИ в муравейнике %d яиц, %d личинок, %d рабочих, %d солдат и %d королев");
    }
    //Метод для вывода информации о количестве муравьев разных типов в переданном списке
    private void printList(List<Ant> list,String formatString) {
        int eggCount = 0;
        int larvaeCount = 0;
        int workerCount = 0;
        int soldierCount = 0;
        int queenCount = 0;
        for (Ant ant : list) {
            switch (ant.getType()) {
                case ANT_EGG:
                    eggCount++;
                    break;
                case ANT_LARVAE:
                    larvaeCount++;
                    break;
                case ANT_WORKER:
                    workerCount++;
                    break;
                case ANT_SOLDIER:
                    soldierCount++;
                    break;
                case ANT_QUEEN:
                    queenCount++;
                    break;
            }
        }
        System.out.println(String.format(formatString,
                eggCount,larvaeCount,workerCount,soldierCount,queenCount));

    }
    //В ход смерти формируется список в который складываются умершие муравьи для вывода информации
    //Муравьи умирают случайным образом
    //Также создается дубликат общего списка муравьев из которого убираются умершие
    public void deathTurn() {
       List<Ant> deadList = new ArrayList<>();
       List<Ant> tempList = new ArrayList<>(antList);

        for (Ant ant : antList) {
            if (Dice.rollDice(6) ==6) {
                tempList.remove(ant);
                deadList.add(ant);
            }
        }
        antList = tempList;
        printList(deadList,"За ХОД СМЕРТИ в муравейнике ПОГИБЛО %d яиц, %d личинок, %d рабочих, %d солдат и %d королев");

    }
}
