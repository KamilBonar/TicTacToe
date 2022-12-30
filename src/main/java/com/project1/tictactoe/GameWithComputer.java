package com.project1.tictactoe;

import java.util.Objects;

import static com.project1.tictactoe.Variables.*;

public class GameWithComputer {

    public void game2(){

        TextBoard boardSize = new TextBoard();
        PrintBoard newBoard = new PrintBoard();
        Check3BoardGame check = new Check3BoardGame();
        Check10BoardGame check2 = new Check10BoardGame();
        InputText order = new InputText();

        boardSize.chooseSizeBoard();

        int dim = boardSize.choosePlayerBoard();
        char[][] board = new char[dim][dim];
        int movesCounter = 0;
        char activePlayer = 'X';
        boolean won = false;
        int w = 0;
        String p1;
        String p2;
        String winner = " ";
        String namePlayer1 = boardSize.firstPlayerName();
        String namePlayer2 = "Computer";
        boolean moveWasCorrect;

        p1 = namePlayer1;
        p2 = namePlayer2;

        while (movesCounter < dim * dim && !won) {
            newBoard.printBoard(board);

            if(movesCounter%2 == 0){
                moveWasCorrect = order.performMove(board, p1, activePlayer);
            }else{
                    moveWasCorrect = order.performMoveComputer(board, p2, activePlayer);
            }

            if (moveWasCorrect) {
                movesCounter++;
                if(dim == board3){
                    w = check.checkWinner(board, activePlayer, movesCounter);
                }else{
                    w = check2.checkWinner2(board, activePlayer, movesCounter);
                }
                if (w == continueGame){
                    won = false;
                    activePlayer = activePlayer == 'X' ? 'O' : 'X';
                }else if(w == finishGame){
                    won = true;
                    if((movesCounter-1)%2 == 0){
                        winner = p1;
                    }else{
                        winner = p2;
                    }
                }else{
                    winner = "Draw";
                }
            } else {
                TextBoard.getWrong();
            }
        }

        newBoard.printBoard(board);

        if(Objects.equals(winner, "Draw")){
            TextBoard.getEndGame2();
        }else{
            TextBoard.getEndGame(winner);
        }
    }
}
