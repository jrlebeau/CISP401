package jrl.classes;

import java.util.ArrayList;
import java.util.Comparator;

import jrl.constants.Suites;

public class Card {
	
	private int cardNumber;
	private int value;
	private String cardName;
	private Suites suite;
	
	public Card (Suites suite, int cardNumber) {
		this.setSuite(suite);
		this.setCardNumber(cardNumber);
		switch (cardNumber) {
		case 1:
			cardName = "Ace";
			setValue(cardNumber);
			break;
		case 11:
			cardName = "Jack";
			setValue(cardNumber);
			break;
		case 12:
			cardName = "Queen";
			setValue(cardNumber);
			break;
		case 13:
			cardName = "King";
			setValue(cardNumber);
			break;
		default:
			cardName = Integer.toString(cardNumber);
			setValue(cardNumber);
			break;
		}
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
	}
	public int getValue() {
		return value;
	}
	public String getCardName() {
		return cardName;
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
		if (this.cardNumber == 1){
			return true;
		} else {
			return false;
		}
	}
	
	public static Comparator<Card> numberComparator = new Comparator<Card>() {
		@Override
		public int compare(Card c1, Card c2) {
			if (c1.cardNumber > c2.cardNumber) {
				return c2.cardNumber;
			} else {
				return c1.cardNumber;
			}
		}
	};
	
	public String toString() {
		return "Card: " + cardName + " " + suite + " ";
	}
}

