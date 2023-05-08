package Homework.Homework3a;

import java.util.ArrayList;

public class Ship {
    public int x;
    public int y;
    public int orientation; // 1 - horizontal
    int decksCount;

    public ArrayList<Deck> decks = new ArrayList<Deck>();

    public Ship(int x, int y, int orientation, int decksCount) {
        this.x = x;
        this.y = y;
        this.orientation = orientation;
        this.decksCount = decksCount;

        createDecks();
    }
    public void createDecks() {

        for (int i = 0; i < decksCount; i++) {

            Deck newDeck = new Deck();
            if (orientation == 1) {
                newDeck.x = x + i;
                newDeck.y = y;
            } else {
                newDeck.y = y + i;
                newDeck.x = x;
            }
            decks.add(newDeck);
        }
    }
}
