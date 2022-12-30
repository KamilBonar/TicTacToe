package com.project1.tictactoe;

import java.util.Objects;

import static com.project1.tictactoe.Variables.*;

public class TwoPlayerGame {

    public void game(){

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
        String winner = " ";
        String namePlayer1 = boardSize.firstPlayerName();
        String namePlayer2 = boardSize.secondPlayerName();
        int begin = order.orderDraw();

        if(begin == whoFirst){
            TextBoard.getBegin(namePlayer1);
            p1 = namePlayer1;
        }else{
            TextBoard.getBegin(namePlayer2);
            p1 = namePlayer2;
        }

        while (movesCounter < dim * dim && !won) {
            newBoard.printBoard(board);
            boolean moveWasCorrect = order.performMove(board, p1, activePlayer);

            if (moveWasCorrect) {
                movesCounter++;
                if(dim == board3){
                    w = check.checkWinner(board, activePlayer, movesCounter);
                    System.out.println(w);
                }else{
                    w = check2.checkWinner2(board, activePlayer, movesCounter);
                }
                if (w == continueGame){
                    won = false;
                    winner = p1;
                    p1 = Objects.equals(p1, namePlayer1) ? namePlayer2 : namePlayer1;
                    activePlayer = activePlayer == 'X' ? 'O' : 'X';
                }else if(w == finishGame){
                    won = true;
                    winner = p1;
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
