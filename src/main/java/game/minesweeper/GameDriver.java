package game.minesweeper;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;

public class GameDriver extends Application {

    TitleScene titleScene;
    GameScene gameScene;
    WinLoseScene winLoseScene;
    Stage stage;
    public void start(Stage primaryStage){

        titleScene   = new TitleScene();
        gameScene    = new GameScene();
        winLoseScene = new WinLoseScene();
        stage        = new Stage();

        titleScene.startGameButton.setOnMouseClicked(this::startGameButtonPushed);
        stage.setScene(titleScene.getScene());
        stage.setTitle("MineSweeper");

        primaryStage = stage;
        primaryStage.show();
    }

    void startGameButtonPushed(MouseEvent event)
    {
        stage.setScene(winLoseScene.getLoseScene());
    }

    

    public static void main(String[] args) {
        launch();
    }
}




/*
These are if you need to find start a new file.
It's easier to just put all of them at the top and remove them later

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Line;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import java.util.Random;

 */