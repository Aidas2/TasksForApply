package lt.aidaspupelis.videoPoker;

import java.util.*;

import static lt.aidaspupelis.videoPoker.Game.deck;

public class Player {

    private static final int STARTING_BALANCE = 1000;
    private int playerBalance;
    private int playerBet; // in case when players bets (must check if  playerBalance is sufficient)

    private static final int[] PRIZES = {800, 50, 25, 9, 6, 4, 3, 2, 1, 0};

    private ArrayList<Card> cardsInHand = new ArrayList<Card>();
    private Scanner scanner = new Scanner(System.in);

    public Player() {
        this.playerBalance = STARTING_BALANCE;

    }

    public void addCard(Card card) { //method for adding a card to cardsInHand array
        cardsInHand.add(card);
    }

    public void resetCards() {
        cardsInHand.clear(); // to begin with completely new cards
        deck = new Deck();
    }

    public String toString() {
        String info = "";
        for (Card card : cardsInHand) {
            info += card.toString() + "\n"; //getting information of the cards only in the user's cardsInHand
        }
        return info;

    }

    public void rejectCards() {
        String reject;
        String rejected = ""; //Rejected card numbers will be taken as a string
        System.out.println("Would you like to reject any cards? (Y - yes / N - no)");
        reject = scanner.nextLine().toUpperCase();

        if (reject.equals("Y")) {
            System.out.println("Which card(s) would you like to reject? Example: (13) rejects your first and third cards. Allowed numbers are 1, 2, 3, 4, 5");
            rejected = scanner.nextLine(); //TODO It would be nice to do validation of entered values
        }

        replace(rejected); //calls method for replacing cards
    }

    private void replace(String rejected) {
        if (!rejected.equals("")) { //if the rejected string is not empty
            for (int j = 0; j < rejected.length(); j++) {//the length condition allows us to replace the number
                //of cards the user rejected.
                int cardToRemove = Integer.parseInt(rejected.substring(j, j + 1));
                Card card = deck.draw(); //static variable deck is used here. Draws a card from it.
                cardsInHand.set(cardToRemove - 1, card); //replacing the rejected card with the new card at appropriate index.
            }
            System.out.println("Your new cards are\n");
            System.out.println(toString());

        }
    }

    /**
     * Hand 	        Prize 	Example
     * Royal Flush 	    800 	10-J-Q-K-A  (five highest SEQUENTIAL cards of the SAME suit)
     * Straight Flush 	50      2-3-4-5-6   (five SEQUENTIAL cards of the SAME suit)
     * Four of a kind 	25      A-A-A-A-4   (four cards of the same denomination)
     * Full House 	    9       3-3-3-7-7   (three of one card and two of another)
     * Flush 	        6       5-6-9-10-A  (five NON-SEQUENTIAL cards of the SAME suit)
     * Straight 	    4       5-6-7-8-9   (five SEQUENTIAL cards of VARYING suits)
     * Three of a kind 	3       A-A-A-K-3   (three cards of the same denomination)
     * Two Pair 	    2       2-2-K-K-A   (two pairs of different cards)
     * Jacks or Better 	1       J-3-J-K-A   (two cards of J or Q or K or A)
     * All Other 	    0
     */

    //================================================================================================================
    //VERSION_01. SIMPLE, WITHOUT WINING CONDITIONS, JUST FOR TESTING.

    private static final String[] HAND_TYPES = {"All Other", "Jacks or Better", "Two Pairs", "Three of a Kind", "Straight", "Flush",
            "Full House", "Four of a Kind", "Straight Flush", "Royal Flush"};

