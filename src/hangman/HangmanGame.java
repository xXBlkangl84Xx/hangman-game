package hangman;

import java.util.*;

public class HangmanGame implements Game {
        public static List<String> correctWordList;

	Scanner playerInput = new Scanner(System.in);

	private static String[] words = { "geography", "superman", "yesterday", "java", "truck", "opportunity", "fish",
			"token", "transportation", "bottom", "zamboni", "cake", "remote", "pocket", "terminology", "arm",
			"cranberry", "tool", "caterpillar", "spoon", "watermelon", "laptop", "programming", "toad", "fundamental",
			"capitol", "garbage", "anticipate", "apples" };
	
	private static String correctWord;
	
	private static int badGuesses;
	
	
	private static List<String> shuffledWord(List<String> correctWordList) {
		
		for (int i = 0 ; i < correctWordList.size() ; i++) {
			System.out.print(correctWordList.get(i));
                }
                return correctWordList;
	}
	
	private void printHangman(int badGuesses) {
		int poleLines = 6;  
		System.out.println("  ____");
		System.out.println("  |  |");
		
		if (badGuesses == 7) {
			System.out.println("  |  |");
			System.out.println("  |  |");
		}
		if (badGuesses > 0) {	    	   
			System.out.println("  |  O");
			poleLines = 5;
		}
		if (badGuesses > 1) {
			poleLines = 4;
			if (badGuesses == 2) {
				System.out.println("  |  |");
			} else if (badGuesses == 3) {
				System.out.println("  | \\|");
			} else if (badGuesses >= 4) {
				System.out.println("  | \\|/");
			}
		}
		if (badGuesses > 4) {
			poleLines = 3;
			if (badGuesses == 5) {
				System.out.println("  | /");
			} else if (badGuesses == 6) {
				System.out.println("  | / \\");
			}
		}
		if (badGuesses == 7) {
			poleLines = 1;
		}

		for (int k = 0; k < poleLines; k++) {
			System.out.println("  |");
		}
		System.out.println("__|__");
		System.out.println();
	}

	
	public void initializeProgram() {	
		
		
		//Gallows.gallows();
		
		
	}
	





	public class Bruce {
		
//		public static void main(String[] args) {
//			drawBruce();
//		}
		
		public static void drawBruce() {
			System.out.println("   ___  ");
			System.out.println(" / . . \\");
			System.out.println(" | ___ | " );
			System.out.println("  \\___/ " );
			System.out.println("    | " );
			System.out.println("   /|\\ " );
			System.out.println("  / | \\" );
			System.out.println(" O" + "  |" + "  O" );
			System.out.println("    | " );
			System.out.println("   / \\ " );
			System.out.println("  /   \\ ");
			System.out.println("_/     \\_ ");		
		}

	


}

	
	
	
	
	public void greetings() {
		System.out.println("Welcome to Patrick and Aaron's Hangman Game!");
		System.out.println("This is Bruce: ");
		Bruce.drawBruce();
		System.out.println("Bruce is going to be noosed. Can you save Bruce?");
		System.out.println("The rules are simple: A random word will be chosen, scrambled, and then displayed to you. You have 6 tries to guess the scrambled word, anymore than that and Bruce won't be seeing his family again. Good luck! ");
	}

	public void initializeGame() {
//		Gallows.gallows();
		Random randIndex = new Random();
		int index = randIndex.nextInt(HangmanGame.words.length);
		correctWord = HangmanGame.words[index];
		String[] correctWordArray = correctWord.split("");
		
		ArrayList<String> correctWordList = new ArrayList<String>(); 
		for(int i = 0; i < correctWordArray.length;i++) {
			correctWordList.add(correctWordArray[i]);
		}
		
		Collections.shuffle(correctWordList);
				
	}

	public char whoMovesFirst() {
		Random num = new Random();
		int num1 = num.nextInt(2);
		char first = 'C';	
		switch (num1) {
		case 0:
			first = 'C';
			break;
		case 1:
			first = 'U';
			break;
		}
		return first;
	}

	
	
	public boolean computerMove() {
//		boolean result = false;
				
//		if (userGuess != correctWord) {
//			badGuesses++;
//			System.out.print("Nope!");
//			printHangman(badGuesses);
//		}
//		System.out.print("Bruce isn't doing too hot. You have " + (6-badGuesses) + " guesses left!");
		
		return false;
	}

	public boolean userMove() {
		boolean result = false;
		printHangman(badGuesses);
		System.out.println(shuffledWord(HangmanGame.correctWordList));		
		System.out.print("What is the word? ");
		String userGuess = playerInput.nextLine();
		if (userGuess == correctWord) {
			System.out.println("That's it! Nice job!");
			result = true;	
		}else{
			badGuesses++;
			System.out.print("Nope!");
			printHangman(badGuesses);
		}
		System.out.print("Bruce isn't doing too hot. You have " + (6-badGuesses) + " guesses left!");
		return result;
	}

	
	
	public boolean playAgain() {
		System.out.println("Would you like to play again? Enter 1 for yes or 0 for no. ");
		boolean response = playerInput.hasNext();
		return response;
	}

	public void endProgram() {
		playerInput.close();
		System.out.println("Thank you for playing! Goodbye!");
	}

}
