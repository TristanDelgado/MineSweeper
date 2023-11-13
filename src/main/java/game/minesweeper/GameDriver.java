package game.minesweeper;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;

public class GameDriver extends Application {
    TitleScene titleScene;
    GameScene gameScene;
    WinLoseScene winLoseScene;
    Stage stage;
    GameResult gameResult;
    public void start(Stage primaryStage){
        gameResult   = new GameResult();
        titleScene   = new TitleScene(600, 500);
        gameScene    = new GameScene(600, 500, 10, 10, 10, gameResult);
        winLoseScene = new WinLoseScene(600, 500);
        stage        = new Stage();

        if(!gameResult.gameFinished)
        {
            stage.setScene(winLoseScene.getLoseScene());
        }

        titleScene.startGameButton.setOnMouseClicked(this::startGameButtonPushed);
        winLoseScene.backToTitleButton.setOnMouseClicked(this::backToTitleButtonPushed);
        stage.setScene(titleScene.getScene());
        stage.setTitle("MineSweeper");

        primaryStage = stage;
        primaryStage.show();
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