import java.util.Random;

public class Deck {
    private Card[] cards = new Card[52];
    private int numCards;

    // CONSTRUCTORS
    public Deck() {
        int i = 0;
        for (Card.Color color : Card.Color.values()) {
            for (int value = 1; value <= 13; value++) {
                cards[i] = new Card(value, color);
                i++;
            }
        }
        numCards = 52;
    }

    // GETTERS
    public int getNumCards() {
        return numCards;
    }

    // --- METHODS ---
    public void shuffle() {
        Random rand = new Random();
        for (int i = 0; i < numCards; i++) {
            int j = rand.nextInt(numCards);
            Card temp = cards[i];
            cards[i] = cards[j];
            cards[j] = temp;
        }
    }

    public Card draw() {
        if (numCards == 0) {
            return null;
        }
        numCards--;
        return cards[numCards];
    }

    public void reinit(){
        numCards = 52;
        this.shuffle();
    }
}
