import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.FileChooser;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;




public class Main extends Application {

    private FileChooser fileChooser = new FileChooser();
    private Stage window;
    private Scene scene_main;
    private Scene scene_help;
    private WebView browser = new WebView();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Button button2;
        Button button3;
        Button button_ab1;
        Button button_excel;
        Button button_close;
        RunPython runpy = new RunPython();

        window = primaryStage;
        primaryStage.setTitle("Picogreen Report Generator by Joon Hwan Hong");
        primaryStage.setMinWidth(350);
        primaryStage.setMinHeight(200);

        // ensures proper program termination
        window.setOnCloseRequest(e -> closeProgram());

        // Button for about and help section
        button2 = new Button("github page");
        button2.setOnAction(actionEvent -> window.setScene(scene_help) );
        button2.getStyleClass().add("button_git");

        // Button to return to main data file selection section
        button3 = new Button("Return to data selection");
        button3.setOnAction(actionEvent -> window.setScene(scene_main));

        // Button for opening the excel sheet
        button_excel = new Button("2. Select and Open the .xlsx report");
        button_excel.setDisable(true);
        button_excel.setOnAction(actionEvent -> {
            FileChooser fc = new FileChooser();
            fc.setInitialDirectory(
                    new File(Paths.get(".").toAbsolutePath().normalize().toString()));
            fc.showOpenDialog(primaryStage);
        });

        // Button for alertbox
        button_ab1 = new Button("1. Select files and generate report");
        button_ab1.setOnAction(actionEvent -> {
                 ArrayList files = AlertBox
                        .display("Select files and return", "Select the needed files");
                 runpy.runScript(files);
                 button_excel.setDisable(false);
        });

        button_close = new Button("3. Close application");
        button_close.setOnAction(actionEvent -> closeProgram());

        // main layout
        Label main_label = new Label("Follow the steps to proceed.");
        VBox layout_main = new VBox(10);
        layout_main.getChildren().addAll(main_label, button_ab1, button_excel, button_close, button2);
        layout_main.setAlignment(Pos.CENTER);
        scene_main = new Scene(layout_main, 450, 300);
        scene_main.getStylesheets().add("DarkPicotheme.css");

        // about and help layout
        final WebEngine webEngine = browser.getEngine();
        webEngine.load("https://github.com/Joon-Hwan-Hong/Picogreen-Automation");
        Label help_label1 = new Label("The project github page is loaded for instructions.");

        VBox layout_help = new VBox(10);
        layout_help.getChildren().addAll(help_label1, button3, browser);
        scene_help = new Scene(layout_help, 1400, 700);
        scene_help.getStylesheets().add("DarkPicotheme.css");

        window.setScene(scene_main);
        window.show();
    }

    private void closeProgram() {
        window.close();
    }


}
