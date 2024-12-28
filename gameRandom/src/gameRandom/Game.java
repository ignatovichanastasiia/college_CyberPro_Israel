package gameRandom;

import java.util.Scanner;

public class Game {

	public static void main(String[] args) {
		System.out.println("It is a game. Guess the number!");
		Scanner sc = new Scanner(System.in);
		double random = Math.random()*100;
		double gamersNum = 0;
		do {
			System.out.println("Your chance. Enter the number: ");
			try {
				gamersNum = sc.nextDouble();
			}catch(Exception e) {
				System.out.println("You finished the game");
				break;
			}
			
			if(random!=gamersNum) {
				System.out.println("It is not the same.");
			}else {
				System.out.println("You win!");
			}
		}while(random!= gamersNum);
		System.out.println("That is all");

	}

}
