public class App {
    public static void main(String[] args) throws Exception {
        Game game = new Game(2, 10);
        game.getGameDeck().shuffle();
        game.deal();
        for (Player player : game.getPlayers()) {
            System.out.println(player);
        }
        System.out.println("fold");
        game.flop();
        for (Card card : game.getGameCards()) {
            System.out.print(card+";");
        }
        System.out.println("\nturn");
        game.turn();
        for (Card card : game.getGameCards()) {
            System.out.print(card+";");
        }
    }
}
