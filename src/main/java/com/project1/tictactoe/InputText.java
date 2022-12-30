package com.project1.tictactoe;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Random;

import static com.project1.tictactoe.Variables.gameForTwo;
import static com.project1.tictactoe.Variables.gameWithComputer;

public class InputText {
    Scanner sc = new Scanner(System.in);
    Random generator = new Random();
    public int firstInput(){
        int choose = 0;
        boolean b = true;

        while(b){
            try{
                choose = sc.nextInt();
                b = choose != gameForTwo && choose != gameWithComputer;
            }catch (InputMismatchException e) {
                TextBoard.getException();
                sc.nextLine();
            }
        }
        return choose;
    }

    public String enterPlayerName(){
        return sc.nextLine();
    }

    public int orderDraw(){
        return (generator.nextInt(2)+1);
    }

    public boolean performMove(char[][] board, String p1, char activePlayer) {
        boolean c = true;
        boolean d = true;
        int row = 0;
        int col = 0;
        int leng = board.length;

        while(c){
            try{
                TextBoard.getRow(p1);
                row = sc.nextInt();
                c = row < 0 || row >= leng;
            }catch (InputMismatchException e) {
                TextBoard.getException();
                sc.nextLine();
            }
        }

        while(d){
            try{
                TextBoard.getCol(p1);
                col = sc.nextInt();
                d = col < 0 || col >= leng;
            }catch (InputMismatchException e) {
                TextBoard.getException();
                sc.nextLine();
            }
        }

        if (board[row][col] == 0) {
            board[row][col] = activePlayer;
            return true;
        } else {
            return false;
        }
    }

    public char endInput(){
        char end;
        do{
            end = sc.next().charAt(0);
        } while(end != 'y' && end != 'n');
        return end;
    }

    public boolean performMoveComputer(char[][] board, String p2, char activePlayer) {
        int row;
        int col;
        int leng = board.length;

        TextBoard.getComputer();
        row = generator.nextInt(leng);

        col = generator.nextInt(leng);

        if (board[row][col] == 0) {
            board[row][col] = activePlayer;
            return true;
        } else {
            return false;
        }
    }

    public boolean textInCheck(String word, char activePlayer){
        boolean g = true;
        boolean w;

        if(activePlayer == 'X'){
            g = (word.matches(".+XXXXX.+") || word.matches("XXXXX.+") || word.matches(".+XXXXX") || word.matches("XXXXX"));
        }else if( activePlayer == 'O'){
            g = (word.matches(".+OOOOO.+") || word.matches("OOOOO.+") || word.matches(".+OOOOO") || word.matches("OOOOO"));
        }
        w = g;
        return w;
    }

    public boolean textInCheck3(String word, char activePlayer){
        boolean g = true;
        boolean w;

        if(activePlayer == 'X'){
            g = (word.matches(".+XXX.+") || word.matches("XXX.+") || word.matches(".+XXX") || word.matches("XXX"));
        }else if( activePlayer == 'O'){
            g = (word.matches(".+OOO.+") || word.matches("OOO.+") || word.matches(".+OOO") || word.matches("OOO"));
        }
        w = g;
        return w;
    }
}
