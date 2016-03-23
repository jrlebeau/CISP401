package jrl.classes;

import java.util.ArrayList;
import java.util.Collections;

public class CardSorter {
	ArrayList<Card> sortedCards = new ArrayList<>();
	
	public CardSorter(ArrayList<Card> cards) {
		this.sortedCards = cards;
	}
	
	public ArrayList<Card> getSortedCardsByNumber() {
		Collections.sort(sortedCards, Card.numberComparator);
		return sortedCards;
	}
}
