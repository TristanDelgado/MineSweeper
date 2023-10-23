package game.minesweeper;

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.layout.Background;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.layout.HBox;

public class WinLoseScene {
    public Scene winScene;
    public Scene loseScene;
    Group winGroup;
    Group loseGroup;
    public Button backToTitleButtonWin;
    public Button backToTitleButtonLose;
    WinLoseScene(double xWindowWidth, double yWindowWidth)
    {
        Text winText = new Text("You Win!");
        winText.setFont(Font.font("Cooper Black", 80));
        winText.setStroke(Color.BLACK);
        winText.setStrokeWidth(3);
        winText.setFill(Color.DARKGREEN);
        winText.setX((xWindowWidth - winText.getLayoutBounds().getWidth()) * 0.5);
        winText.setY(100);

        Text loseText = new Text("You lose :(");
        loseText.setFont(Font.font("Cooper Black", 80));
        loseText.setStroke(Color.BLACK);
        loseText.setStrokeWidth(3);
        loseText.setFill(Color.DARKRED);
        loseText.setX((xWindowWidth - loseText.getLayoutBounds().getWidth()) * 0.5);
        loseText.setY(100);

        backToTitleButtonWin = new Button("Back to title");
        backToTitleButtonWin.setTextFill(Color.BLACK);
        backToTitleButtonWin.setBackground(Background.fill(Color.LIGHTBLUE));
        backToTitleButtonWin.setPrefHeight(15);
        backToTitleButtonWin.setPrefWidth(100);
        backToTitleButtonWin.setLayoutX((xWindowWidth/2) - 50);
        backToTitleButtonWin.setLayoutY(yWindowWidth - (yWindowWidth * (2.0/3.0)));

        backToTitleButtonLose = new Button("Back to title");
        backToTitleButtonLose.setTextFill(Color.BLACK);
        backToTitleButtonLose.setBackground(Background.fill(Color.LIGHTBLUE));
        backToTitleButtonLose.setPrefHeight(15);
        backToTitleButtonLose.setPrefWidth(100);
        backToTitleButtonLose.setLayoutX((xWindowWidth/2) - 50);
        backToTitleButtonLose.setLayoutY(yWindowWidth - (yWindowWidth * (2.0/3.0)));

        winGroup  = new Group(winText, backToTitleButtonWin);
        loseGroup = new Group(loseText, backToTitleButtonLose);
        winScene  = new Scene(winGroup,  xWindowWidth, yWindowWidth, Color.GRAY);
        loseScene = new Scene(loseGroup, xWindowWidth, yWindowWidth, Color.GRAY);
    }

    public Scene getWinScene(){return winScene;}
    public Scene getLoseScene(){return loseScene;}
}
