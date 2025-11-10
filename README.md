# Minesweeper Game

## Purpose
Classic Minesweeper game in Java

## Team
- Tanaka Shumba
- Tristan Delgado
- AlexK2003 on GitHub

## Installation / Usage
Pull down the repo and run in an IDE such as Intellij.

## Tech Stack
- Java
- JavaFX - for UI components
- Intellij

## Notes
Created for CS-3360-TSAA: Concepts of Obj. Program I, Troy University, Fall 2023.

## Video Demo
Click [HERE](https://youtu.be/WPu7-oaD3zc) to view the final demo of the working project.

## Walkthrough
The game functions very similar to a normal minesweeper game. 
Note the mine number is hard coded to 10 mines.

### Home Screen
The initial home screen presented to the user.

![Home-Screen](https://github.com/TristanDelgado/MineSweeper/blob/main/ReadMe-Images/HomeScreen.png)

### Game Screen
After starting the game, the user can play the game as expected.
Note a left click clears a square while a right click places a flag.

Opening Game Screen

![Game Start Screen](https://github.com/TristanDelgado/MineSweeper/blob/main/ReadMe-Images/GameScreenStart.png)

After clicking a random square, an algorithm will clear all the blank squares, similar to the official game.

![Cleared Screen after a Square is clicked](https://github.com/TristanDelgado/MineSweeper/blob/main/ReadMe-Images/GameScreenSquareClicked.png)

User can place flags on squares they believe are mines.

![Flags placed on mines](https://github.com/TristanDelgado/MineSweeper/blob/main/ReadMe-Images/FlagsPlaced.png)

If a user tries to clear a space where a mine is located, it is revealed and the user is notified they have lost.

![A mine square was clicked](https://github.com/TristanDelgado/MineSweeper/blob/main/ReadMe-Images/MineClicked.png)

### Win - Lose Screen
Upon a user winning or losing, the corresponding screen is displayed.

![Win Screen](https://github.com/TristanDelgado/MineSweeper/blob/main/ReadMe-Images/WinScreen.png)

![Lose Screen](https://github.com/TristanDelgado/MineSweeper/blob/main/ReadMe-Images/LoseScreen.png)