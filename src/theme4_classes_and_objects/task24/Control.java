package theme4_classes_and_objects.task24;

import java.util.List;

public class Control {
    private MainView application;
    private Model model;

    public Control(MainView application) {
        this.application = application;
        model = new Model(this);

    }

    public List<String> getList() {
        return model.getList();
    }

    public void buttonClicked(int selectedIndex) {
        application.setButtonText( model.turn(selectedIndex));
    }

    public void sendMessage(String format) {
        application.writeToConsole(format);
    }

    public void listItemSelected(int selectedIndex) {
        application.setButtonText(model.isPlugged(selectedIndex));
    }
}


