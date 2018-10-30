package theme4_classes_and_objects.task24;


import theme4_classes_and_objects.task24.supplies.Appliances;
import theme4_classes_and_objects.task24.supplies.homesupplies.CarpetSteamer;
import theme4_classes_and_objects.task24.supplies.homesupplies.HairDryer;
import theme4_classes_and_objects.task24.supplies.homesupplies.Iron;
import theme4_classes_and_objects.task24.supplies.kitchensupplies.CoffeeMachine;
import theme4_classes_and_objects.task24.supplies.kitchensupplies.Refrigirator;
import theme4_classes_and_objects.task24.supplies.mediasupplies.AudioSystem;
import theme4_classes_and_objects.task24.supplies.mediasupplies.TVSet;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Model {
    private Control control;
    private List<Appliances> list;

    public Model(Control control) {
        this.control = control;
        initList();
    }

    private void initList() {
        list = new ArrayList<>();
        list.add(new CarpetSteamer(this,"Philips", "MR400", 100, 200, 100, new BigDecimal(10.10),100));
        list.add(new HairDryer(this,"Samsung", "5677", 100, 100, 100, new BigDecimal(5.10),50));
        list.add(new Iron(this,"Craft", "0300", 200, 100, 100, new BigDecimal(5.60),250));
        list.add(new CoffeeMachine(this, "Lavazza", "TL400", 150, 150, 100, new BigDecimal(50), 200));
        list.add(new Refrigirator(this, "LG", "A0101", 400, 950, 400, new BigDecimal(500), 1400));
        list.add(new TVSet(this, "Sony", "KL5001", 500, 450, 20, new BigDecimal(700), 50.1));
        list.add(new AudioSystem(this, "Sven", "MRM555", 300, 200, 200, new BigDecimal(200), 100.5));

    }

    public List<String> getList() {
        return list.stream().map(Appliances::toString).collect(Collectors.toList());
    }

    public boolean isPlugged(int index) {
        return list.get(index).isTurnedOn();
    }

    public boolean turn(int selectedIndex) {
        Appliances appliances = list.get(selectedIndex);
        if(appliances.isTurnedOn()){
            appliances.unPlug();
            return false;
        } else {
            appliances.plug();
            return true;
        }
    }


    public void sendMessage(String format) {
        control.sendMessage(format);
    }
}
