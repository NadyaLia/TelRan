package Homework.Homework3a;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    static Scanner input = new Scanner(System.in);
    public ArrayList<Player> players = new ArrayList<Player>();
    public ArrayList<ShipOptions> shipOptions = new ArrayList<ShipOptions>();

    public Game() {

        shipOptions.add(new ShipOptions(1, 4));
        shipOptions.add(new ShipOptions(2, 3));
        shipOptions.add(new ShipOptions(3, 2));
        shipOptions.add(new ShipOptions(4, 1));

    }

    public void addPlayer(String name) {

        Player p = new Player(name);
        players.add(p);
    }

    public void placeShips(Player player) {
        int x, y, orientation;

        for (int i = 0; i < shipOptions.size(); i++) {
            ShipOptions opt = shipOptions.get(i);

            int addedCount = 0;
            while (addedCount < opt.count) {
                System.out.println("Add ship length:" + opt.length + " number:" + (addedCount + 1) + " of " + opt.count);

                System.out.println("Enter X coordinates: ");
                x = input.nextInt();
                System.out.println("Enter Y coordinates: ");
                y = input.nextInt();
                System.out.println("1 - horizontal; 2 - vertical");
                orientation = input.nextInt();


                Ship newShip = new Ship(x, y, orientation, opt.length);

                boolean canBeAdded = true;

                if (player.field.ships.size() > 0) {

                    for (int k = 0; k < player.field.ships.size(); k++) {
                        Ship existingShip = player.field.ships.get(k);

                        for (int j = 0; j < existingShip.decks.size(); j++) {
                            Deck existingDeck = existingShip.decks.get(j);

                            for (int l = 0; l < newShip.decks.size(); l++) {
                                Deck newDeck = newShip.decks.get(l);

                                if (existingDeck.x == newDeck.x && existingDeck.y == newDeck.y) {
                                    canBeAdded = false;
                                }

                                for (int m = newDeck.x - 1; m <= newDeck.x + 1; m++) {
                                    for (int n = newDeck.y - 1; n <= newDeck.y + 1; n++) {

                                        //System.out.println("check x" +m +" y:"+n);
                                        if (existingDeck.x == m && existingDeck.y == n) {
                                            canBeAdded = false;

                                            System.out.println("Collision x" + m + " y:" + n);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                if (canBeAdded == true) {
                    player.field.ships.add(newShip);
                    addedCount++;
                }
            }
        }
    }
    public void play() {
        int x, y;
        Player player1 = players.get(0);
        Player player2 = players.get(1);
        while (true) {


            System.out.println(player1.name + " shoot " + player2.name);
            System.out.println("shoot x: ");
            x = input.nextInt();
            System.out.println("shoot y ");
            y = input.nextInt();

            boolean isHit = player1.shoot(player2, x, y);

            if (player2.hasActiveShips() == false) {
                System.out.println(player2.name + " has no ships more and winner is " + player1.name);
                break;
            }
            if (isHit == false) {
                if (player1 == players.get(0)) {
                    player1 = players.get(1);
                    player2 = players.get(0);
                } else {
                    player1 = players.get(0);
                    player2 = players.get(1);
                }
            }
        }
    }


    /*public void demo(Player player) {

        // 4x1
        player.field.ships.add(new Ship(1, 1, 1, 1));
        player.field.ships.add(new Ship(1, 3, 1, 1));
        player.field.ships.add(new Ship(1, 5, 1, 1));
        player.field.ships.add(new Ship(1, 7, 1, 1));

        // 3x2
        *//*player.field.ships.add(new Ship(3,1,1,2));
        player.field.ships.add(new Ship(3,3,1,2));
        player.field.ships.add(new Ship(3,5,1,2));

        // 2x3
        player.field.ships.add(new Ship(6,1,1,3));
        player.field.ships.add(new Ship(6,3,1,3));

        // 1x4
        player.field.ships.add(new Ship(6,5,1,4));*//*
    //
        }*/
}
