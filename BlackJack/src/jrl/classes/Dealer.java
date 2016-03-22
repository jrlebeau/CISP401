package jrl.classes;

public class Dealer extends Player{
	
	private static double houseBalance = 1000000;
	
	public Dealer (String id, double balance) {
		super(id, houseBalance);
	}
	
	public void dealHand(Player player, CardDeck cards) {
		player.addCardToHand(cards.getNextCard());
		player.addCardToHand(cards.getNextCard());
	}
	
	public void dealerHand(CardDeck cards) {
		this.addCardToHand(cards.getNextCard());
		this.addCardToHand(cards.getNextCard());
	}

	public Card hitPlayer(Player player, CardDeck cards) {
		Card c = cards.getNextCard();
		player.addCardToHand(c);
		return c;
	}
	
	public Card hitDealer(CardDeck cards) {
		Card c = cards.getNextCard();
		this.addCardToHand(c);
		return c;
	}
	
	public void payPlayer(Player player) {
		if (player.hand.isBlackJack()) {
			player.addToBalance(player.hand.getCurrentBet() * 1.5);
			this.subtractFromBalance(player.hand.getCurrentBet() * 1.5);
		} else {
			player.addToBalance(player.hand.getCurrentBet());
			this.subtractFromBalance(player.hand.getCurrentBet());
		}
	}
	
	public void bustPlayer(Player player) {
		player.subtractFromBalance(player.hand.getCurrentBet());
		this.addToBalance(player.hand.getCurrentBet());
	}
}
