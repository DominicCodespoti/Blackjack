public class Card {
    enum Suites{
        SPADES, DIAMONDS, CLUBS, HEARTS
    }
    enum Names{
        ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, KING, QUEEN;
    }

    int Value;
    String Name;
    String Suite;

    public Card (int cardValue, String cardName, String cardSuite)
    {
     Value = cardValue;
     Name = cardName;
     Suite = cardSuite;
    }
}
