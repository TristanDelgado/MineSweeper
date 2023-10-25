module game.minesweeper {
    requires javafx.controls;
    requires javafx.fxml;


    opens game.minesweeper to javafx.fxml;
    exports game.minesweeper;
    opens game.extraFiles to javafx.fxml;
}