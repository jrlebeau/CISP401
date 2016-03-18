package jrl.classes;

public class Dealer extends Player{
	
	private static double houseBalance = 1000000;
	
	public Dealer (String id, double balance) {
		super(id, balance);
		balance = houseBalance;
	}

}
