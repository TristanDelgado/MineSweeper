package game.minesweeper;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
public class MineSquare extends ImageView {
    static public Image coveredSquare;
    static public Image uncoveredBlankSquare;
    static public Image flagSquare;
    static public Image mineSquare;
    static public Image redMineSquare;
    static public Image oneSquare;
    static public Image twoSquare;
    static public Image threeSquare;
    static public Image fourSquare;
    static public Image fiveSquare;
    static public Image sixSquare;
    static public Image sevenSquare;
    static public Image eightSquare;


    MineSquare() {
        coveredSquare        = new Image("C:\\MineSweeperProj\\MineSweeper\\src\\main\\java\\game\\Images\\CoveredSprite.png");
        uncoveredBlankSquare = new Image("C:\\MineSweeperProj\\MineSweeper\\src\\main\\java\\game\\Images\\UncoveredBlankSquareSprite.png");
        flagSquare           = new Image("C:\\MineSweeperProj\\MineSweeper\\src\\main\\java\\game\\Images\\FlagSquareSprite.png");
        mineSquare           = new Image("C:\\MineSweeperProj\\MineSweeper\\src\\main\\java\\game\\Images\\MineSquareSprite.png");
        redMineSquare        = new Image("C:\\MineSweeperProj\\MineSweeper\\src\\main\\java\\game\\Images\\RedMineSquareSprite.png");
        oneSquare            = new Image("C:\\MineSweeperProj\\MineSweeper\\src\\main\\java\\game\\Images\\OneSquareSprite.png");
        twoSquare            = new Image("C:\\MineSweeperProj\\MineSweeper\\src\\main\\java\\game\\Images\\TwoSquareSprite.png");
        threeSquare          = new Image("C:\\MineSweeperProj\\MineSweeper\\src\\main\\java\\game\\Images\\ThreeSquareSprite.png");
        fourSquare           = new Image("C:\\MineSweeperProj\\MineSweeper\\src\\main\\java\\game\\Images\\FourSquareSprite.png");
        fiveSquare           = new Image("C:\\MineSweeperProj\\MineSweeper\\src\\main\\java\\game\\Images\\FiveSquareSprite.png");
        sixSquare            = new Image("C:\\MineSweeperProj\\MineSweeper\\src\\main\\java\\game\\Images\\SixSquareSprite.png");
        sevenSquare          = new Image("C:\\MineSweeperProj\\MineSweeper\\src\\main\\java\\game\\Images\\SevenSquareSprite.png");
        eightSquare          = new Image("C:\\MineSweeperProj\\MineSweeper\\src\\main\\java\\game\\Images\\EightSquareSprite.png");
    }

    public void changeToCoveredSquare() {
        this.setImage(coveredSquare);
    }

    public void changeToUncoveredBlankSquare() {
        this.setImage(uncoveredBlankSquare);
    }

    public void changeToFlagSquare() {
        this.setImage(flagSquare);
    }

    public void changeToMineSquare() {
        this.setImage(mineSquare);
    }

    public void changeToRedMineSquare() {
        this.setImage(redMineSquare);
    }

    public void changeToNumberSquare(int number) {
        switch (number) {
            case 1:
                this.setImage(oneSquare);
                break;
            case 2:
                this.setImage(twoSquare);
                break;
            case 3:
                this.setImage(threeSquare);
                break;
            case 4:
                this.setImage(fourSquare);
                break;
            case 5:
                this.setImage(fiveSquare);
                break;
            case 6:
                this.setImage(sixSquare);
                break;
            case 7:
                this.setImage(sevenSquare);
                break;
            case 8:
                this.setImage(eightSquare);
                break;
        }
    }
}
