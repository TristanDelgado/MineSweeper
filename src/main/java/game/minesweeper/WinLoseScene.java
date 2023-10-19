package game.minesweeper;

import javafx.geometry.Pos;
import javafx.scene.Group;
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
    public Button backToTitleButton;
    public HBox buttons;
    WinLoseScene()
    {
        Text winText = new Text("You Win!");
        winText.setX(260);
        winText.setY(100);

        Text loseText = new Text("You lose :(");
        loseText.setX(260);
        loseText.setY(100);

        backToTitleButton = new Button("Back to title");
        backToTitleButton.setLayoutX(245);
        backToTitleButton.setLayoutY(150);
        //startGameButton.setTextFill(SetFillColorHere);

        winGroup  = new Group(winText,  backToTitleButton);
        loseGroup = new Group(loseText, backToTitleButton);
        winScene  = new Scene(winGroup,  600, 500, Color.GRAY);
        loseScene = new Scene(loseGroup, 600, 500, Color.GRAY);
    }

    public Scene getWinScene(){return winScene;}
    public Scene getLoseScene(){return loseScene;}
}