    public void categorizeHandV1() {

        int randomIndex = (int) (Math.random() * HAND_TYPES.length);
        String luckyHand = HAND_TYPES[randomIndex];

        switch (luckyHand) {
            case "Royal Flush":
                playerBalance += PRIZES[0];
                System.out.println("Royal Flush! You won " + PRIZES[0] + " Eur. Your balance is " + playerBalance + " Eur");
                break;
            case "Straight Flush":
                playerBalance += PRIZES[1];
                System.out.println("Straight Flush! You won " + PRIZES[1] + " Eur. Your balance is " + playerBalance + " Eur");
                break;
            case "Four of a Kind":
                playerBalance += PRIZES[2];
                System.out.println("Four of a Kind! You won " + PRIZES[2] + " Eur. Your balance is " + playerBalance + " Eur");
                break;
            case "Full House":
                playerBalance += PRIZES[3];
                System.out.println("Full House! You won " + PRIZES[3] + " Eur. Your balance is " + playerBalance + " Eur");
                break;
            case "Flush":
                playerBalance += PRIZES[4];
                System.out.println("Flush! You won " + PRIZES[4] + " Eur. Your balance is " + playerBalance + " Eur");
                break;
            case "Straight":
                playerBalance += PRIZES[5];
                System.out.println("Straight! You won " + PRIZES[5] + " Eur. Your balance is " + playerBalance + " Eur");
                break;
            case "Three of a Kind":
                playerBalance += PRIZES[6];
                System.out.println("Three of a Kind! You won " + PRIZES[6] + " Eur. Your balance is " + playerBalance + " Eur");
                break;
            case "Two Pair":
                playerBalance += PRIZES[7];
                System.out.println("Two Pair! You won " + PRIZES[7] + " Eur. Your balance is " + playerBalance + " Eur");
                break;
            case "Jacks or Better":
                playerBalance += PRIZES[8];
                System.out.println("Jacks or Better! You won " + PRIZES[8] + " Eur. Your balance is " + playerBalance + " Eur");
                break;
            case "All Other":
                System.out.println("No luck.  You won " + PRIZES[9] + " Eur. Your balance is " + playerBalance + " Eur");
            default:
                System.out.println("No valid conditions");
                break;
        }

    }
    //================================================================================================================
    //================================================================================================================
    //VERSION_02. WITH REAL WINNING CONDITIONS
/*
    public String categorizeHandV2() {
        //method for scoring cardsInHand
        for (int i = 0; i < 5; i++) { // nested for loops are part of sorting the cardsInHand
            for (int j = 0; j < 4; j++) {
                int compare = cardsInHand.get(j).compareTo(cardsInHand.get(j + 1)); //compareTo is called. Compares values
                if (compare > 0) { //will arrange cards in ascending order of values
                    Card temp = cardsInHand.get(j);
                    cardsInHand.set(j, cardsInHand.get(j + 1));
                    cardsInHand.set(j + 1, temp);
                }
            }
        }
        boolean pair = false, twopair = false, // booleans that set each score to false.
                threeofakind = false, straight = false, flush = false,
                fullhouse = false, fourofakind = false, straightflush = false,
                royalflush = false;

        for (int k = 0; k < 4; k++) { //primary for loop. Will go through each of the five cards

            if (cardsInHand.get(k).getRank() == cardsInHand.get(k + 1).getRank() //criteria for pair
                    && (k - 1 < 0 || cardsInHand.get(k - 1).getRank() != cardsInHand.get(k).getRank()) // boundary conditions for just being pair.
                    && (k + 2 > 4 || cardsInHand.get(k + 2).getRank() != cardsInHand.get(k).getRank())) {
                if (pair == true) {
                    twopair = true; //since we have a loop. this will be true if pair is true twice.

                }

                pair = true;

            }

            if ((k < 2) && cardsInHand.get(k).getRank() == cardsInHand.get(k + 1).getRank() && cardsInHand.get(k + 1).getRank()
                    == cardsInHand.get(k + 2).getRank() && cardsInHand.get(k + 2) == cardsInHand.get(k + 3)) {
                fourofakind = true; // cardsInHand with four cards of the same value.
            }

            if (!fourofakind && (k < 3) && cardsInHand.get(k).getRank() == cardsInHand.get(k + 1).getRank()
                    && cardsInHand.get(k + 1).getRank() == cardsInHand.get(k + 2).getRank()) {
                threeofakind = true; //is a subset of four a kind. Three values must be the same.

            }
            if ((k < 1) && (cardsInHand.get(k + 4).getRank() == 12 && cardsInHand.get(k).getRank() == 0 || //checking to see if we have an ace
                    cardsInHand.get(k).getRank() + 1 == cardsInHand.get(k + 1).getRank())          // and king (special case).
                    && cardsInHand.get(k + 1).getRank() + 1 == cardsInHand.get(k + 2).getRank() && //checks for consecutive values.
                    cardsInHand.get(k + 2).getRank() + 1 == cardsInHand.get(k + 3).getRank() &&
                    cardsInHand.get(k + 3).getRank() + 1 == cardsInHand.get(k + 4).getRank()) {

                straight = true;
            }
            if ((k < 1) && cardsInHand.get(k).getSuit() == cardsInHand.get(k + 1).getSuit() && //compares suit values.
                    cardsInHand.get(k + 1).getSuit() == cardsInHand.get(k + 2).getSuit() &&
                    cardsInHand.get(k + 2).getSuit() == cardsInHand.get(k + 3).getSuit() &&
                    cardsInHand.get(k + 3).getSuit() == cardsInHand.get(k + 4).getSuit()) {

                flush = true; // is true if the suit values of each card is same.
                if (straight == true) {
                    straightflush = true; // will be true if straight is true since flush will already be true.
                    royalflush = cardsInHand.get(0).getRank() == 0 && cardsInHand.get(1).getRank() == 9;

                    //royal flush is special case. If first card in sorted cardsInHand is ace
                    //and second card is 10 and since straight flush is true, we have
                    //royal flush is true.

                }

            }
        }

        fullhouse = threeofakind & pair; //only true if pair and three of a kind are true.

        //Hierarchy ensures that only the highest cardsInHand is scored.
        if (royalflush) {
            playerBalance += PRIZES[0];
            return "Royal Flush! You won " + PRIZES[0] + " Eur. Your balance is " + playerBalance + " Eur.";
        }
        if (straightflush) {
            playerBalance += PRIZES[1];
            return "Straight Flush! You won " + PRIZES[1] + " Eur. Your balance is " + playerBalance + " Eur.";
        }
        if (fourofakind) {
            playerBalance += PRIZES[2];
            return "Four of a Kind! You won " + PRIZES[2] + " Eur. Your balance is " + playerBalance + " Eur.";
        }
        if (fullhouse) {
            playerBalance += PRIZES[3];
            return "Full House! You won " + PRIZES[3] + " Eur. Your balance is " + playerBalance + " Eur.";
        }
        if (flush) {
            playerBalance += PRIZES[4];
            return "Flush! You won " + PRIZES[4] + " Eur. Your balance is " + playerBalance + " Eur.";
        }
        if (straight) {
            playerBalance += PRIZES[5];
            return "Straight! You won " + PRIZES[5] + " Eur. Your balance is " + playerBalance + " Eur.";
        }
        if (threeofakind) {
            playerBalance += PRIZES[6];
            return "Three of a Kind! You won " + PRIZES[6] + " Eur. Your balance is " + playerBalance + " Eur.";
        }
        if (twopair) {
            playerBalance += PRIZES[7];
            return "Two Pairs! You won " + PRIZES[7] + " Eur. Your balance is " + playerBalance + " Eur.";
        }
        if (pair) {
            playerBalance += PRIZES[8];
            return "One Pair! You won " + PRIZES[8] + " Eur. Your balance is " + playerBalance + " Eur.";
        } else {
            playerBalance += PRIZES[9];
            return "No luck. You won " + PRIZES[9] + " Eur. Your balance is " + playerBalance + " Eur.";
        }

    }

*/
    //================================================================================================================
    //================================================================================================================
    //VERSION_03. WITH REAL WINNING CONDITIONS. MORE ADVANCED.

