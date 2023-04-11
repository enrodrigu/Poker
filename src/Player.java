
public class Player {
    private String name;
    private int chips;
    private int bet;
    private boolean folded;
    private Card[] hand = new Card[2];

    // CONSTRUCTOR
    public Player(String name, int chips) {
        this.name = name;
        this.chips = chips;
        this.bet = 0;
        this.folded = false;
    }

    // GETTERS
    public Card[] getHand() {
        return hand;
    }

    // SETTERS
    public void setCard(Card card, int index) {
        hand[index] = card;
    }

    // --- METHODS ---
    public void fold() {
        folded = true;
    }

    @Override
    public String toString() {
        return "Name : "+name+"\nChips : "+chips+"\nBet : "+bet+"\nFolded : "+folded+"\nHand : "+hand[0]+" "+hand[1]+"\n";
    }

}
