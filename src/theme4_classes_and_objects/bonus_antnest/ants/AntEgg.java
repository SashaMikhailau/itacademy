package theme4_classes_and_objects.bonus_antnest.ants;

public class AntEgg extends Ant {
    @Override
    public AntType getType() {
        return AntType.ANT_EGG;
    }
    @Override
    public AntLarvae doAction() {
        System.out.println("Из яйца вылупилась личинка");
        return new AntLarvae();
    }

}
