import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.FileChooser;
import java.io.File;
import java.util.ArrayList;


class AlertBox {

    static ArrayList display(String title, String message) {
        Stage window_alert = new Stage();
        Label label_ab = new Label();
        label_ab.setText(message);
        Button button1;
        Button button4;

        FileChooser fileChooser = new FileChooser();
        ArrayList<File> file_loc = new ArrayList<>();

        // Button to return to main menu
        Button button_close = new Button("3. Generate Report");
        button_close.setDisable(true);
        button_close.setOnAction(actionEvent -> window_alert.close() );

        // Button for settings file selection section
        button4 = new Button("2. Select layout file");
        button4.setDisable(true);
        button4.setOnAction(actionEvent -> {
            file_loc.add(fileChooser.showOpenDialog(window_alert));
            button_close.setDisable(false);
        } );

        // Button for data file selection section
        button1 = new Button("1. Select data file");
        button1.setOnAction(actionEvent -> {
            file_loc.add(fileChooser.showOpenDialog(window_alert));
            button4.setDisable(false);
        } );

        // scene and layout
        VBox layout_ab = new VBox(10);
        layout_ab.getChildren().addAll(label_ab, button1, button4, button_close);
        layout_ab.setAlignment(Pos.CENTER);
        Scene scene_ab = new Scene(layout_ab);
        scene_ab.getStylesheets().add("DarkPicotheme.css");

        // block user interaction with other windows and Window settings
        window_alert.initModality(Modality.APPLICATION_MODAL);
        window_alert.setTitle(title);
        window_alert.setMinWidth(400);
        window_alert.setScene(scene_ab);
        window_alert.showAndWait();

        return file_loc;
    }
}
