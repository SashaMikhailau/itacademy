package theme7_iostream.task30;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


public class MainView extends Application {
    /*Создать файл с текстом, прочитать, подсчитать в тексте количество знаков препинания и слов*/
    /*В ПРОЦЕССЕ РАЗРАБОТКИ*/
    private Control control = new Control(this);
    TextArea textArea;
    Button btnOk;
    Button btnFileSelect;
    Label lblFilePath;
    Label lblPunct;
    Label lblWords;
    FileChooser fileChooser;

    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox vBox = new VBox();
        HBox fileLine = new HBox(10);
        HBox resultsLine = new HBox(10);
        vBox.setAlignment(Pos.TOP_CENTER);
        btnFileSelect = new Button("Find file");
        lblFilePath = new Label(control.getFileName());
        lblPunct = new Label();
        lblWords = new Label();

        VBox.setMargin(fileLine,new Insets(25,50,25,50));
        VBox.setMargin(resultsLine,new Insets(25,50,25,50));
        fileChooser = new FileChooser();

        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("All", "*.doc","*.docx","*.txt"));
        btnFileSelect.setOnAction(event -> {
            control.setSelectedFile(fileChooser.showOpenDialog(primaryStage));
            refreshTextInfo();
        });
        btnOk = new Button("Analyze file");
        btnOk.setOnAction(event -> {
            refreshAnalyzeResults();
        });
        VBox.setMargin(btnOk,new Insets(0,50,10,50));
        textArea = new TextArea();
        VBox.setMargin(textArea,new Insets(0,50,0,50));

        fileLine.getChildren().addAll(btnFileSelect,lblFilePath);
        resultsLine.getChildren().addAll(lblPunct, lblWords);
        vBox.getChildren().addAll(fileLine,btnOk,textArea,resultsLine);
        Scene mainScene = new Scene(vBox,1000,1000);
        primaryStage.setScene(mainScene);
        primaryStage.show();

    }

    public void refreshTextInfo() {
        lblFilePath.setText(control.getFileName());
        textArea.setText(control.getText());
    }
    public void refreshAnalyzeResults() {
        try {
            lblPunct.setText(control.countPuncts());
            lblWords.setText(control.countWords());
        } catch (NullPointerException e) {
            Dialog dialog = new Dialog();
            dialog.setContentText("Файл не выбран");
            dialog.show();
        }
    }
}
