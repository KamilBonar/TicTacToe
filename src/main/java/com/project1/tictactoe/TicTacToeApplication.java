package com.project1.tictactoe;

import static com.project1.tictactoe.Variables.gameForTwo;

public class TicTacToeApplication {

    public static void main(String[] args) {

        TextBoard first = new TextBoard();
        StartEndGame last = new StartEndGame();
        InputText input = new InputText();
        char choice;
        boolean end = false;
        boolean start = false;

        while(!end){
            if(!start){
                first.firstText();
                int kindOfGame = first.choosePlayer();
                if(kindOfGame == gameForTwo){
                    TwoPlayerGame twoPlayer = new TwoPlayerGame();
                    twoPlayer.game();
                }else{
                    GameWithComputer computer = new GameWithComputer();
                    computer.game2();
                }
            }
            TextBoard.getEndText();
            choice = input.endInput();
            end = last.finishGame(choice);
            start = last.nextGame(choice);
        }
    }
}
