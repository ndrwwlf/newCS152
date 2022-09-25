public class cardsuitsorder {
    public static void main(String[] args) {
        String[] deck = new String[52];
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "j", "q", "k", "a"};
        String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
        int deckIndex = 0;

        for (String rank : ranks) {
            for (String suit : suits) {
                deck[deckIndex] = rank + " of " + suit;
                deckIndex++;
            }
        }

        for (String s : deck) {
            System.out.println(s);
        }
    }
}
