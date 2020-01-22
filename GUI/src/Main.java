import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.FileChooser;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;


import java.io.File;

public class Main extends Application {

    private Button button1;
    private Button button2;
    private Button button3;
    private FileChooser fileChooser = new FileChooser();
    private Stage window;
    private Scene scene_main;
    private Scene scene_help;
    private WebView browser = new WebView();
    final WebEngine webEngine = browser.getEngine();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
                primaryStage.setTitle("Picogreen Report Generator by Joon Hwan Hong");

        // Button for data file selection section
        button1 = new Button("Select data file");
        button1.setOnAction(actionEvent -> { File datafile  = fileChooser.showOpenDialog(primaryStage); } );
        // Button for settings file selection section


        // Button for about and help section
        button2 = new Button("Help & Instructions");
        button2.setOnAction(actionEvent -> window.setScene(scene_help) );
        // Button to return to main data file selection section
        button3 = new Button("Return to data selection");
        button3.setOnAction(actionEvent -> window.setScene(scene_main));

        // main layout
        Label main_label = new Label("Please select a .xlsx data file to proceed");
        VBox layout_main = new VBox(10);
        layout_main.getChildren().addAll(main_label, button1, button2);
        scene_main = new Scene(layout_main, 450, 300);
        // about and help layout
        webEngine.load("https://github.com/Joon-Hwan-Hong/Picogreen-Automation");
        Label help_label1 = new Label("The project github page is loaded for instructions.");
        VBox layout_help = new VBox(10);
        layout_help.getChildren().addAll(help_label1, button3, browser);
        scene_help = new Scene(layout_help, 1400, 700);

        window.setScene(scene_main);
        window.show();
    }


}
