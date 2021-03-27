package Devoir_3;

import java.util.ArrayList;
import java.util.Objects;

public class Player {
    private ArrayList<Card> hand;

    public Player() {
        hand = new ArrayList<>();
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public void clear() {
        hand.clear();
    }

    public void add(Card card) throws NullPointerException {
        if (Objects.isNull(card)) {
            throw new NullPointerException("The card is null");
        }
        hand.add(card);
    }

    public void remove(Card card) {
        hand.remove(card);
    }

    public void remove(int position) throws IllegalArgumentException {
        try {
            hand.remove(position);
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalArgumentException("Position does not exists in the hand");
        }
    }

    public int totalCards() {
        return hand.size();
    }

    public Card getCard(int position) {
        try {
            return hand.get(position);
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalArgumentException("Position does not exists in the hand");
        }
    }

    public int getHandTotal() {
        int total = 0;
        for (Card card : hand) {
            total += card.getValue();
        }
        return total;
    }

    public void sortByColor() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public void sortByValue() {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
