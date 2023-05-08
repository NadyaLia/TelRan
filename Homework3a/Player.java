package Homework.Homework3a;

import java.util.Scanner;

public class Player {

    public String name;
    public Field field = new Field();

    public Player(String name) {
        this.name = name;
    }

    public boolean shoot(Player opponent, int x, int y) {

        boolean hasHit = false;
        for (int i = 0; i < opponent.field.ships.size(); i++) {
            Ship ship = opponent.field.ships.get(i);
            for (int j = 0; j < ship.decks.size(); j++) {
                Deck deck = ship.decks.get(j);
                if (deck.x == x && deck.y == y && deck.hit == false) {
                    deck.hit = true;

                    System.out.println("hit at x: " + x + " y: " + y);
                    hasHit = true;
                }
            }
        }
        if (hasHit == false) {
            System.out.println("no hit at x: " + x + " y: " + y);
        }
        return hasHit;
    }

    public boolean hasActiveShips() {

        for (int i = 0; i < field.ships.size(); i++) {
            Ship ship = field.ships.get(i);
            for (int j = 0; j < ship.decks.size(); j++) {
                Deck deck = ship.decks.get(j);
                if (deck.hit != true) {
                    return true;
                }
            }
        }
        return false;
    }
}
