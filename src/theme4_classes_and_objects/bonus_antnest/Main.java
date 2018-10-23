package theme4_classes_and_objects.bonus_antnest;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        AntNest nest = new AntNest();
        nest.initNest();
        while (nest.checkNest()) {
            try {
                nest.deathTurn();
                nest.lifeTurn();
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
