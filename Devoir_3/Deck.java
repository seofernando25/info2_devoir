package Devoir_3;

import java.util.Arrays;
import java.util.Collections;

public class Deck {
    private Card[] deck;
    private int number;

    public Deck() {  //constructor
        int numberOfCards = (Card.MaxSuit + 1 - Card.MinSuit) * (Card.MaxValue + 1 - Card.MinValue); //number of cards in total
        deck = new Card[numberOfCards];   //creates a deck of 
        var i = 0;
        for (int suit = Card.MinSuit; suit <= Card.MaxSuit; suit++) {
            for (int value = Card.MinValue; value <= Card.MaxValue; value++) {    //creates cards to fill up the deck, one of each 
                deck[i] = new Card(value, suit);                                 //value of each suit
                i++;
            }
        }
        number = 0;
    }

    public void shuffle() {  //shuffles the deck
        number = 0;
        // import antigravity
        var deckList = Arrays.asList(deck);  
        Collections.shuffle(deckList);
        deck = deckList.toArray(deck);
    }

    public int numberLeft() {
        return deck.length - number; //returns how many cards are left
    }

    public Card take() throws IllegalStateException {
        Card ret;
        if (numberLeft() > 0) {    //takes a card from the deck
            ret = deck[number];
            number++;
        } else {    //returns a message if there's none left
            throw new IllegalStateException("There are no more cards to take");
        }
        return ret;
    }
}
