import java.util.ArrayList;

public class Player {
    private ArrayList<Card> pile;

    public Player() {
        pile = new ArrayList<Card>();
    }

 
    public void addCard(Card c) {
        pile.add(c);
    }

    public Card playCard() {
        if (pile.size() > 0) {
            return pile.remove(0);
        }
        return null;
    }

    public int getCardCount() {
        return pile.size();
    }
}
