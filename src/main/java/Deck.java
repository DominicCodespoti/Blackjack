import java.util.ArrayList;

public class Deck {
    ArrayList<Card> heldCards;

    public Deck() {
        heldCards = new ArrayList<Card>(51);
        int i = 0;
        for (Card.Suites cardSuite : Card.Suites.values()) {
            int j = 1;
            for (Card.Names cardName : Card.Names.values()) {
                heldCards.add(new Card(j, cardName.toString(), cardSuite.toString()));
                if (heldCards.get(i).Name.equals("KING") || heldCards.get(i).Name.equals("QUEEN") || heldCards.get(i).Name.equals("JACK"))
                    heldCards.get(i).Value = 10;
                j++;
                i++;
            }
        }
    }

    public Card dispenseRandomCard() {
        int randomNumber = (int) (Math.random() * heldCards.size());
        Card randomCard = heldCards.get(randomNumber);
        heldCards.remove(randomNumber);
        return randomCard;
    }

    public void displayDeck() {
        for (int i = 0; i < heldCards.size(); i++) {
            System.out.println(heldCards.get(i).Suite);
            System.out.println(heldCards.get(i).Name);
            System.out.println(heldCards.get(i).Value + "\n");
        }
    }
}
