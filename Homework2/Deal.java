package Homework.Homework2;

import java.util.Scanner;

public class Deal {

    public static void main(String[] args) {

        CardGame game = new CardGame();

        game.askForPlayers();
        game.init();
        game.shuffle();
        game.display();
    }

}
