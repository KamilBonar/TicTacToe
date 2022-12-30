package com.project1.tictactoe;

public class StartEndGame {

    public boolean finishGame(char fGame){
        return fGame == 'n';
    }

    public boolean nextGame(char nGame){
        return nGame != 'y';
    }
}