    public void categorizeHandV3() {
        if (isRoyalFlush()) {
            playerBalance += PRIZES[0];
            System.out.println("Royal Flush! You won " + PRIZES[0] + " Eur. Your balance is " + playerBalance + " Eur");
        } else if (isStraightFlush()) {
            playerBalance += PRIZES[1];
            System.out.println("Straight Flush! You won " + PRIZES[1] + " Eur. Your balance is " + playerBalance + " Eur");
        } else if (isStraight()) {
            playerBalance += PRIZES[2];
            System.out.println("Straight! You won " + PRIZES[2] + " Eur. Your balance is " + playerBalance + " Eur");
        } else if (isFlush()) {
            playerBalance += PRIZES[3];
            System.out.println("Flush! You won " + PRIZES[3] + " Eur. Your balance is " + playerBalance + " Eur");
        } else if (isFullHouse()) {
            playerBalance += PRIZES[4];
            System.out.println("Full House You won " + PRIZES[4] + " Eur. Your balance is " + playerBalance + " Eur");
        } else if (isOfAKind(4)) {
            playerBalance += PRIZES[5];
            System.out.println("Four of a Kind! You won " + PRIZES[5] + " Eur. Your balance is " + playerBalance + " Eur");
        } else if (isOfAKind(3)) {
            playerBalance += PRIZES[6];
            System.out.println("Three of a Kind! You won " + PRIZES[6] + " Eur. Your balance is " + playerBalance + " Eur");
        } else if (isTwoPair()) {
            playerBalance += PRIZES[7];
            System.out.println("Two Pair! You won " + PRIZES[7] + " Eur. Your balance is " + playerBalance + " Eur");
        } else if (isRoyalPair()) {
            playerBalance += PRIZES[8];
            System.out.println("Jacks or Better! You won " + PRIZES[8] + " Eur. Your balance is " + playerBalance + " Eur");
        } else {
            System.out.println("No luck.  You won " + PRIZES[9] + " Eur. Your balance is " + playerBalance + " Eur");
        }
    }


