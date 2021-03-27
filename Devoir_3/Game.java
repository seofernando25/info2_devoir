package Devoir_3;

public class Game {

   static boolean play() {

      Deck deck; // A deck of cards. A new deck for each game.
      Player computer; // The computer.
      Player user; // The user player.

      deck = new Deck();
      computer = new Player();
      user = new Player();

      /* Shuffle the deck, then give two cards to each player. */
      deck.shuffle();
      (computer.getHand()).add(deck.take());
      (computer.getHand()).add(deck.take());
      (user.getHand()).add(deck.take());
      (user.getHand()).add(deck.take());

      System.out.println();
      System.out.println();

      /*
       * Check if one of the players has two cards totaling to 21. The player with 21
       * wins the game. Computer wins ties.
       */
      if (computer.getHandTotal() == 21) {
         System.out.println("Computer has the " + computer.getCard(0) + " and the " + computer.getCard(1) + ".");
         System.out.println("User has the " + user.getCard(0) + " and the " + user.getCard(1) + ".");
         System.out.println();
         System.out.println("Computer wins.");
         return false;
      }

      if (user.getHandTotal() == 21) {
         System.out.println("Computer has the " + computer.getCard(0) + " and the " + computer.getCard(1) + ".");
         System.out.println("User has the " + user.getCard(0) + " and the " + user.getCard(1) + ".");
         System.out.println();
         System.out.println("You win.");
         return true;
      }

      /*
       * First the user gets a chance to draw cards ("Hit"). The while loop ends when
       * the user chooses to "Stand". If the user goes over 21, the user looses.
       */

      while (true) {

         /* Display user's cards, and let user decide to Hit or Stand. */
         System.out.println();
         System.out.println("Your cards are:");
         for (int i = 0; i < user.totalCards(); i++)
            System.out.println("    " + user.getCard(i));
         System.out.println("Your total is " + user.getHandTotal());
         System.out.println();
         System.out.println("Computer is showing the " + computer.getCard(0));
         System.out.println();
         System.out.print("Hit (H) or Stand (S)? ");
         char userAction; // User's response, 'H' or 'S'.
         do {
            userAction = Character.toUpperCase(Keyboard.getlnChar());
            if (userAction != 'H' && userAction != 'S')
               System.out.print("Please respond H or S:  ");
         } while (userAction != 'H' && userAction != 'S');

         /*
          * If the user Hits, the user gets a card. If the user Stands, the loop ends
          * (and it's the computer's turn to draw cards).
          */
         if (userAction == 'S') {
            // Loop ends; user is done taking cards.
            break;
         } else { // userAction is 'H'. Give the user a card.
                  // If the user goes over 21, the user looses.
            Card newCard = deck.take();
            user.add(newCard);
            System.out.println();
            System.out.println("User hits.");
            System.out.println("Your card is the " + newCard);
            System.out.println("Your total is now " + user.getHandTotal());
            if (user.getHandTotal() > 21) {
               System.out.println();
               System.out.println("You went over 21, you loose.");
               System.out.println("Computer's other card was the " + computer.getCard(1));
               return false;
            }
         }

      }

      /*
       * If we get to this point, the user has Stood with 21 or less. Now, it's the
       * computer's chance to draw. Computer draws cards until the computer's total is
       * > 16. If computer goes over 21, the computer looses.
       */

      System.out.println();
      System.out.println("User stands.");
      System.out.println("Computer's cards are");
      System.out.println("    " + computer.getCard(0));
      System.out.println("    " + computer.getCard(1));
      while (computer.getHandTotal() <= 16) {
         Card newCard = deck.take();
         System.out.println("Computer hits and gets the " + newCard);
         computer.add(newCard);
         if (computer.getHandTotal() > 21) {
            System.out.println();
            System.out.println("Computer went over 21. You win.");
            return true;
         }
      }
      System.out.println("Computer's total is " + computer.getHandTotal());

      /*
       * If we get to this point, both players have 21 or less. We can determine the
       * winner by comparing the values of their hands.
       */

      System.out.println();
      if (computer.getHandTotal() == user.getHandTotal()) {
         System.out.println("Computer wins on a tie.  You loose.");
         return false;
      } else if (computer.getHandTotal() > user.getHandTotal()) {
         System.out.println("Computer wins, " + computer.getHandTotal() + " points to " + user.getHandTotal() + ".");
         return false;
      } else {
         System.out.println("You win, " + user.getHandTotal() + " points to " + computer.getHandTotal() + ".");
         return true;
      }

   } // end play()

   public static void main(String[] args) {

      int money; // total amount of money the user has.
      int gamble; // Amount user bets on a game.
      boolean userWin; // true if the user win the game

      System.out.println("Hello and Welcome");
      System.out.println();

      money = 100; // User starts with $100.

      while (true) {
         System.out.println("You have " + money + " dollars.");
         do {
            System.out.println("How many dollars do you want to bet?  (Enter 0 to end.)");
            System.out.print("? ");
            gamble = Keyboard.getlnInt();
            if (gamble < 0 || gamble > money)
               System.out.println("Your answer must be between 0 and " + money + '.');
         } while (gamble < 0 || gamble > money);
         if (gamble == 0)
            break;
         userWin = play();
         if (userWin)
            money = money + gamble;
         else
            money = money - gamble;
         System.out.println();
         if (money == 0) {
            System.out.println("you are out of money!");
            break;
         }
      }

      System.out.println();
      System.out.println("You leave with $" + money + '.');

   }

}