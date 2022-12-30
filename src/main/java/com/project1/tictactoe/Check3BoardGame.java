package com.project1.tictactoe;

import static com.project1.tictactoe.Variables.*;

public class Check3BoardGame {

    public int checkWinner(char[][] board, char activePlayer, int movesCounter) {
        int num = 0;
        if(!(checkFirstDiagonal(board, activePlayer)) && (movesCounter < maxMove3)){
            num = continueGame;
        }else if ((checkFirstDiagonal(board, activePlayer)) && (movesCounter < maxMove3)){
            num = finishGame;
        }else if((checkFirstDiagonal(board, activePlayer)) && (movesCounter == maxMove3)){
            num = theDraw;
        }
        return num;
    }

    private static boolean checkFirstDiagonal(char[][] board, char activePlayer) {
        boolean w = true;
        String word = "";

        InputText text = new InputText();

            for(int i = 0; i<3; i++){
                word = word + board[i][i];
                w = text.textInCheck3(word, activePlayer);
            }


        for(int i = 0; i<3; i++){
            word = word + board[i][2-i];
            w = text.textInCheck3(word, activePlayer);
        }

        for(int j = 0; j<3; j++){
            for(int i = 0; i<3; i++){
                word = word + board[j][i];
                w = text.textInCheck3(word, activePlayer);
            }
        }

        for(int m = 0; m<3; m++){
            for(int n = 0; n<3; n++){
                word = word + board[n][m];
                w = text.textInCheck3(word, activePlayer);
            }
        }

        return w;
    }
}
