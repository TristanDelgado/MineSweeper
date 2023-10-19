package game.minesweeper;

//Instead of doing each screen as a group I will be doing each scene as
//a scene.

import javafx.geometry.Pos;
import javafx.scene.Group;
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
    TitleScene()
    {
        Text text = new Text("MineSweeper");
        text.setX(260);
        text.setY(100);

        startGameButton = new Button("Start Game");
        //startGameButton.setOnAction();
        //startGameButton.setTextFill(SetFillColorHere);

        creditsButton = new Button("Credits");
        //creditsButton.setTextFill(SetFillColorHere);

        HBox buttons = new HBox(startGameButton, creditsButton);
        buttons.setLayoutX(230);
        buttons.setLayoutY(150);
        buttons.setSpacing(20);

        introGroup = new Group(text, buttons);
        intro = new Scene(introGroup, 600, 500, Color.GRAY);
    }

    public Scene getScene(){return intro;}

}
