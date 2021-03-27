package Devoir_3;

import java.util.Arrays;
import java.util.Collections;

public class Deck {
    private Card[] deck;
    private int number;

    public Deck() {
        int numberOfCards = (Card.MaxSuit + 1 - Card.MinSuit) * (Card.MaxValue + 1 - Card.MinValue);
        deck = new Card[numberOfCards];
        var i = 0;
        for (int suit = Card.MinSuit; suit <= Card.MaxSuit; suit++) {
            for (int value = Card.MinValue; value <= Card.MaxValue; value++) {
                deck[i] = new Card(value, suit);
                i++;
            }
        }
        number = 0;
    }

    public void shuffle() {
        number = 0;
        // import antigravity
        var deckList = Arrays.asList(deck);
        Collections.shuffle(deckList);
        deck = deckList.toArray(deck);
    }

    public int numberLeft() {
        return deck.length - number;
    }

    public Card take() throws IllegalStateException {
        Card ret;
        if (numberLeft() > 0) {
            ret = deck[number];
            number++;
        } else {
            throw new IllegalStateException("There are no more cards to take");
        }
        return ret;
    }
}
