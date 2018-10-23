package theme4_classes_and_objects.bonus_antnest.ants;

public class AntQueen extends Ant {
    @Override
    public AntType getType() {
        return AntType.ANT_QUEEN;
    }
    @Override
    public AntEgg doAction() {
        System.out.println("Отложено яйцо");
        return new AntEgg();
    }
}
