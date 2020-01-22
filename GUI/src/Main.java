import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.FileChooser;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.io.File;
import java.util.ArrayList;

import java.lang.reflect.Array;

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
        Button button5;
        Button button_ab1;
        Button button_excel;

        window = primaryStage;
        primaryStage.setTitle("Picogreen Report Generator by Joon Hwan Hong");

        // Button for about and help section
        button2 = new Button("github page");
        button2.setOnAction(actionEvent -> window.setScene(scene_help) );
        // Button to return to main data file selection section
        button3 = new Button("Return to data selection");
        button3.setOnAction(actionEvent -> window.setScene(scene_main));

        // Button for running python file
        button5 = new Button("2. Generate Report");
        button5.setOnAction(actionEvent -> {
            // test if both data file and settings file are selected, if not pop up a string that says that
            // then run a python file using whatever method
            // then notify that it has been successful in a different layout.
        });

        // Button for alertbox
        button_ab1 = new Button("1. Select files");
        button_ab1.setOnAction(actionEvent -> {
                final ArrayList files = AlertBox
                        .display("Select files and return", "Select the needed files");});

        // Button for opening the excel sheet
        button_excel = new Button("3. Open the .xlsx report");
        button_excel.setOnAction(actionEvent -> {
            // test if generating report has been made
            // then use the desktop API class to open the excel file report
            // https://stackoverflow.com/questions/17276688/open-excel-from-java-application
        });


        // main layout
        Label main_label = new Label("Follow the steps to proceed.");
        VBox layout_main = new VBox(10);
        layout_main.getChildren().addAll(main_label, button_ab1, button5, button_excel, button2);
        layout_main.setAlignment(Pos.CENTER);
        scene_main = new Scene(layout_main, 450, 300);

        // about and help layout
        final WebEngine webEngine = browser.getEngine();
        webEngine.load("https://github.com/Joon-Hwan-Hong/Picogreen-Automation");
        Label help_label1 = new Label("The project github page is loaded for instructions.");
        VBox layout_help = new VBox(10);
        layout_help.getChildren().addAll(help_label1, button3, browser);
        scene_help = new Scene(layout_help, 1400, 700);

        window.setScene(scene_main);
        window.show();
    }


}
