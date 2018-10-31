package theme4_classes_and_objects.task24;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class MainView extends Application {
    private Control control = new Control(this);
    private TextArea textArea;
    private Button button;
    private ListView<String> listView;

    /*Создать иерархию классов, описывающих бытовую технику.
    Создать несколько объектов описанных классов, часть из них включить в розетку.
    Иерархия должна иметь хотя бы три уровня.*/

    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox pane1 = new VBox();
        VBox pane2 = new VBox();
       listView = new ListView<>(FXCollections.observableArrayList(control.getList()));
       listView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
           control.listItemSelected(listView.getSelectionModel().getSelectedIndex());
       } );
       ;
        button = new Button("Plug");
        button.setOnAction(event -> control.buttonClicked(listView.getSelectionModel().getSelectedIndex()));
        button.setPadding(new Insets(20));
         textArea = new TextArea();
         textArea.setPrefRowCount(10);
        pane1.getChildren().add(listView);
        VBox.setMargin(listView, new Insets(50));
        pane2.getChildren().addAll(button, textArea);
        VBox.setMargin(button, new Insets(50));
        VBox.setMargin(textArea, new Insets(50));
        HBox root = new HBox(pane1, pane2);

        Scene scene = new Scene(root, 1000, 1000);
        primaryStage.setScene(scene);
        primaryStage.show();


    }

    public void writeToConsole(String format) {
        if (textArea.getParagraphs().size() > 100) {
            textArea.clear();}

            textArea.appendText(format + "\n");
        }

    public void setButtonText(boolean isTurned) {
        button.setText(isTurned?"Unplug":"Plug");
    }
}
