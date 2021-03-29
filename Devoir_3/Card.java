package Devoir_3;

import java.util.HashMap;

public class Card {
    private final int value;
    private final int suit;

    public static final HashMap<Integer, String> valueToStr = new HashMap<Integer, String>();
    public static final HashMap<Integer, String> suitToStr = new HashMap<Integer, String>();
    public static final int MinValue = 1;
    public static final int MaxValue = 13;

    public static final int MinSuit = 0;
    public static final int MaxSuit = 3;

    static { // Static initialization
        suitToStr.put(0, "Hearts");
        suitToStr.put(1, "Diamonds");
        suitToStr.put(2, "Clubs");
        suitToStr.put(3, "Spades");

        valueToStr.put(1, "A");
        valueToStr.put(2, "2");
        valueToStr.put(3, "3");
        valueToStr.put(4, "4");
        valueToStr.put(5, "5");
        valueToStr.put(6, "6");
        valueToStr.put(7, "7");
        valueToStr.put(8, "8");
        valueToStr.put(9, "9");
        valueToStr.put(10, "10");
        valueToStr.put(11, "Jack");
        valueToStr.put(12, "Queen");
        valueToStr.put(13, "King");
    }

    public Card(int value, int suit) throws IllegalArgumentException {
        if (value >= MinValue || value <= MaxValue) {
            this.value = value;

        } else {
            throw new IllegalArgumentException( // If the value of the card isn't between the min and max value
                    "Value should be between " + MinValue + " and " + MaxValue + ". Got " + value);
        }
        if (suit >= MinSuit || suit <= MaxSuit) {
            this.suit = suit;
        } else {
            throw new IllegalArgumentException(
                    "Value should be between " + MinSuit + " and " + MaxSuit + ". Got " + suit);
        }

    }

    public int getColor() {
        return suit;
    }

    public int getValue() {
        return value;
    }

    public String ColorToString() { // returns the suit value as a string of said suit
        return suitToStr.get(suit);
    }

    public String ValueToString() { // returns the value of the card as a string
        return valueToStr.get(value);
    }

    @Override
    public String toString() {
        return ValueToString() + " of " + ColorToString(); // returns both the value and the color under the "[value] of
                                                           // [suit]" format
    }

}
