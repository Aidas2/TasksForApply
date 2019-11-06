package lt.aidaspupelis.videoPoker;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    private ArrayList<Card> cardsInDeck = new ArrayList<Card>();

    //constructor to create deck (already with 4*13=52 cards, also shuffled)
    public Deck() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                Card newCard = new Card(i, j);
                cardsInDeck.add(newCard);
            }
        }
        shuffle();
    }

    //method for shuffling deck
    public void shuffle() {
        Collections.shuffle(cardsInDeck);
    }


    //method for drawing ONE card (it's convenient when replacing rejected cards)
    public Card draw() {
        Card returnCard = cardsInDeck.get(0);  //gets the first card of the deck (after shuffling)
        cardsInDeck.remove(0); //if card is on hand, it should be removed from deck  // except then used card returns back
        return returnCard;
    }
}


