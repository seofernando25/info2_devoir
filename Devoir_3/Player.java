package Devoir_3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;

public class Player {
    private ArrayList<Card> hand;

    public Player() { // contructor
        hand = new ArrayList<>();
    }

    public ArrayList<Card> getHand() { // returns the cards in the players hand
        return hand;
    }

    public void clear() { // removes all cards from the players hand
        hand.clear();
    }

    public void add(Card card) throws NullPointerException { // adds a card to the hand of a player
        if (Objects.isNull(card)) { // if the card added doesn't have a value for some reason, returns an error
                                    // message
            throw new NullPointerException("The card is null");
        }
        hand.add(card);
    }

    public void remove(Card card) {
        hand.remove(card); // removes a certain card from a players hand
    }

    public void remove(int position) throws IllegalArgumentException {
        try { // removes the card in a certain position of a players hand
            hand.remove(position);
        } catch (IndexOutOfBoundsException e) { // returns an error message if there's no card in that position
            throw new IllegalArgumentException("Position does not exists in the hand");
        }
    }

    public int totalCards() { // gets the number of cards in a players hand
        return hand.size();
    }

    public Card getCard(int position) { // gets the card in a certain position of a players hand
        try {
            return hand.get(position);
        } catch (IndexOutOfBoundsException e) { // if there's no cards in that postion, return an error message
            throw new IllegalArgumentException("Position does not exists in the hand");
        }
    }

    public int getHandTotal() { // adds up the value of all cards, returns the total
        int total = 0;
        for (Card card : hand) {
            total += card.getValue();
        }
        return total;
    }

    private static class ColorComparator implements Comparator<Card> {

        @Override
        public int compare(Card o1, Card o2) {
            var c1 = o1.getValue() + o1.getColor() * 100;
            var c2 = o2.getValue() + o2.getColor() * 100;
            if (c1 == c2)
                return 0;
            if (c1 > c2)
                return 1;
            return -1;
        }
    }

    private static class ValueComparator implements Comparator<Card> {

        @Override
        public int compare(Card o1, Card o2) {
            var c1 = o1.getValue() * 100 + o1.getColor();
            var c2 = o2.getValue() * 100 + o2.getColor();
            if (c1 == c2)
                return 0;
            if (c1 > c2)
                return 1;
            return -1;
        }
    }

    public void sortByValue() { // sorts the cards by numerical value, same valued cards are then organized by
                                // color, red first, black second
        Collections.sort(hand, new ColorComparator());
        Collections.sort(hand, new ValueComparator());
    }

    public void sortByColor() { // sorts the cards by their colors, red first black second
                                // both colors are additionally organized by value, low to high
        Collections.sort(hand, new ValueComparator());
        Collections.sort(hand, new ColorComparator());
    }

    // public static void main(String[] args) {
    // var d = new Player();
    // d.add(new Card(0, 1));
    // d.add(new Card(0, 2));
    // d.add(new Card(1, 1));
    // d.add(new Card(1, 3));
    // d.add(new Card(3, 1));
    // d.add(new Card(2, 0));
    // d.add(new Card(3, 0));
    // d.add(new Card(2, 1));
    // d.sortByColor();
    // for (Card c : d.hand) {
    // System.out.println(c.getValue() + " " + c.getColor());
    // }
    // }
}
