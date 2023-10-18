package game.minesweeper;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.paint.Color;

import java.io.IOException;

public class HelloApplication extends Application {

    public void start(Stage stage){
        TitleGroup introGroup = new TitleGroup();

        Scene introScene = new Scene(introGroup.getGroup(), 500, 500, Color.GRAY);

        stage.setScene(introScene);
        stage.setTitle("MineSweeper");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}