    private boolean isRoyalFlush() {
        int firstCardSuit = cardsInHand.get(0).getSuit();
        List<Integer> royalFlushRankList = Arrays.asList(0, 9, 10, 11, 12); // A, 10, J, Q, K

        for (Card card : cardsInHand) {
            if (card.getSuit() != firstCardSuit || !royalFlushRankList.contains(card.getRank()))
                return false;
        }

        return true;
    }

    private boolean isStraightFlush() {
        int firstCardSuit = cardsInHand.get(0).getSuit();
        List<Integer> sortedCardRanks = new ArrayList<>();

        //Create an Integer list containing all the player's ranks
        for (Card card : cardsInHand) {
            sortedCardRanks.add(card.getRank());
        }

        //Sort the ranks
        Collections.sort(sortedCardRanks);

        //Check to see that all card suits are identical
        for (Card card : cardsInHand) {
            if (card.getSuit() != firstCardSuit)
                return false;
        }

        //Go Step by step to see if the next card's rank is only 1 more than it
        for (int i = 0; i < 4; i++) {
            if (!(sortedCardRanks.get(i) == (sortedCardRanks.get(i + 1) - 1)))
                return false;
        }

        return true;
    }


    //Consective cards of different suits
    private boolean isStraight() {
        int firstCardSuit = cardsInHand.get(0).getSuit();
        List<Integer> sortedCardRanks = new ArrayList<>();
        List<Integer> cardSuits = new ArrayList<>();

        //Create an Integer list containing all the player's ranks
        for (Card card : cardsInHand) {
            sortedCardRanks.add(card.getRank());
            cardSuits.add(card.getSuit());
        }

        //Sort the ranks
        Collections.sort(sortedCardRanks);

        //Check to see that all card suits are not identical
        Set<Integer> suitSet = new HashSet<>(cardSuits);

        //If set size is smaller, there are duplicates, meaning more than one suit, which a Straight requires
        if (suitSet.size() > cardSuits.size())
            return false;

        //Go Step by step to see if the next card's rank is only 1 more than it
        for (int i = 0; i < 4; i++) {
            if (!(sortedCardRanks.get(i) == (sortedCardRanks.get(i + 1) - 1)))
                return false;
        }

        return true;
    }

    //Hand of entirely identical suits
    private boolean isFlush() {
        int firstCardSuit = cardsInHand.get(0).getSuit();

        //Check to see that all card suits are identical
        for (Card card : cardsInHand) {
            if (card.getSuit() != firstCardSuit)
                return false;
        }

        return true;
    }


    //Hand consisting of 3 same ranks, and 2 other same ranks
    private boolean isFullHouse() {
        HashMap<Integer, Integer> rankMap = new HashMap<>();

        for (Card card : cardsInHand) {
            if (!rankMap.containsKey(card.getRank())) {
                rankMap.put(card.getRank(), 1);
            } else {
                int value = rankMap.get(card.getRank());
                rankMap.put(card.getRank(), value + 1);
            }
        }

        return rankMap.containsValue(3) && rankMap.containsValue(2);
    }


    //Hand consisting of either 3, 4 or N of same kinds of ranks
    private boolean isOfAKind(int kindType) {
        HashMap<Integer, Integer> rankMap = new HashMap<>();

        for (Card card : cardsInHand) {
            if (!rankMap.containsKey(card.getRank())) {
                rankMap.put(card.getRank(), 1);
            } else {
                int value = rankMap.get(card.getRank());
                rankMap.put(card.getRank(), value + 1);
            }
        }

        return rankMap.containsValue(kindType);
    }


    //Hand consisting of two pairs of identical ranks, and 1 different rank
    private boolean isTwoPair() {
        HashMap<Integer, Integer> rankMap = new HashMap<>();
        int pairCounter = 0;

        for (Card card : cardsInHand) {
            if (!rankMap.containsKey(card.getRank())) {
                rankMap.put(card.getRank(), 1);
            } else {
                int value = rankMap.get(card.getRank());
                rankMap.put(card.getRank(), value + 1);
                pairCounter++;
            }
        }

        return pairCounter == 2 && rankMap.containsValue(1);
    }


    //Hand consisting of one pair of identical rank, and 3 cards of different ranks
    private boolean isRoyalPair() {
        HashMap<Integer, Integer> rankMap = new HashMap<>();
        int pairCounter = 0;

        for (Card card : cardsInHand) {
            if (!rankMap.containsKey(card.getRank())) {
                rankMap.put(card.getRank(), 1);
                pairCounter = 1;
            } else {
                int value = rankMap.get(card.getRank());
                rankMap.put(card.getRank(), value + 1);
                pairCounter++;
            }
        }

        return pairCounter == 2 && rankMap.containsValue(1);
    }


}
