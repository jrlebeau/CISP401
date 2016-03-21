package jrl.classes;

public class Dealer extends Player{
	
	private static double houseBalance = 1000000;
	
	public Dealer (String id, double balance) {
		super(id, balance);
		balance = houseBalance;
	}
	
	public void dealHand(Player player, CardDeck cards) {
		player.removeCardsFromHand();
		player.addCardToHand(cards.getNextCard());
		player.addCardToHand(cards.getNextCard());
	}
	
	public void dealerHand(CardDeck cards) {
		this.removeCardsFromHand();
		this.addCardToHand(cards.getNextCard());
		this.addCardToHand(cards.getNextCard());
	}

	public void hitPlayer(Player player, CardDeck cards) {
		player.addCardToHand(cards.getNextCard());
	}
	
	public void hitDealer(CardDeck cards) {
		this.addCardToHand(cards.getNextCard());
	}
	
	public void payPlayer(Player player) {
		if (player.hand.isBlackJack()) {
			player.addToBalance(player.hand.getCurrentBet() * 1.5);
		} else {
			player.addToBalance(player.hand.getCurrentBet());
		}
	}
	
	public void bustPlayer(Player player) {
		player.subtractFromBalance(player.hand.getCurrentBet());
	}
	
	public void clearHandFromPlayer(Player player) {
		player.hand.removeCardsFromHand();
	}
}
