public class Game {
    private Deck gameDeck;
    private Player[] players;
    private int numPlayers;
    private int currentPlayer;
    private int currentBet;
    private int pot;
    enum Stage {PRE_FLOP, FLOP, TURN, RIVER};
    private Stage stage;
    private int smallBlind;
    private Card gameCards[] = new Card[5];

    // CONSTRUCTOR
    public Game(int numPlayers, int smallBlind){
        this.numPlayers = numPlayers;
        this.smallBlind = smallBlind;
        gameDeck = new Deck();
        players = new Player[numPlayers];
        for (int i = 0; i < numPlayers; i++) {
            players[i] = new Player("Player " + (i+1), 1000);
        }
        currentPlayer = 0;
        pot = 0;
        stage = Stage.PRE_FLOP;
    }

    // GETTERS

    public Player[] getPlayers() {
        return players;
    }

    public Card[] getGameCards() {
        return gameCards;
    }

    public Deck getGameDeck() {
        return gameDeck;
    }

    public Stage getStage() {
        return stage;
    }

    public int getSmallBlind() {
        return smallBlind;
    }

    public int getPot() {
        return pot;
    }

    public int getCurrentPlayer() {
        return currentPlayer;
    }

    public int getCurrentBet() {
        return currentBet;
    }

    // SETTERS

    public void setCurrentBet(int currentBet) {
        this.currentBet = currentBet;
    }

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

    public void flop() {
        burn();
        for (int i = 0; i < 3; i++) {
            gameCards[i] = gameDeck.draw();
        }
        stage = Stage.FLOP;
    }

    public void turn() {
        burn();
        gameCards[3] = gameDeck.draw();
        stage = Stage.TURN;
    }

    public void river() {
        burn();
        gameCards[4] = gameDeck.draw();
        stage = Stage.RIVER;
    }

    public void showGameCards() {
        for (Card card : gameCards) {
            System.out.print(card+";");
        }
    }

    public void playturn(){

    }
}
