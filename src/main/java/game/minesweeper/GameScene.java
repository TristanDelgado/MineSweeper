package game.minesweeper;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.GridPane;
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

public class

GameScene {
    double borderWidth = 8.0;
    public Scene gameScene;
    public Button tempButton;
    ImageView [] displayTimeArray;
    ImageView [] displayFlagsArray;
    Timeline timeline;
    int timerCount;
    GameState gameState;
    MineSquare [][]mineSquare;

    GameScene(double xWindowWidth, double yWindowWidth, boolean gameResult, int boardSizeHeight, int boardSizeWidth) {

        //+++++++++++++++
        tempButton = new Button("temp");
        tempButton.setLayoutX(150);
        tempButton.setLayoutY(25);
        //+++++++++++++++

        Rectangle outLine = new Rectangle(borderWidth / 2, borderWidth / 2, xWindowWidth - ((borderWidth / 2) * 2), yWindowWidth - ((borderWidth / 2) * 2));
        //For the upper left start point the borderWidth/2 gives the
        //stroke enough room to show the whole stroke.
        //For the bottom right corner the borderWidth/2 must be multiplied by two
        //and then subtracted in order to compensate for the upper right corner also being moved
        outLine.setStroke(Color.GRAY);
        outLine.setStrokeWidth(borderWidth);
        outLine.setFill(Color.TRANSPARENT);


        Rectangle centerBorder = new Rectangle(0, 62, xWindowWidth, borderWidth);
        centerBorder.setFill(Color.GRAY);

        Rectangle informationRectangle = new Rectangle(0, 0, 600, 62);
        informationRectangle.setFill(Color.BLUE);

        Image zeroSprite  = new Image("C:\\MineSweeperProj\\MineSweeper\\Images\\ZeroSprite.png");
        Image oneSprite   = new Image("C:\\MineSweeperProj\\MineSweeper\\Images\\OneSprite.png");
        Image twoSprite   = new Image("C:\\MineSweeperProj\\MineSweeper\\Images\\TwoSprite.png");
        Image threeSprite = new Image("C:\\MineSweeperProj\\MineSweeper\\Images\\ThreeSprite.png");
        Image fourSprite  = new Image("C:\\MineSweeperProj\\MineSweeper\\Images\\FourSprite.png");
        Image fiveSprite  = new Image("C:\\MineSweeperProj\\MineSweeper\\Images\\FiveSprite.png");
        Image sixSprite   = new Image("C:\\MineSweeperProj\\MineSweeper\\Images\\SixSprite.png");
        Image sevenSprite = new Image("C:\\MineSweeperProj\\MineSweeper\\Images\\SevenSprite.png");
        Image eightSprite = new Image("C:\\MineSweeperProj\\MineSweeper\\Images\\EightSprite.png");
        Image nineSprite  = new Image("C:\\MineSweeperProj\\MineSweeper\\Images\\NineSprite.png");

        displayTimeArray = new ImageView[3];
        for(int i = 0; i < 3; i++)
        {
            displayTimeArray[i] = new ImageView(new Image("C:\\MineSweeperProj\\MineSweeper\\Images\\NoNumberSprite.png"));
            displayTimeArray[i].setLayoutY(24);
        }
        displayTimeArray[0].setLayoutX(xWindowWidth - (xWindowWidth * 0.03 + 15));
        displayTimeArray[1].setLayoutX(xWindowWidth - (xWindowWidth * 0.03 + 30));
        displayTimeArray[2].setLayoutX(xWindowWidth - (xWindowWidth * 0.03 + 45));

        timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.getKeyFrames().add(
                new KeyFrame(Duration.seconds(1),
                        new EventHandler() {
                            @Override
                            public void handle(Event event) {
                                int[] numPlaces = new int [3];
                                timerCount++;
                                numPlaces[0] = timerCount % 10;
                                numPlaces[1] = (((timerCount - numPlaces[0])) % 100) / 10;
                                numPlaces[2] = (timerCount - numPlaces[0] - (((timerCount - numPlaces[0])) % 100)) / 100;
                                for(int iternator = 0; iternator < 3; iternator++)
                                {
                                    switch (numPlaces[iternator]) {
                                        case 0:
                                            displayTimeArray[iternator].setImage(zeroSprite);
                                            break;
                                        case 1:
                                            displayTimeArray[iternator].setImage(oneSprite);
                                            break;
                                        case 2:
                                            displayTimeArray[iternator].setImage(twoSprite);
                                            break;
                                        case 3:
                                            displayTimeArray[iternator].setImage(threeSprite);
                                            break;
                                        case 4:
                                            displayTimeArray[iternator].setImage(fourSprite);
                                            break;
                                        case 5:
                                            displayTimeArray[iternator].setImage(fiveSprite);
                                            break;
                                        case 6:
                                            displayTimeArray[iternator].setImage(sixSprite);
                                            break;
                                        case 7:
                                            displayTimeArray[iternator].setImage(sevenSprite);
                                            break;
                                        case 8:
                                            displayTimeArray[iternator].setImage(eightSprite);
                                            break;
                                        case 9:
                                            displayTimeArray[iternator].setImage(nineSprite);
                                    }
                                }
                            }
                        }));

        displayFlagsArray = new ImageView[3];
        for(int i = 0; i < 3; i++)
        {
            displayFlagsArray[i] = new ImageView(new Image("C:\\MineSweeperProj\\MineSweeper\\Images\\NoNumberSprite.png"));
            displayFlagsArray[i].setLayoutY(24);
        }
        displayFlagsArray[0].setLayoutX(xWindowWidth * 0.03);
        displayFlagsArray[1].setLayoutX(xWindowWidth * 0.03 + 15);
        displayFlagsArray[2].setLayoutX(xWindowWidth * 0.03 + 30);

        gameState = new GameState(boardSizeHeight, boardSizeWidth);

        mineSquare = new MineSquare[boardSizeHeight][boardSizeWidth];
        for(int rows = 0; rows < boardSizeHeight; rows++) {
            for(int columns = 0; columns < boardSizeWidth; columns++)
            {
                mineSquare[rows][columns] = new MineSquare();
                mineSquare[rows][columns].setId("" + rows + " " + columns);
                mineSquare[rows][columns].setOnMouseClicked(this::squareClicked);
            }
        }

        GridPane gridPane = new GridPane();
        gridPane.setLayoutX(8);
        gridPane.setLayoutY(70);
        for(int rows = 0; rows < boardSizeHeight; rows++) {
            for (int columns = 0; columns < boardSizeWidth; columns++) {
                gridPane.add(mineSquare[rows][columns],rows, columns);
            }
        }

        Group gameBackGround = new Group(informationRectangle, centerBorder, outLine, tempButton, displayTimeArray[0],
                displayTimeArray[1], displayTimeArray[2], displayFlagsArray[0], displayFlagsArray[1], displayFlagsArray[2], gridPane);
        gameScene = new Scene(gameBackGround, 600, 500, Color.WHITESMOKE);
    }

    public Scene getGameScene() {
        timeline.playFromStart();

        return gameScene;
    }

    private void flagPlaced(int row, int column)
    {
        //fill in
    }
    private void squareClicked(MouseEvent event)
    {
        String id = ((MineSquare)event.getSource()).getId();
        int row = Character.getNumericValue(id.charAt(0));
        int column = Character.getNumericValue(id.charAt(2));
        if(event.getButton() == MouseButton.PRIMARY) {
            mineSquare[row][column].changeToUncoveredBlankSquare();
        }
        if(event.getButton() == MouseButton.SECONDARY) {
            if(mineSquare[row][column].getImage() == MineSquare.flagSquare)
                mineSquare[row][column].changeToCoveredSquare();
            else
                mineSquare[row][column].changeToFlagSquare();
        }
    }


}



