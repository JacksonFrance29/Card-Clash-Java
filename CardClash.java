import java.util.ArrayList;

public class CardClash {

    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.shuffle();

        Player player = new Player();
        Player computer = new Player();


        ArrayList<Card> allCards = deck.getCards();
        for (int i = 0; i < allCards.size(); i++) {
            if (i % 2 == 0) {
                player.addCard(allCards.get(i));
            } else {
                computer.addCard(allCards.get(i));
            }
        }

        int round = 1;
        int MAX_ROUNDS = 3000;  

        while (player.getCardCount() > 0 && computer.getCardCount() > 0 && round <= MAX_ROUNDS) {

            System.out.println("Round " + round + ":");

            ArrayList<Card> pot = new ArrayList<Card>();

            Card pCard = player.playCard();
            Card cCard = computer.playCard();

            if (pCard == null || cCard == null) {
                break;
            }

            pot.add(pCard);
            pot.add(cCard);

            System.out.println("Player plays: " + pCard);
            System.out.println("Computer plays: " + cCard);

            if (pCard.getValue() > cCard.getValue()) {
                System.out.println("Player wins the round!");
                addPotToWinner(player, pot);
            }
            else if (cCard.getValue() > pCard.getValue()) {
                System.out.println("Computer wins the round!");
                addPotToWinner(computer, pot);
            }
            else {
                System.out.println("Tie – WAR!");
                handleWar(player, computer, pot);
            }

            System.out.println("Player cards: " + player.getCardCount());
            System.out.println("Computer cards: " + computer.getCardCount());
            System.out.println("--------------------------------");

            round++;
        }

        System.out.println("GAME OVER");
        System.out.println("Final card counts:");
        System.out.println("Player: " + player.getCardCount());
        System.out.println("Computer: " + computer.getCardCount());

        if (player.getCardCount() > computer.getCardCount()) {
            System.out.println("Player wins the game!");
        }
        else if (computer.getCardCount() > player.getCardCount()) {
            System.out.println("Computer wins the game!");
        }
        else {
            System.out.println("The game ends in a tie (round limit reached).");
        }
    }

    public static void addPotToWinner(Player winner, ArrayList<Card> pot) {
        for (int i = 0; i < pot.size(); i++) {
            winner.addCard(pot.get(i));
        }
        pot.clear();
    }

    public static void handleWar(Player player, Player computer, ArrayList<Card> pot) {

        Card pDown = player.playCard();
        Card cDown = computer.playCard();

        if (pDown != null) pot.add(pDown);
        if (cDown != null) pot.add(cDown);

        Card pUp = player.playCard();
        Card cUp = computer.playCard();

        if (pUp == null || cUp == null) {
            if (pUp != null) {
                pot.add(pUp);
                addPotToWinner(player, pot);
            } else if (cUp != null) {
                pot.add(cUp);
                addPotToWinner(computer, pot);
            } else {
                pot.clear();
            }
            return;
        }

        pot.add(pUp);
        pot.add(cUp);

        System.out.println("Player war card: " + pUp);
        System.out.println("Computer war card: " + cUp);

        if (pUp.getValue() > cUp.getValue()) {
            System.out.println("Player wins the war!");
            addPotToWinner(player, pot);
        }
        else if (cUp.getValue() > pUp.getValue()) {
            System.out.println("Computer wins the war!");
            addPotToWinner(computer, pot);
        }
        else {
            System.out.println("Another tie in war. Pot discarded.");
            pot.clear();
        }
    }
}
