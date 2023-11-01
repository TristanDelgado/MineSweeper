package game.minesweeper;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.Event;
import javafx.event.EventHandler;
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
import java.util.Timer;
import java.util.TimerTask;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
public class MineSquare extends ImageView{

    Image coveredSquare;
    Image uncoveredBlankSquare;
    Image flagSquare;
    Image mineSquare;
    Image redMineSquare;
    Image oneSquare;
    Image twoSquare;
    Image threeSquare;
    Image fourSquare;
    Image fiveSquare;
    Image sixSquare;
    Image sevenSquare;
    Image eightSquare;


    MineSquare()
    {
        coveredSquare        = new Image("C:\\MineSweeperProj\\MineSweeper\\Images\\CoveredSprite.png");
        uncoveredBlankSquare = new Image("C:\\MineSweeperProj\\MineSweeper\\Images\\BlankSquareSprite.png");
        flagSquare           = new Image("C:\\MineSweeperProj\\MineSweeper\\Images\\FlagSquareSprite.png");
        mineSquare           = new Image("C:\\MineSweeperProj\\MineSweeper\\Images\\MineSquareSprite.png");
        redMineSquare        = new Image("C:\\MineSweeperProj\\MineSweeper\\Images\\RedMineSquareSprite.png");
        oneSquare            = new Image("C:\\MineSweeperProj\\MineSweeper\\Images\\OneSquareSprite.png");
        twoSquare            = new Image("C:\\MineSweeperProj\\MineSweeper\\Images\\TwoSquareSprite.png");
        threeSquare          = new Image("C:\\MineSweeperProj\\MineSweeper\\Images\\ThreeSquareSprite.png");
        fourSquare           = new Image("C:\\MineSweeperProj\\MineSweeper\\Images\\FourSquareSprite.png");
        fiveSquare           = new Image("C:\\MineSweeperProj\\MineSweeper\\Images\\FiveSquareSprite.png");
        sixSquare            = new Image("C:\\MineSweeperProj\\MineSweeper\\Images\\SixSquareSprite.png");
        sevenSquare          = new Image("C:\\MineSweeperProj\\MineSweeper\\Images\\SevenSquareSprite.png");
        eightSquare          = new Image("C:\\MineSweeperProj\\MineSweeper\\Images\\EightSquareSprite.png");
        this.setImage(coveredSquare);
    }

    public void changeToCoveredSquare() {this.setImage(coveredSquare);}
    public void changeToUncoveredBlankSquare() {this.setImage(uncoveredBlankSquare);}
    public void changeToFlagSquare() {this.setImage(flagSquare);}
    public void changeToMineSquare() {this.setImage(mineSquare);}
    public void changeToRedMineSquare() {this.setImage(redMineSquare);}
    public void changeToOneSquare() {this.setImage(oneSquare);}
    public void changeToTwoSquare() {this.setImage(twoSquare);}
    public void changeToThreeSquare(){this.setImage(threeSquare);}
    public void changeToFourSquare(){this.setImage(fourSquare);}
    public void changeToFiveSquare(){this.setImage(fiveSquare);}
    public void changeToSixSquare(){this.setImage(sixSquare);}
    public void changeToSevenSquare(){this.setImage(sevenSquare);}
    public void changeToEightSquare(){this.setImage(eightSquare);}
}
