package game.minesweeper;

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

public class GameScene {

    //Rectangle(double x, double y, double width, double height)
    double borderWidth = 8.0;
    public Scene gameScene;

    public Button tempButton;
    public
    GameScene(double xWindowWidth, double yWindowWidth, boolean gameResult)
    {

        Rectangle outLine = new Rectangle(borderWidth/2, borderWidth/2, xWindowWidth - ((borderWidth/2)*2), yWindowWidth - ((borderWidth/2)*2));
        //For the upper left start point the borderWidth/2 gives the
        //stroke enough room to show the whole stroke.
        //For the bottom right corner the borderWidth/2 must be multiplied by two
        //and then subtracted in order to compensate for the upper right corner also being moved
        outLine.setStroke(Color.GRAY);
        outLine.setStrokeWidth(borderWidth);
        outLine.setFill(Color.TRANSPARENT);


        Rectangle centerBorder         = new Rectangle(0, 62, xWindowWidth, borderWidth);
        centerBorder.setFill(Color.GRAY);

        Rectangle informationRectangle = new Rectangle(0, 0, 600, 62);
        informationRectangle.setFill(Color.BLUE);

        //+++++++++++++++
        tempButton = new Button("temp");
        tempButton.setLayoutX(300);
        tempButton.setLayoutY(250);
        //+++++++++++++++

        Group gameBackGround = new Group(informationRectangle, centerBorder, outLine, tempButton);
        gameScene = new Scene(gameBackGround, 600, 500, Color.WHITESMOKE);
    }

    public Scene getGameScene()
    {
        return gameScene;
    }

    private void runGame()
    {

    }

}
