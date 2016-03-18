package jrl.classes;

import java.text.NumberFormat;
import java.util.Locale;

public class Player {

	private String id;
	private double balance;
	private String formattedBalance;
	private PlayerHand hand;
	
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
}
