package theme4_classes_and_objects.bonus_antnest.ants;

import theme4_classes_and_objects.bonus_antnest.Dice;

public class AntLarvae extends Ant {
    @Override
    public AntType getType() {
        return AntType.ANT_LARVAE;
    }
    @Override
    public Ant doAction() {
        int diceResult = Dice.rollDice(6);
        switch (diceResult) {
            case 4:
            case 5:
                System.out.println("Личинка превратилась в солдата");
                return new AntSoldier();
            case 6:
                System.out.println("Личинка выросла в королеву");
                return new AntQueen();
            default:
                System.out.println("Личинка превратилась в рабочего");
                return new AntWorker();
        }
    }
}
