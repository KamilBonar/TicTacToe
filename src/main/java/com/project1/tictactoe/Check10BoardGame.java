package com.project1.tictactoe;

import static com.project1.tictactoe.Variables.*;

public class Check10BoardGame {

    public int checkWinner2(char[][] board, char activePlayer, int movesCounter) {
        int num = 0;
        if((!checkBoard10(board, activePlayer)) && (movesCounter < maxMove10)){
            num = continueGame;
        }else if ((checkBoard10(board, activePlayer)) && (movesCounter < maxMove10)){
            num = finishGame;
        }else if((checkBoard10(board, activePlayer)) && (movesCounter == maxMove10)){
            num = theDraw;
        }
        return num;
    }

    private static boolean checkBoard10(char[][] board, char activePlayer) {
        boolean w = true;
        String word = "";
        InputText text = new InputText();

        for(int j = 0; j<6; j++){
            for(int i = 0; i<(10-j); i++){
                word = word + board[i+j][i];
                w = text.textInCheck(word, activePlayer);
            }
        }
        for(int m = 1; m<6; m++){
            for(int n = 0; n<(10-m); n++){
                word = word + board[n][n+m];
                w = text.textInCheck(word, activePlayer);
            }
        }

        for(int j = 0; j<6; j++){
            for(int i = 0; i<(10-j); i++){
                word = word + board[i+j][9-i];
                w = text.textInCheck(word, activePlayer);
            }
        }
        for(int m = 1; m<6; m++){
            for(int n = 0; n<(10-m); n++){
                word = word + board[n][9-n-m];
                w = text.textInCheck(word, activePlayer);
            }
        }
        for(int j = 0; j<10; j++){
            for(int i = 0; i<10; i++){
                word = word + board[j][i];
                w = text.textInCheck(word, activePlayer);
            }
        }
        for(int m = 0; m<10; m++){
            for(int n = 0; n<10; n++){
                word = word + board[n][m];
                w = text.textInCheck(word, activePlayer);
            }
        }
        return w;
    }
}
