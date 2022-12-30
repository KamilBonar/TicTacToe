package com.project1.tictactoe;

import static com.project1.tictactoe.Variables.*;

public class TextBoard {

    public void firstText(){
        System.out.println("\tWelcome in TIC TAC TOE game!\n");
        System.out.println("Witch game would you like to play?");
        System.out.println("1: Two players");
        System.out.println("2: With computer\n");
        System.out.println("Choose one and press ENTER");
    }

    public int choosePlayer(){
        InputText a = new InputText();
        int choose = a.firstInput();
        if(choose == gameForTwo){
            System.out.println("You choose two players game");
        }else if(choose == gameWithComputer){
            System.out.println("You choose game with computer");
        }else{
            System.out.println("You choose wrong number, please try again.");
        }
        return choose;
    }

    public void chooseSizeBoard(){
        System.out.println("Please choose size of the board");
        System.out.println("1: 3x3");
        System.out.println("2: 10x10\n");
        System.out.println("Choose one and press ENTER");
    }

    public int choosePlayerBoard(){
        InputText b = new InputText();
        int choose2 = b.firstInput();
        if(choose2 == 1){
            System.out.println("You choose 3x3 board");
            choose2 = 3;
        }else if(choose2 == 2){
            System.out.println("You choose 10x10 board");
            choose2 = 10;
        }else{
            System.out.println("You choose wrong number, please try again.");
        }
        return choose2;
    }

    public String firstPlayerName(){
        System.out.print("Enter first player's name:");
        InputText c = new InputText();
        return c.enterPlayerName();
    }

    public String secondPlayerName(){
        System.out.print("Enter second player's name:");
        InputText c = new InputText();
        return c.enterPlayerName();
    }

    public static void getException(){
        System.out.println("You choose letter, not number! Try again!");
    }

    public static void getRow(String p1){
        System.out.println(p1 + ", enter the number of row.");
    }

    public static void getCol(String p1){
        System.out.println(p1 + ", enter the number of column.");
    }

    public static void getBegin(String namePlayer){
        System.out.println("Begin " + namePlayer);
    }

    public static void getWrong(){
        System.out.println("Wrong move! Try again!");
    }

    public static void getEndText(){
        System.out.println("\nDo you want play again?(y/n)");
    }

    public static void getEndGame(String winner){
        System.out.println("\n\tEnd game! Win: " + winner);
    }

    public static void getEndGame2(){
        System.out.println("\n\tEnd game! The draw!");
    }

    public static void getComputer(){
        System.out.println("Computer's turn.");
    }
}
