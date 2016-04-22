import java.util.Scanner;

public class pig {
	public static boolean gamefinish = false, playerturn = true, startgame = true;
	public int computerScore = 0,  yourScore = 0;
	public static Scanner kbd = new Scanner(System.in);
	public pig(String name)
	{
		System.out.println("Welcome " + name + " to the game of Dice.");
		System.out.println("Start game?(Y/N)");
		if(kbd.nextLine().equalsIgnoreCase("y")) 
		{
			while(startgame) 
			{
				while(yourScore >= 30 && yourScore > computerScore) 
				{
					System.out.println("The Computer Score is " + computerScore + " and your score is " + yourScore + "."); 
					System.out.println("Congratulations " + name + ", You WON!");
					System.out.println("Would you like to play agian?(Y/N)");
					if(kbd.nextLine().equalsIgnoreCase("y")) {
						computerScore = 0;
						yourScore = 0;
						new pig(name);
					} else {
						System.exit(0);
					}
				}
				while(computerScore >= 30 && computerScore > yourScore) {
					System.out.println("The Computer's Score is " + computerScore + " and your score is " + yourScore + ".");
					System.out.println("Sorry you lost...computer wins!!!!");
					System.out.println("Would you like to play agian?(Y/N)");
					if(kbd.nextLine().equalsIgnoreCase("y")) {
						computerScore = 0;
						yourScore = 0;
						new pig(name);
					} else {
						System.exit(0);
					}
				}
				while(playerturn) {
					yourScore += new Logic().roll(playerturn);
				}
				while(playerturn != true) {
					computerScore += new Logic().roll(playerturn);
				}
			}
		} else {
			System.exit(0);
		}
	}
	
	public static void main(String args[]) {
		System.out.print("Please enter your name: ");
		new pig(kbd.nextLine());
	}
}

class Logic {
	boolean Keepgoing = true;
	int Rolldice = 0, turnPoints = 0, maxScore = 100;
	Scanner kbd = new Scanner(System.in);
	public int roll(boolean playerturn) {
		if(playerturn) {
			while(Keepgoing) {
				Rolldice = (int)(Math.random() * 6) + 1;
				if(Rolldice == 1 ) {
					System.out.println("Sorry!!!!! you rolled: " + Rolldice);
					System.out.println("Now it's computer's turn:");
					turnPoints= 0;
					pig.playerturn = false;
					Keepgoing = false;
				} else {
					System.out.println("You rolled: " + Rolldice); 
					turnPoints+=Rolldice;
					System.out.println("Please, Press r for roll and h for hold!!!");
					if (kbd.nextLine().equalsIgnoreCase("h")) {
						System.out.println("you pressed hold!!! It is the computer's turn:"); 
						pig.playerturn = false;
						playerturn = false;
						Keepgoing = false;
					}
				}
			}
		} else if (playerturn != true) {
			while(Keepgoing) {
				Rolldice = (int)(Math.random() * 6) + 1;
				if(Rolldice == 1 ) {
					System.out.println("The computer rolled: " + Rolldice);
					turnPoints = 0;
					pig.playerturn = true;
					Keepgoing = false;
				} else {
					System.out.println("The computer rolled: " + Rolldice); 
					turnPoints+=Rolldice;
					if (turnPoints >= 20) { 
						pig.playerturn = true;
						Keepgoing = false;
					}
				}
			}
		}
		return turnPoints;
	}
}
