package Devoir_3;

import java.util.ArrayList;
import java.util.Objects;

public class Player {
    private ArrayList<Card> hand;

    public Player() {  //contructor
        hand = new ArrayList<>();
    }

    public ArrayList<Card> getHand() {  //returns the cards in the players hand
        return hand;
    }

    public void clear() {  //removes all cards from the players hand
        hand.clear();
    }

    public void add(Card card) throws NullPointerException {  //adds a card to the hand of a player
        if (Objects.isNull(card)) {  //if the card added doesn't have a value for some reason, returns an error message
            throw new NullPointerException("The card is null");
        }
        hand.add(card);
    }

    public void remove(Card card) {
        hand.remove(card);  //removes a certain card from a players hand
    }

    public void remove(int position) throws IllegalArgumentException {
        try {     //removes the card in a certain position of a players hand
            hand.remove(position);
        } catch (IndexOutOfBoundsException e) {  //returns an error message if there's no card in that position
            throw new IllegalArgumentException("Position does not exists in the hand");
        }
    }

    public int totalCards() {  //gets the number of cards in a players hand
        return hand.size();
    }

    public Card getCard(int position) { //gets the card in a certain position of a players hand
        try {
            return hand.get(position);
        } catch (IndexOutOfBoundsException e) {  //if there's no cards in that postion, return an error message
            throw new IllegalArgumentException("Position does not exists in the hand");
        }
    }

    public int getHandTotal() {  //adds up the value of all cards, returns the total
        int total = 0;
        for (Card card : hand) {
            total += card.getValue();
        }
        return total;
    }

    public void sortByColor() {  //sorts the cards by their colors, red first black second
        int a = totalCards();   //both colors are additionally organized by value, low to high
        
        for(int j =1; j<a; j++){
            
        for (int i =0; i<a-1; i++){
            
            if(getCard(i).getValue() > getCard(i+1).getValue()){  //sorts the cards by their numerical value
                
                Card g = getCard(i+1);
                hand.set(i+1,getCard(i));
                hand.set(i,g);
            }
            }
            }

            for(int j =1; j<a; j++){
                for (int i =0; i<a-1; i++){  //sorts the cards by their colors                    
                    if((getCard(i).getColor() ==2 | getCard(i).getColor()==3)& (getCard(i+1).getColor() ==0 | getCard(i+1).getColor()==1)){  
                        Card g = getCard(i+1);
                        hand.set(i+1,getCard(i));
                        hand.set(i,g);
                    }
                    }
                    }
            

        
    }

    public void sortByValue() { //sorts the cards by numerical value, same valued cards are then organized by color, red first, black second
        int a = totalCards();
        
        
        for(int j =1; j<a; j++){
        for (int i =0; i<a-1; i++){
            
            if(getCard(i).getColor() > getCard(i+1).getColor()){  //sorts the cards by their colours
                Card g = getCard(i+1);
                hand.set(i+1,getCard(i));
                hand.set(i,g);
            }
            }
            }

        for(int j =1; j<a; j++){
        for (int i =0; i<a-1; i++){
            
            if(getCard(i).getValue() > getCard(i+1).getValue()){  //sorts the cards by their numerical value
                Card g = getCard(i+1);
                hand.set(i+1,getCard(i));
                hand.set(i,g);
            }
            }
            }
    }
}
