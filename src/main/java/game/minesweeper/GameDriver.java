package game.minesweeper;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;

public class GameDriver extends Application {

    //Use properties/listeners to process resizing the window

    TitleScene titleScene;
    GameScene gameScene;
    WinLoseScene winLoseScene;
    Stage stage;
    int tempNum = 0;
    boolean gameResult;
    public void start(Stage primaryStage){
        //For now the width and length will be set manually
        titleScene   = new TitleScene(600, 500);
        gameScene    = new GameScene(600, 500, gameResult);
        winLoseScene = new WinLoseScene(600, 500);
        stage        = new Stage();

        titleScene.startGameButton.setOnMouseClicked(this::startGameButtonPushed);
        winLoseScene.backToTitleButton.setOnMouseClicked(this::backToTitleButtonPushed);
        gameScene.tempButton.setOnMouseClicked(this::tempButtonPushed);
        stage.setScene(titleScene.getScene());
        stage.setTitle("MineSweeper");

        primaryStage = stage;
        primaryStage.show();
    }

    void tempButtonPushed(MouseEvent event) {
        if(tempNum == 0)
        stage.setScene(winLoseScene.getWinScene());
        else
            stage.setScene(winLoseScene.getLoseScene());
        tempNum++;
    }

    void startGameButtonPushed(MouseEvent event)
    {
        stage.setScene(gameScene.getGameScene());
    }

    void backToTitleButtonPushed(MouseEvent event)
    {
        stage.setScene(titleScene.getScene());
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