package jrl.classes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlayerHand {
	CardSorter cardSorter;
	
	private ArrayList<Card> playerCards;
	private int handTotal;
	private int currentBet;
	private boolean canDoubleDown;
	private boolean canSplit;

	public PlayerHand() {
		handTotal = 0;
		playerCards = new ArrayList<Card>();
		currentBet = 0;
		canDoubleDown = false;
		canSplit = false;
	}
	
	public void addCardToHand(Card c) {
		playerCards.add(c);
		setHandTotal();
	}
	
	public int getHandTotal(){
		return handTotal;
	}
	
	public int getCurrentBet() {
		return currentBet;
	}
	public void setCurrentBet(int currentBet) {
		this.currentBet = currentBet;
	}
	
	public ArrayList<Card> getHand() {
		return playerCards;
	}
	
	public Card getCardFromHand(int i) {
		return playerCards.get(i);
	}
	
	public boolean getCanDoubleDown() {
		return canDoubleDown;
	}
	public void setCanDoubleDown(boolean dd) {
		if (handTotal == 11) {
			canDoubleDown = true;
		} else {
			canDoubleDown = false;
		}
	}
	
	public boolean getCanSplit() {
		return canSplit;
	}
	public void setCanSplit() {
		if (playerCards.get(0).getValue() == 8 && playerCards.get(1).getValue() == 8) {
			canSplit = true;
		} else {
			canSplit = false;
		}
	}
	
	public boolean hasAces() {
		boolean hasAces = false;
		for (Card c : playerCards) {
			if (c.isAce()) {
				hasAces = true;
			}
		}
		return hasAces;
	}
	
	public void setHandTotal() {
		int cardValue = 0;
		int total = 0;
		cardSorter = new CardSorter(playerCards);
		ArrayList<Card> sortedCards = cardSorter.getSortedCardsByNumber();
		for (Card c : sortedCards) {
			cardValue = c.getValue();
			if (c.isAce()) {
				if (total + 11 > 21) {
					total = total + 1;
				} else {
					total = total + 11;
				}
			} else {
				// not an Ace
				total = total + cardValue;
			}
		}
		handTotal = total;
	}
	
	public boolean isBusted() {
		if (handTotal > 21) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isBlackJack() {
		if (handTotal == 21 ) {
			return true;
		} else {
			return false;
		}
	}
	
	public void doubleBet() {
		currentBet = currentBet * 2;
	}
}
