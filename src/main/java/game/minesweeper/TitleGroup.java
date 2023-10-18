package game.minesweeper;

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
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.event.ActionEvent;

public class TitleGroup extends Group{
    double MineSweeperImgXCenter = 350;
    double MineSweeperImgYCenter = 100;
    double StartButtonXCenter = 75;
    double StartButtonYCenter = 300;

    Group main;
    TitleGroup()
    {
        Text text = new Text("MineSweeper");
        text.setX(MineSweeperImgXCenter);
        text.setY(MineSweeperImgYCenter);

        Button startGameButton = new Button("Start Game");
        //startGameButton.setTextFill(SetFillColorHere);

        Button creditsButton = new Button("Credits");
        //creditsButton.setTextFill(SetFillColorHere);

        HBox buttons = new HBox(startGameButton, creditsButton);
        buttons.setAlignment(Pos.BOTTOM_CENTER);
        buttons.setSpacing(20);

        main = new Group(text, buttons);
    }

    public Group getGroup()
    {
        return main;
    }


    public void processStartGameButtonPush(ActionEvent event)
    {
        //Switch to game screen
    }

    public void processCreditsButtonPush(ActionEvent event)
    {
        //switch to credits screen with a back button
    }
}
