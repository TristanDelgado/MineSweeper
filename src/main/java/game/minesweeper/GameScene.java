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
    double borderWidth = 8;
    double sideHeight = 500;
    double topLength = 600;
    public Scene gameScene;
    public
    GameScene(){
        Rectangle veryTopBorder        = new Rectangle(0,0, topLength, borderWidth);
        veryTopBorder.setFill(Color.GRAY);

        Rectangle veryBottomBorder     = new Rectangle(0, 492, topLength, borderWidth);
        veryBottomBorder.setFill(Color.GRAY);

        Rectangle leftBorder           = new Rectangle(0, 0, borderWidth, sideHeight);
        leftBorder.setFill(Color.GRAY);

        Rectangle rightBorder          = new Rectangle(592, 0, borderWidth, sideHeight);
        rightBorder.setFill(Color.GRAY);

        Rectangle centerBorder         = new Rectangle(0, 62, topLength, borderWidth);
        centerBorder.setFill(Color.GRAY);

        Rectangle informationRectangle = new Rectangle(0, 0, 600, 62);
        informationRectangle.setFill(Color.BLUE);

        Group gameBackGround = new Group(informationRectangle, veryTopBorder,veryBottomBorder, leftBorder
                ,rightBorder, centerBorder);
        gameScene = new Scene(gameBackGround, 600, 500, Color.WHITESMOKE);
    }

    public Scene getGameScene()
    {
        return gameScene;
    }

}
