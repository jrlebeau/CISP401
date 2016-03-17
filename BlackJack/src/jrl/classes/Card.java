package jrl.classes;

import jrl.constants.Suites;

public class Card {
	
	private Suites suite;
	private int cardNumber;
	private int value;
	
	public Card (Suites suite, int cardNumber) {
		this.setSuite(suite);
		this.setCardNumber(cardNumber);
	}
	
	public Suites getSuite() {
		return suite;
	}
	private void setSuite(Suites suite) {
		this.suite = suite;
	}
	public int getCardNumber() {
		return cardNumber;
	}
	private void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
		setValue(this.cardNumber);
	}
	public int getValue() {
		return value;
	}
	private void setValue(int cardNumber) {
		if (cardNumber == 1) {
			this.value = 11;
		} else {
			if (cardNumber > 10) {
				this.value = 10;
			} else {
				this.value = cardNumber;
			}
		}
	}
	
	public boolean isAce() {
		if (this.value == 1){
			return true;
		} else {
			return false;
		}
	}
	
	public String toString() {
		return "Card: " + cardNumber + " of " + suite;
	}

}
