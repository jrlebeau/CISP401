package com;

import java.util.ArrayList;
import java.util.Scanner;

import jrl.classes.Card;
import jrl.classes.CardDeck;
import jrl.classes.Dealer;
import jrl.classes.Player;

public class Main {

	public static void main(String[] args) {
		
		boolean continueGame = true;
		boolean continueHand = true;
		
		CardDeck cd = new CardDeck();
		Dealer dealer = new Dealer("Dealer", 1000000);
		ArrayList<Player> players = new ArrayList<>();
		players.add(new Player("Player 1", 1000));
		players.add(new Player("Player 2", 1500));
		Scanner input = new Scanner(System.in);
		
		while (continueGame ) {
			cd.shuffleDeck();
			// deal hand
			for (Player p  :players) {
				p.removeCardsFromHand();
				boolean playerHasBet = false;
				int bet = 0;
				while ( !playerHasBet) {
					System.out.print(p.getId() + " has " + p.getBalance() + " to bet.  Enter amount to bet on this hand: ");
					try {
						bet = Integer.parseInt(input.nextLine());
					}
					catch (Exception e) {
						System.out.println("Enter amount between 1 and " + p.getBalance());
						continue;
					}
					if (bet > 0 && bet < p.getBalance()) {
						p.hand.setCurrentBet(bet);
						playerHasBet = true;
						
					} else if (bet == 0){
						p.hand.setCurrentBet(0);
						break;
					} else {
						System.out.println(p.getId() + " does not have that much to bet - enter 0 to skip hand");
					}
				}
				if (p.hand.getCurrentBet() > 0) 
				{
					dealer.dealHand(p, cd);
					System.out.print(p.getId() + " Delt: ");
					for (Card c : p.hand.getHand()) {
						System.out.print(" " + c.toString());
					}
					
				} else {
					System.out.println(p.getId() + " did not bet!");
				}
				System.out.println(" ");
			}
			dealer.removeCardsFromHand();
			dealer.dealerHand(cd);
			System.out.println(dealer.getId() + " Dealer has: " + dealer.hand.getCardFromHand(1) + " showing");
			System.out.println(" ");
			
			// play the hand
			for (Player p : players) {
				continueHand = true;
				if (p.hand.getCurrentBet() == 0){
					continueHand = false;				
				}
				while (continueHand) {
					System.out.print(p.getId() + " has: ");
						for (Card c : p.hand.getHand()) {
						System.out.print(" " + c.toString());
					}
					System.out.println(" ");
					if (p.hand.getCanDoubleDown()) {
						System.out.println(p.getId() + " do you want to double down? ");
						String answer = input.nextLine().toUpperCase();
						if (answer.startsWith("Y")) {
							p.hand.doubleBet();
						}
					}
					if (p.hand.isBlackJack()) {
						System.out.println(p.getId() + " BlackJack");
						continueHand = false;
					} else {
//						Scanner input = new Scanner(System.in);
						System.out.print("Hit this hand? ");
						String answer = input.nextLine().toUpperCase();
//						input.close();
						answer.toUpperCase();
						if (answer.startsWith("Y")) {
							System.out.println(dealer.hitPlayer(p, cd).toString());
							System.out.println(p.getId() + " has " + p.hand.getHandTotal());
						} else {
							// player holds
							continueHand = false;
						}
						if (p.hand.isBusted()) {
							continueHand = false;
						}
					}
				}
				if (p.hand.getCurrentBet() > 0){
					if (p.hand.isBusted()) {
						System.out.println(p.getId() + " bust!!");
					} else {
						System.out.println(p.getId() + " has " + p.hand.getHandTotal());
					}					
				}
			}
			
			// dealers turn
			continueHand = true;
			while (continueHand) {
				System.out.print(dealer.getId() + " has: ");
				for (Card c : dealer.hand.getHand()) {
					System.out.print(" " + c.toString());
				}
				System.out.println(" ");
				if (dealer.hand.isBlackJack()) {
					System.out.println(dealer.getId() + " BlackJack");
					continueHand = false;
				} else {
					if (dealer.hand.getHandTotal() < 17) {
						System.out.println(dealer.hitDealer(cd).toString());
					}
				}
				if (dealer.hand.getHandTotal() > 16 && dealer.hand.getHandTotal() < 22) {
					continueHand = false;
				}
				if (dealer.hand.isBusted()) {
					continueHand = false;
				}
			}
			System.out.println(dealer.getId() + " has " + dealer.hand.getHandTotal());
			// finish this hand
			System.out.println(" ");
			System.out.println("Finish this hand ");
			for (Player p : players) {
				if (p.hand.getCurrentBet() > 0) {
					if (p.hand.isBusted()) {
						System.out.println(p.getId() + " Losses!!  - busted");
						dealer.bustPlayer(p);
					} else {
						if (dealer.hand.isBusted()) {
							System.out.println(p.getId() + " Wins!! - dealer busted");
							dealer.payPlayer(p);
						} else {
							if (p.hand.getHandTotal() == dealer.hand.getHandTotal()) {
								System.out.println(p.getId() + " pushed ");
							}
							if (p.hand.getHandTotal() < dealer.hand.getHandTotal()) {
								System.out.println(p.getId() + " Losses!! ");
								dealer.bustPlayer(p);
							}
							if (p.hand.getHandTotal() > dealer.hand.getHandTotal()) {
								System.out.println(p.getId() + " Wins!! ");
								dealer.payPlayer(p);
							}
						}
					}				
				}
			}
//			Scanner input = new Scanner(System.in);
			System.out.print("Play another hand? ");
			String answer = input.nextLine().toUpperCase();
//			input.close();
			if (!answer.startsWith("Y")) {
				continueGame = false;
			}
		}
		input.close();
		
	}

}
