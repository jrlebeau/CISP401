package jrl.classes;

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
		case 13:
			cardName = "Ace";
			setValue(cardNumber);
			break;
		case 10:
			cardName = "Jack";
			setValue(cardNumber);
			break;
		case 11:
			cardName = "Queen";
			setValue(cardNumber);
			break;
		case 12:
			cardName = "King";
			setValue(cardNumber);
			break;
		default:
			cardName = Integer.toString(cardNumber + 1);
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
		switch (cardNumber) {
		case 1:
			this.value = 2;
			break;
		case 2:
			this.value = 3;
			break;
		case 3:
			this.value = 4;
			break;
		case 4:
			this.value = 5;
			break;
		case 5:
			this.value = 6;
			break;
		case 6:
			this.value = 7;
			break;
		case 7:
			this.value = 8;
			break;
		case 8:
			this.value = 9;
			break;
		case 9:
			this.value = 10;
			break;
		case 13:
			this.value = 11;
			break;
		default:
			this.value = 10;
			break;
		}
	}
	
	public boolean isAce() {
		if (this.cardNumber == 13){
			return true;
		} else {
			return false;
		}
	}
	
	public static Comparator<Card> numberComparator = new Comparator<Card>() {
		@Override
		public int compare(Card c1, Card c2) {
			return c1.cardNumber - c2.cardNumber;
//			if (c1.cardNumber < c2.cardNumber) {
//				return c2.cardNumber;
//			} else {
//				return c1.cardNumber;
//			}
		}
	};
	
	public String toString() {
		return "Card: " + cardName + " " + suite;
	}
	
}

