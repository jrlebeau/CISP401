package jrl.classes;

import java.util.ArrayList;
import java.util.Collections;

import jrl.constants.Suites;

public class CardDeck {

	private static int numberOfCards = 51;
	
	public ArrayList<Card> deckOfCards;
	
	private int currentCardIndex;
	
	public CardDeck() {
		deckOfCards = new ArrayList<>();
		generateSuite(Suites.CLUBS);
		generateSuite(Suites.DIAMONDS);
		generateSuite(Suites.HEARTS);
		generateSuite(Suites.SPADES);
		
		Collections.shuffle(deckOfCards);
	}
	
	public void shuffleDeck() {
		
		Collections.shuffle(deckOfCards);
	}
	
	public Card getNextCard() {
		currentCardIndex ++;
		if (currentCardIndex > numberOfCards) {
			currentCardIndex = 0;
		}
		return deckOfCards.get(currentCardIndex);
	}
	
	private void generateSuite(Suites suite) {
		for (int i=0; i<12; i++) {
			Card c = new Card(suite, i+1);
			deckOfCards.add(c);
		}
	}
	
}
