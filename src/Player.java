import java.util.Scanner;

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

    public void allin() {
        bet = chips;
    }

    public void call(Game game) {
        if (bet == 0) {
            System.out.println("You have checked");
        } else {
            System.out.println("You have called");
            if (game.getCurrentBet() > chips) {
                allin();
            } else {
                bet = game.getCurrentBet();
            }
        }
        chips -= bet;
    }

    public void raise(Game game) {
        System.out.println("Enter the amount you want to raise by : ");
        Scanner sc = new Scanner(System.in);
        int raise = sc.nextInt();
        if (raise < game.getCurrentBet()) {
            System.out.println("You must raise by at least the current bet");
            raise(game);
        } else if (raise > chips) {
            System.out.println("You don't have enough chips to raise by that amount");
            raise(game);
        } else {
            System.out.println("You have raised by " + raise);
            game.setCurrentBet(raise);
            bet = raise;
            chips -= bet;
        }
    }

    @Override
    public String toString() {
        return "Name : "+name+"\nChips : "+chips+"\nBet : "+bet+"\nFolded : "+folded+"\nHand : "+hand[0]+" "+hand[1]+"\n";
    }

    public void play(Game game){
        if (!folded){
            System.out.println("Choose an action : ");
            System.out.println("1. Fold");
            System.out.println("2. Call/Check");
            System.out.println("3. Raise");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            switch (choice){
                case 1:
                    fold();
                    break;
                case 2:
                    call(game);
                    break;
                case 3:
                    raise(game);
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }
}
