package studio2;
import java.util.Scanner;
public class Ruin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("Start amount? ");
		int startAmount = scan.nextInt();
		System.out.println("Win chance? ");
		double winChance = scan.nextDouble();
		System.out.println("Win Limit? ");
		int winLimit = scan.nextInt();
		System.out.println("Total simulations?");
		int totalSimulations = scan.nextInt();
		int ruins = 0;
		double ruinRate;
		double Alpha = (1 - winChance) / winChance;
		double expectedRuinRate;
		
		if (winChance == 0.5) {
			expectedRuinRate = 1 - (startAmount / winLimit);
		}
		else {
			expectedRuinRate = ( (Math.pow(Alpha, startAmount)) - Math.pow(Alpha, winLimit)) / (1 - (Math.pow(Alpha, winLimit)));
		}
		
		int currentAmount = startAmount;
		for (int i = 1; i <= totalSimulations; i++) {
			int numPlays = 0;
		
			while (0<currentAmount&&currentAmount<winLimit) {
				
				if (Math.random()<winChance) {
					currentAmount += 1;
				}
				else {
					currentAmount--;
				}
				
				numPlays++;
				
				if (currentAmount == winLimit) {
					System.out.println("Success!");
				}
				else if(currentAmount == 0) {
					System.out.println("Ruin");
					ruins++;
					}
				
				
			
			
			}
			currentAmount = startAmount;
			System.out.println("Current Day: " + i);
			System.out.println("Number of Plays: " + numPlays);
			System.out.println("");
		}
		ruinRate = ruins / (double)(totalSimulations);
		System.out.println("Ruin Rate: " + ruinRate);
		System.out.println("Expected Ruin Rate: " + expectedRuinRate);
		
	}	
}
