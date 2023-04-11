public class Card {
    private int value;
    enum Color {SPADES, HEARTS, DIAMONDS, CLUBS};
    private Color color;

    // CONSTRUCTORS
    public Card(int value, Color color) {
        this.value = value;
        this.color = color;
    }

    // GETTERS
    public Color getColor() {
        return color;
    }

    public int getValue() {
        return value;
    }

    // --- METHODS ---
    @Override
    public String toString() {
        String valueString;
        switch (this.getValue()) {
            case 11:
                valueString = "J";
                break;
            case 12:
                valueString = "Q";
                break;
            case 13:
                valueString = "K";
                break;
            default:
                valueString = Integer.toString(value);
                break;
        }
        return valueString + color.toString().charAt(0);
    }
}
