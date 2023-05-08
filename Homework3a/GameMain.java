package Homework.Homework3a;

import java.util.Scanner;

public class GameMain {
    static Scanner input = new Scanner(System.in);
    static int maxPlayers = 2;

    public static void main(String[] args) {

        Game game = new Game();

        for (int i = 0; i < maxPlayers; i++) {
            System.out.println("Name of player " + (i + 1));
            String playerName = input.nextLine();
            game.addPlayer(playerName);
        }

        System.out.println("Players in the game: ");
        for (int i = 0; i < game.players.size(); i++) {
            System.out.println(game.players.get(i).name);
        }

        System.out.println("Init game");
        for (int i = 0; i < game.players.size(); i++) {

            Player p = game.players.get(i);
            System.out.println("Init game for player: " + p.name);

            game.placeShips(p);
            // game.demo(p);
        }

        System.out.println("Field of gamer: ");
        for (int i = 0; i < game.players.size(); i++) {
            Player p = game.players.get(i);
            System.out.println(p.name);
            System.out.println("Ships count: " + p.field.ships.size());
        }
        game.play();
    }
}
