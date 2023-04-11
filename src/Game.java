public class Game {
    private Deck gameDeck;
    private Player[] players;
    private int numPlayers;
    private int currentPlayer;
    private int pot;
    enum Stage {PRE_FLOP, FLOP, TURN, RIVER};
    private Stage stage;

    // --- METHODS ---
    public void burn() {
        gameDeck.draw();
    }

    public void deal() {
        for (int i = 0; i < 2; i++) {
            burn();
            for (int j = 0; j < numPlayers; j++) {
                players[j].setCard(gameDeck.draw(), i);
            }
        }
    }
}
