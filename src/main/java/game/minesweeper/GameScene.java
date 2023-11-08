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
    int flagCount;
    GameState gameState;
    MineSquare [][]mineSquare;
    NumberSprites numberSprites;
    int boardSizeHeight;
    int boardSizeWidth;
    boolean gameOver;
    boolean didWin;

    GameScene(double xWindowWidth, double yWindowWidth, boolean gameResult, int boardSizeHeight, int boardSizeWidth, int mineCount) {
        numberSprites = new NumberSprites();
        this.boardSizeHeight = boardSizeHeight;
        this.boardSizeWidth = boardSizeWidth;
        gameOver = false;

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
                                for(int iterator = 0; iterator < 3; iterator++)
                                {
                                    switch (numPlaces[iterator]) {
                                        case 0:
                                            displayTimeArray[iterator].setImage(numberSprites.zeroSprite);
                                            break;
                                        case 1:
                                            displayTimeArray[iterator].setImage(numberSprites.oneSprite);
                                            break;
                                        case 2:
                                            displayTimeArray[iterator].setImage(numberSprites.twoSprite);
                                            break;
                                        case 3:
                                            displayTimeArray[iterator].setImage(numberSprites.threeSprite);
                                            break;
                                        case 4:
                                            displayTimeArray[iterator].setImage(numberSprites.fourSprite);
                                            break;
                                        case 5:
                                            displayTimeArray[iterator].setImage(numberSprites.fiveSprite);
                                            break;
                                        case 6:
                                            displayTimeArray[iterator].setImage(numberSprites.sixSprite);
                                            break;
                                        case 7:
                                            displayTimeArray[iterator].setImage(numberSprites.sevenSprite);
                                            break;
                                        case 8:
                                            displayTimeArray[iterator].setImage(numberSprites.eightSprite);
                                            break;
                                        case 9:
                                            displayTimeArray[iterator].setImage(numberSprites.nineSprite);
                                    }
                                }
                            }
                        }));

        displayFlagsArray = new ImageView[2];
        for(int i = 0; i < 2; i++)
        {
            displayFlagsArray[i] = new ImageView(new Image("C:\\MineSweeperProj\\MineSweeper\\Images\\NoNumberSprite.png"));
            displayFlagsArray[i].setLayoutY(24);
        }
        displayFlagsArray[0].setLayoutX(xWindowWidth * 0.03 + 15);
        displayFlagsArray[1].setLayoutX(xWindowWidth * 0.03);

        gameState = new GameState(boardSizeHeight, boardSizeWidth);
        gameState.seedMines(mineCount);
        flagCount = mineCount;

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
                gridPane.add(mineSquare[rows][columns],columns, rows); //organized as columns and then rows
            }
        }

        Group gameBackGround = new Group(informationRectangle, centerBorder, outLine, displayTimeArray[0],
                displayTimeArray[1], displayTimeArray[2], displayFlagsArray[0], displayFlagsArray[1], gridPane);
        gameScene = new Scene(gameBackGround, 600, 500, Color.WHITESMOKE);
    }

    public Scene getGameScene() {
        timeline.playFromStart();
        updateFlagCountDisplay();
        return gameScene;
    }
    
    private void updateFlagCountDisplay()
    {
        int [] minesLeftArray = new int [2];
        minesLeftArray[0] = (flagCount == 1) ? 1 : flagCount % 10;
        minesLeftArray[1] = (flagCount == 1) ? 0 : (flagCount - minesLeftArray[0]) / 10;

        for(int iterator = 0; iterator < 2; iterator++)
        {
            switch (minesLeftArray[iterator]) {
                case 0:
                    displayFlagsArray[iterator].setImage(numberSprites.zeroSprite);
                    break;
                case 1:
                    displayFlagsArray[iterator].setImage(numberSprites.oneSprite);
                    break;
                case 2:
                    displayFlagsArray[iterator].setImage(numberSprites.twoSprite);
                    break;
                case 3:
                    displayFlagsArray[iterator].setImage(numberSprites.threeSprite);
                    break;
                case 4:
                    displayFlagsArray[iterator].setImage(numberSprites.fourSprite);
                    break;
                case 5:
                    displayFlagsArray[iterator].setImage(numberSprites.fiveSprite);
                    break;
                case 6:
                    displayFlagsArray[iterator].setImage(numberSprites.sixSprite);
                    break;
                case 7:
                    displayFlagsArray[iterator].setImage(numberSprites.sevenSprite);
                    break;
                case 8:
                    displayFlagsArray[iterator].setImage(numberSprites.eightSprite);
                    break;
                case 9:
                    displayFlagsArray[iterator].setImage(numberSprites.nineSprite);
            }
        }
    }

    private void squareClicked(MouseEvent event) {
        if (!gameOver) {
            String id = ((MineSquare) event.getSource()).getId();
            int row = Character.getNumericValue(id.charAt(0));
            int column = Character.getNumericValue(id.charAt(2));
            System.out.println("Row: " + row);
            System.out.println("Column: " + column);
            System.out.println(gameState.getaGridCord(column, row));
            if (event.getButton() == MouseButton.PRIMARY) {
                if (gameState.isMine(column, row)) // clicked on a mine
                {
                    System.out.println("MineSquare");
                    //timeline.stop();
                    //gameOver = true;
                    //didWin = false;
                }
                else { //did not click on a mine
                    int numAdjMines = gameState.countAdjMines(column, row);
                    if (numAdjMines > 0) //if the space has adjacent mines, do not clear anything
                    {
                        mineSquare[row][column].changeToNumberSquare(numAdjMines);
                    }
                    else //if the space does not have adjacent mines, clear spaces until clearing the area
                    {
                        //todo fill in
                        System.out.println("BlankSquare");
                    }
                }
            }
            if (event.getButton() == MouseButton.SECONDARY) {
                if (mineSquare[row][column].getImage() == MineSquare.flagSquare) {
                    mineSquare[row][column].changeToCoveredSquare();
                    gameState.flagSquare(row, column);//todo is this backwords?
                    flagCount++;
                } else {
                    if (flagCount != 0) {
                        mineSquare[row][column].changeToFlagSquare();
                        gameState.flagSquare(row, column);//todo is this backwords?
                        flagCount--;
                    }
                }
            }
            updateFlagCountDisplay();
        }
    }


}



