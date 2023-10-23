package game.minesweeper;

import java.util.ArrayList;
import java.util.Random;

public class GameState {
    //
    ArrayList<ArrayList<Character>> grid;
    int width, height;
    GameState() {
        grid = new ArrayList<ArrayList<Character>>();
        height = 10;
        width = 10;
        for(int i = 0; i < 10; i++) {
            grid.add(new ArrayList<Character>());
        }
        grid.forEach((ArrayList<Character> element) -> {
            for(int i = 0; i < 10; i++) {
                element.add('#');
            }
        });
    }
    ArrayList<ArrayList<Character>> getGrid() {
        return grid;
    }
    void setGridCord(int x, int y, Character des) {
        grid.get(x).set(y, des);
    }
    int countAdjMines(int x, int y) {
        int res = 0;
        // Check top-left
        // Check top-left
        if (!(x - 1 < 0) && !(y - 1 < 0) && (grid.get(x - 1).get(y - 1) == 'x' || grid.get(x - 1).get(y - 1) == 'X')) {
            res++;
        }

        // Check top-right
        if (!(x - 1 < 0) && !(y + 1 >= width) && (grid.get(x - 1).get(y + 1) == 'x' || grid.get(x - 1).get(y + 1) == 'X')) {
            res++;
        }

        // Check left
        if (!(y - 1 < 0) && (grid.get(x).get(y - 1) == 'x' || grid.get(x).get(y - 1) == 'X')) {
            res++;
        }

        // Check right
        if (!(y + 1 >= width) && (grid.get(x).get(y + 1) == 'x' || grid.get(x).get(y + 1) == 'X')) {
            res++;
        }

        // Check bottom-left
        if (!(x + 1 >= height) && !(y - 1 < 0) && (grid.get(x + 1).get(y - 1) == 'x' || grid.get(x + 1).get(y - 1) == 'X')) {
            res++;
        }

        // Check bottom-right
        if (!(x + 1 >= height) && !(y + 1 >= width) && (grid.get(x + 1).get(y + 1) == 'x' || grid.get(x + 1).get(y + 1) == 'X')) {
            res++;
        }

        // Check bottom
        if (!(x + 1 >= height) && (grid.get(x + 1).get(y) == 'x' || grid.get(x + 1).get(y) == 'X')) {
            res++;
        }

        return res;
    }
    boolean isMine(int x, int y) {
        return (grid.get(x).get(y) == 'x' ||  grid.get(x).get(y) == 'X');
    }
    boolean isVictory() {
        boolean res = true;

        parent:
        for (int i = 0 ; i < height; i++) {
            for(int j = 0; j < width; j++) {
                if(grid.get(i).get(j) == 'y' || grid.get(i).get(j) == 'x') {
                    res = false;
                    break parent;
                }
            }
        }

        return res;
    }
    void seedMines(int num) {
        Random random = new Random();
        for (int i = 0; i < num; i++) {
            int rx = random.nextInt(height);
            int ry = random.nextInt(width);
            grid.get(rx).set(ry, 'x');
        }
        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                grid.get(i).set(j, Character.forDigit(countAdjMines(i,j), 10) );
            }
         }
    }




}
