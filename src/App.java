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
        game.showGameCards();
        System.out.println("\nturn");
        game.turn();
        game.showGameCards();
        System.out.println("\nriver");
        game.river();
        game.showGameCards();
    }
}
