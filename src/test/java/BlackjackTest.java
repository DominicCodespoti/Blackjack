import org.junit.Assert;
import org.junit.Test;

public class BlackjackTest {
    @Test
    public void testRandomCardDispenses() {
        Deck testDeck = new Deck();
        Hand testHand = new Hand("Tester");
        testHand.addCard(testDeck.dispenseRandomCard());
        Assert.assertTrue(testDeck.heldCards.size() == 51);
    }
    @Test
    public void testPlayerGainsNewCard() {
        Deck testDeck = new Deck();
        Hand testHand = new Hand("Tester");
        testHand.addCard(testDeck.dispenseRandomCard());
        Assert.assertTrue(testHand.heldCards.size() == 1);
    }
    @Test
    public void testDeckRandomIsTrueRandom() {
        Deck testDeck = new Deck();
        Hand testHand = new Hand("Tester");
        while (testDeck.heldCards.size() > 0)
        {
            testHand.addCard(testDeck.dispenseRandomCard());
        }
        Assert.assertTrue(testDeck.heldCards.size() == 0);
    }
    @Test
    public void testBlackjack() {
        Deck testDeck = new Deck();
        Hand testHand = new Hand("Tester");
        testHand.handValue = 21;
        Assert.assertTrue(Program.checkBlackjack(testHand));
    }
    @Test
    public void testBust() {
        Deck testDeck = new Deck();
        Hand testHand = new Hand("Tester");
        testHand.handValue = 22;
        Assert.assertTrue(Program.checkBust(testHand));
    }
}