import java.util.ArrayList;

public class Hand {
    ArrayList<Card> heldCards;
    String handName;
    int handValue;

    public Hand(String name)
    {
        heldCards = new ArrayList<Card>();
        handValue = 0;
        handName = name;
    }

    public void generateHandValue()
    {
        int total = 0;
        for (Card heldCard : heldCards) {
            total += heldCard.Value;
        }
        handValue = total;
    }

    public void addCard(Card newCard)
    {
        heldCards.add(newCard);
        System.out.println(handName + " has been dealt: {" + newCard.Name + " , " + newCard.Suite + "}");
        generateHandValue();
        System.out.println(handName + " current hand value is: " + handValue);
    }
}
