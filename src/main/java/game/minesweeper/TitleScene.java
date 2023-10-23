package game.minesweeper;

//Instead of doing each screen as a group I will be doing each scene as
//a scene.

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.layout.Background;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.event.ActionEvent;
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
import javafx.stage.Window;

public class TitleScene{
    public Scene intro;
    Group introGroup;
    public Button startGameButton;
    public Button creditsButton;
    TitleScene(double xWindowWidth, double yWindowWidth)
    {
        Text gameTitle = new Text("MineSweeper");
        gameTitle.setFont(Font.font("Cooper Black", 80));
        gameTitle.setStrokeWidth(3);
        gameTitle.setStroke(Color.BLACK);
        gameTitle.setFill(Color.NAVAJOWHITE);
        gameTitle.setX((xWindowWidth - gameTitle.getLayoutBounds().getWidth()) * 0.5);
        gameTitle.setY(100);

        startGameButton = new Button("Start Game");
        startGameButton.setTextFill(Color.BLACK);
        startGameButton.setBackground(Background.fill(Color.TAN));
        startGameButton.setPrefHeight(15);
        startGameButton.setPrefWidth(100);
        startGameButton.setLayoutX((xWindowWidth/2) - 50);
        startGameButton.setLayoutY(yWindowWidth - (yWindowWidth * (2.0/3.0)));

        introGroup = new Group(gameTitle, startGameButton);
        intro = new Scene(introGroup, xWindowWidth, yWindowWidth, Color.GRAY);
    }

    public Scene getScene(){return intro;}

}
