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
    boolean continueLoop;
    public void start(Stage primaryStage){
        gameResult   = new GameResult();
        titleScene   = new TitleScene(600, 500);
        gameScene    = new GameScene(600, 500, 10, 10, 10, gameResult);
        winLoseScene = new WinLoseScene(600, 500);
        stage        = new Stage();
        continueLoop = true;

        titleScene.startGameButton.setOnMouseClicked(this::startGameButtonPushed);
        winLoseScene.backToTitleButton.setOnMouseClicked(this::backToTitleButtonPushed);
        gameScene.checkVictory.setOnMouseClicked(this::checkVictoryButtonPush);
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

    void checkVictoryButtonPush(MouseEvent event)
    {
        gameScene.checkVictory();
        if(gameResult.didWin)
        {
            stage.setScene(winLoseScene.getWinScene(gameResult.timeToCompleteGame));
        }
        else
        {
            stage.setScene(winLoseScene.getLoseScene(gameResult.timeToCompleteGame));
        }
    }

    public static void main(String[] args) {
        launch();
    }
}