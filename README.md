# Minesweeper Game

## Purpose
Classic Minesweeper game in Java

## Team
Tanaka Shumba
Tristan Delgado
AlexK2003 on GitHub

## Installation / Usage
- Pull down the repo and run in an IDE such as Intellij.

## Tech Stack
- Java
- JavaFX - for UI components
- Intellij

## Notes
Created for CS-3360-TSAA: Concepts of Obj. Program I, Troy University, Fall 2023.

## Video Demo - TODO(Create Demo)
Click [HERE]() to view the final demo of the working project.

## Walkthrough
The game function very similar to a normal minesweeper game. 
Note the mine number is hard coded to 10 mines.

### Home Screen
The initial home screen presented to the user.

![Home-Screen]()

### Game Screen
After starting the game, the user can play the game as expected.
Note, left click clears a square while a right click places a flag.

Opening Game Screen

![Home-Screen]()

After clicking a random square, an algorithm
will clear all the blank squares, similar to the official game.

![Cleared Screen after a Square is clicked image]()

User can place flags on squares they believe are mines.

![Flags placed on mines image]()

If a user tries to clear a space where a mine is located, it is revealed and the user is notified they have lost.

![A mine square was clicked image]()

### Win - Lose Screen
Upon a user winning or losing, the corresponding screen is displayed.

![Win Screen Image]()

![Lose Screen Image]()