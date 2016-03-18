package jrl.classes;

import java.util.ArrayList;

public class PlayerHand {
	
	ArrayList<Card> playerCards;
	int handTotal;
	int handTotalWithOneAce;
	int handTotalWithTwoAce;

	public PlayerHand() {
		setHandTotal(0);
		setHandTotalWithOneAce(0);
		setHandTotalWithTwoAce(0);
		
	}
	
	public void addCardToHand(Card c) {
		playerCards.add(c);
	}
	
	public int getHandTotal(){
		return handTotal;
	}
	
	private void setHandTotal(int value) {
		handTotal = value;
	}
	
	public int getHandTotalWithOneAce() {
		return handTotalWithOneAce;
	}
	
	private void setHandTotalWithOneAce(int value) {
		handTotalWithOneAce = value;
	}
	
	public int getHandTotalWithTwoAce() {
		return handTotalWithTwoAce;
	}
	
	private void setHandTotalWithTwoAce(int value) {
		handTotalWithTwoAce = value;
	}
	
	public void handTotal() {
		int cardValue = 0;
		boolean hasOneAce = false;
		boolean hasTwoAce = false;
		
		for (Card c : playerCards) {
			cardValue = c.getValue();
			setHandTotal(handTotal + cardValue);
			if (c.isAce()) {
				if (!hasOneAce) {
					setHandTotalWithOneAce(handTotal + 1);
					hasOneAce = true;
				} else {
					setHandTotalWithOneAce(handTotal + cardValue);
					if (!hasTwoAce){
						setHandTotalWithTwoAce(handTotal + 1);
						hasTwoAce = true;
					} else {
						setHandTotalWithTwoAce(handTotal + cardValue);
					}
				}
			} else {
				// not an Ace
				setHandTotalWithOneAce(handTotal + cardValue);
				setHandTotalWithTwoAce(handTotal + cardValue);				
			}
		}
	}
	
	public boolean isBusted() {
		if (handTotal > 21 && handTotalWithOneAce > 21 && handTotalWithTwoAce > 21) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isBlackJack() {
		if (handTotal == 21 || handTotalWithOneAce == 21 || handTotalWithTwoAce == 21) {
			return true;
		} else {
			return false;
		}
	}
}
