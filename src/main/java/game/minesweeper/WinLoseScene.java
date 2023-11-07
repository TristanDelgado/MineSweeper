package game.minesweeper;

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.layout.HBox;

public class WinLoseScene {
    private Scene endScreenScene;
    private Group endScreenGroup;
    public Button backToTitleButton;
    private Button quitButton;
    private Text winText;
    private Text loseText;
    WinLoseScene(double xWindowWidth, double yWindowWidth)
    {
        winText = new Text("You Win!");
        winText.setFont(Font.font("Cooper Black", 80));
        winText.setStroke(Color.BLACK);
        winText.setStrokeWidth(3);
        winText.setFill(Color.DARKGREEN);
        winText.setX((xWindowWidth - winText.getLayoutBounds().getWidth()) * 0.5);
        winText.setY(100);

        loseText = new Text("You lose :(");
        loseText.setFont(Font.font("Cooper Black", 80));
        loseText.setStroke(Color.BLACK);
        loseText.setStrokeWidth(3);
        loseText.setFill(Color.DARKRED);
        loseText.setX((xWindowWidth - loseText.getLayoutBounds().getWidth()) * 0.5);
        loseText.setY(100);

        backToTitleButton = new Button("Back To Title");
        backToTitleButton.setTextFill(Color.BLACK);
        backToTitleButton.setBackground(Background.fill(Color.LIGHTBLUE));
        backToTitleButton.setPrefHeight(15);
        backToTitleButton.setPrefWidth(100);

        quitButton = new Button("Quit");
        quitButton.setTextFill(Color.BLACK);
        quitButton.setBackground(Background.fill(Color.LIGHTBLUE));
        quitButton.setPrefHeight(15);
        quitButton.setPrefWidth(100);
        quitButton.setOnMouseClicked(this::exitButtonClicked);


        HBox winHBox = new HBox(backToTitleButton, quitButton);
        winHBox.setLayoutX((xWindowWidth - 220)/2); //The 220 is 100 for each button and 20 for spacing
        winHBox.setLayoutY(yWindowWidth - (yWindowWidth * (2.0/3.0)));
        winHBox.setSpacing(20);

        endScreenGroup  = new Group(winHBox);
        endScreenScene  = new Scene(endScreenGroup,  xWindowWidth, yWindowWidth, Color.GRAY);
    }

    public Scene getWinScene(){
        if(endScreenGroup.getChildren().contains(loseText))
        {
            endScreenGroup.getChildren().remove(loseText);
        }
        if(!endScreenGroup.getChildren().contains(winText))
        {
            endScreenGroup.getChildren().add(winText);
        }
        return endScreenScene;
    }
    public Scene getLoseScene(){
        if(endScreenGroup.getChildren().contains(winText))
        {
            endScreenGroup.getChildren().remove(winText);
        }
        if(!endScreenGroup.getChildren().contains(loseText))
        {
            endScreenGroup.getChildren().add(loseText);
        }
        return endScreenScene;
    }
    private void exitButtonClicked(MouseEvent event)
    {
        System.exit(0);
    }
}
