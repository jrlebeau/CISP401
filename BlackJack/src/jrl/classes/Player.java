package jrl.classes;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Player {

	private String id;
	private double balance;
	private String formattedBalance;
	public PlayerHand hand;
	
	public Player(String id, double startBalance) {
		setId(id);
		setBalance(startBalance);
		hand = new PlayerHand();
	}

	public String getId() {
		return id;
	}

	private void setId(String id) {
		this.id = id;
	}

	public double getBalance() {
		return balance;
	}

	private void setBalance(double balance) {
		this.balance = balance;
		setFormattedBalance(balance);
	}
	
	public boolean playerHasEnough(double amount) {
		double total = balance - amount;
		if (total > 0 ) {
			return true;
		} else {
			return false;
		}
	}
	
	public void removeCardsFromHand() {
		hand = new PlayerHand();
	}
	
	public void addCardToHand(Card c) {
		hand.addCardToHand(c);
	}
	
	private void setFormattedBalance(double balance) {
		NumberFormat balanceFormat = NumberFormat.getCurrencyInstance(Locale.US);
		this.formattedBalance = balanceFormat.format(balance);
	}
	
	public String getFormattedBalance() {
		return formattedBalance;
	}
	
	public void addToBalance(double amount) {
		double total = balance + amount;
		setBalance(total);
	}
	
	public void subtractFromBalance(double amount) {
		double total = balance - amount;
		setBalance(total);
		
	}
	public void setPlayerBet( Scanner s ) {
		int bet = 0;
		System.out.print(this.getId() + " has " + this.getBalance() + " to bet.  Enter amount to bet on this hand: ");
		bet = Integer.parseInt(s.nextLine());
//		input.close();
		if (bet > 0 && bet < this.getBalance()) {
			this.hand.setCurrentBet(bet);
		} else {
			this.hand.setCurrentBet(0);
		}
	}

}
