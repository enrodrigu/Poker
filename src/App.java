public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        Deck test1 = new Deck();
        test1.shuffle();
        System.out.println("First draw");
        for (int i = 0; i < 52; i++) {
            System.out.print(test1.draw()+";");
        }
        test1.reinit();
        System.out.println("\nSecond draw");
        for (int i = 0; i < 52; i++) {
            System.out.print(test1.draw()+";");
        }
    }
}
