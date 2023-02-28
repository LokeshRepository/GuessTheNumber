import java.util.Scanner;
import java.util.Random;


class GuessMe {
	
	int systemInput;
	int userInput;
	int noOfGuesses = 0;
	
	
	GuessMe() {							// generate random number 
		Random random = new Random();
		this.systemInput = random.nextInt(100) + 1;
	}
	
	
	
	public boolean takeUserInput() {
		if ( noOfGuesses < 10 ) {
			System.out.print("Guess the number : ");
			this.userInput = GuessTheNumber.takeIntegerInput(100);
			noOfGuesses++;
			return false;
		}
		else {
			System.out.println("Number of attempts finished...\n");
			System.out.println("Better luck next time\n");
			return true;
		}
	}
	
	
	
	public boolean isCorrectGuess() {				//To check User Guess Status
		
		if ( systemInput == userInput ) {
			System.out.println("Congratulations, you guess the number " + systemInput +
			" in " + noOfGuesses + " guesses");
			switch(noOfGuesses) {
				case 1:
				System.out.println("Your score is 10 Points");
				break;
				case 2:
				System.out.println("Your score is 9 Points");
				break;
				case 3:
				System.out.println("Your score is 8 Points");
				break;
				case 4:
				System.out.println("Your score is 7 Points");
				break;
				case 5:
				System.out.println("Your score is 6 Points");
				break;
				case 6:
				System.out.println("Your score is 5 Points");
				break;
				case 7:
				System.out.println("Your score is 4 Points");
				break;
				case 8:
				System.out.println("Your score is 3 Points");
				break;
				case 9:
				System.out.println("Your score is 2 Points");
				break;
				case 10:
				System.out.println("Your score is 1 Points");
				break;
			}
			System.out.println();
			return true;
		}
		else if ( noOfGuesses < 10 && userInput > systemInput ) {
			if ( userInput - systemInput > 10 ) {
				System.out.println("Too High");
			}
			else {
				System.out.println("Close but High");
			}
		}
		else if ( noOfGuesses < 10 && userInput < systemInput ) {
			if ( systemInput - userInput > 10 ) {
				System.out.println("Too low");
			}
			else {
				System.out.println("Close but low");
			}
		}
		return false;
	}
}


public class GuessTheNumber {						// My Main class
	
	
	public static int takeIntegerInput(int limit) {
		int input = 0;
		boolean flag = false;
		
		while ( !flag ) {
			try {
				Scanner sc = new Scanner(System.in);
				input = sc.nextInt();
				flag = true;
				
				if ( flag && input > limit || input < 1 ) {
					System.out.println("Choose the number between 1 to " + limit);
					flag = false;
				}
			}
			catch ( Exception e ) {
				System.out.println("Enter only integer value");
				flag = false;
			}
		};
		return input;
	}
	
	
	public static void main(String[] args) {				// Main Method
		
		
		System.out.println("1. Start the Guess \n2. Exit");
		System.out.print("Enter your choice : ");
		int choice = takeIntegerInput(2);
		int nextRound = 1;
		int noOfRound = 0;
		
		if ( choice == 1 ) {
			
			
			while ( nextRound == 1 ) {				// To check next round is there or not
				// creating object of GuessMe class
				GuessMe GuessMe = new GuessMe();
				boolean isMatched = false;
				boolean isLimitCross = false;
				System.out.println("\nRound " + ++noOfRound + " starts...");
				
				
				while ( !isMatched && !isLimitCross) {
					isLimitCross = GuessMe.takeUserInput();
					isMatched = GuessMe.isCorrectGuess();
				}
				
				System.out.println("1. Next Round \n2. Exit");
				System.out.println("Enter your choice : ");
				nextRound = takeIntegerInput(2);
				if ( nextRound != 1 ) {
					System.exit(0);
				}
			}
		}
		else {
			System.exit(0);
		}
	}
}