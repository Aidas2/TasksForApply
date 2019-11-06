package lt.aidaspupelis.videoPoker;

public class Card implements Comparable<Card> { // Interface Comparable

    private int suit;
    private int rank;
    private final static String[] suits = {"Club", "Diamonds", "Hearts", "Spades"}; // final indicates that it cannot be changed
    //		private final static String[] ranks = {"ace", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "jack", "queen", "king"};
    private final static String[] ranks = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
    //Static indicates that the variable can be shared through the whole program

    public Card(int s, int r) { //Constructor initializes suit and rank
        suit = s;
        rank = r;
    }

    public int getSuit() { //method that returns suit integer
        return suit;
    }

    public int getRank() {
        return rank;
    }

    public String toString() { //method that characterizes the card based on integers: suit and rank
        String info = ranks[rank] + " " + suits[suit];
        return info;
    }

    public int compareTo(Card other) { // method that allows cards to be compared to each other. Will help in sorting.
        if (this.getRank() > other.getRank())
            return 1;
        else if (this.getRank() < other.getRank())
            return -1;
        else
            return 0;
    }



}


