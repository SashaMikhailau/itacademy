package theme4_classes_and_objects.task24;

import theme4_classes_and_objects.task24.supplies.homesupplies.CarpetSteamer;
import theme4_classes_and_objects.task24.supplies.Appliances;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

public class Task24 {
    /*Создать иерархию классов, описывающих бытовую технику.
    Создать несколько объектов описанных классов, часть из них включить в розетку.
    Иерархия должна иметь хотя бы три уровня.*/

    /*!!!!В ПРОЦЕССЕ РАЗРАБОТКИ*/
    public static void main(String[] args) {
        Appliances carpetSteamer = new CarpetSteamer("Philips", "MR400", 100, 200, 100, new BigDecimal(10.10));
        carpetSteamer.plug();
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        carpetSteamer.unPlug();

    }
}
