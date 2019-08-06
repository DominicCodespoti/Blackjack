import java.util.Scanner;

public class Program {
    public static boolean checkBlackjack(Hand checkHand) {
        if (checkHand.handValue == 21) {
            return true;
        }
        return false;
    }

    public static boolean checkBust(Hand checkHand) {
        if (checkHand.handValue > 21) {
            return true;
        }
        return false;
    }

    public static void aceChecker(Hand playerHand)
    {
        Scanner inputReader = new Scanner(System.in);
        String userInput = "";
        if (playerHand.heldCards.get(playerHand.heldCards.size() -1).Name.equals("ACE")){
            System.out.println("Would you like the Ace to value at 1 or 10?: ");
            userInput = inputReader.next();
            if (userInput.equals("1"))
                playerHand.heldCards.get(playerHand.heldCards.size() -1).Value = 1;
            if (userInput.equals("1"))
                playerHand.heldCards.get(playerHand.heldCards.size() -1).Value = 11;
        }
    }

    public static String mainGame() {
        Scanner inputReader = new Scanner(System.in);
        String userInput = "hit";

        Deck tableDeck = new Deck();
        Hand playerHand = new Hand("Player");
        Hand dealerHand = new Hand("Dealer");

        dealerHand.addCard(tableDeck.dispenseRandomCard());
        playerHand.addCard(tableDeck.dispenseRandomCard());

        aceChecker(playerHand);

        dealerHand.addCard(tableDeck.dispenseRandomCard());
        playerHand.addCard(tableDeck.dispenseRandomCard());

        aceChecker(playerHand);

        while (userInput.equals("hit") && !checkBust(playerHand) && !checkBlackjack(playerHand)) {
            System.out.println("Would you like to 'hit' or 'stay': ");
            userInput = inputReader.next();
            if (userInput.equals("hit")) {
                playerHand.addCard(tableDeck.dispenseRandomCard());
                aceChecker(playerHand);
            }
        }

        if (checkBlackjack(playerHand))
            return playerHand.handName + " has drawn a Blackjack!";
        if (checkBust(playerHand))
            return playerHand.handName + " has busted!";

        while (dealerHand.handValue <= 17 && checkBust(dealerHand) != true && checkBlackjack(dealerHand) != true) {
            dealerHand.addCard(tableDeck.dispenseRandomCard());
        }

        if (checkBlackjack(dealerHand))
            return dealerHand.handName + " has drawn a Blackjack and won!";
        if (checkBust(dealerHand))
            return dealerHand.handName + " has busted and lost!";
        if (dealerHand.handValue > playerHand.handValue)
            return dealerHand.handName + " holds a hand with a value of " + dealerHand.handValue
                    + " beating the players hand of " + playerHand.handValue;

        if (dealerHand.handValue == playerHand.handValue)
            return "Both players have a hand value of " + playerHand.handValue + ", ending the game" +
                    "in a draw!";

        return playerHand.handName + " holds a hand with a value of " + playerHand.handValue
                + " beating the dealers hand of " + dealerHand.handValue;
    }

    public static void main(String[] args) {
        Scanner inputReader = new Scanner(System.in);
        String userInput = "";

        while (userInput != "start") {
            System.out.println("Welcome to Blackjack! Type 'start' to play or 'quit' to exit: ");
            userInput = inputReader.next();
            if (userInput.toLowerCase().equals("start"))
                System.out.println(mainGame());
            else if (userInput.toLowerCase().equals("quit"))
                break;
        }
    }
}


