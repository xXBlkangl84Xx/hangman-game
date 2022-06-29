package hangman;

/**
 * A simple game interface for a one person 
 * versus a computer game.
 * 
 * @author steve.maniak
 */
public interface Game {

	/** 
	 * Any system startup and initialization are done here. 
	 */
	void initializeProgram();

	/**
	 * Usually games start with a "Greetings" page.  It could also have brief instructions 
	 * on how to play.
	 */
	void greetings();

	/** 
	 * Any game startup and initialization are done here. 
	 * Might also be an initial board.
	 */
	void initializeGame();
	
	/**
	 * Who gets the first move?  The "C"omputer or "U"ser?
	 * @return a 'C' or 'U'
	 */
	char whoMovesFirst();
	
	/**
	 * The computer makes a move.  
	 * Internally it should handle any win/lose/draw conditions and messages.
	 * @return true to indicate game is over.
	 */
	boolean computerMove();

	/**
	 * The user makes a move.  
	 * Internally it should handle any win/lose/draw conditions and messages.
	 * @return true to indicate game is over.
	 */
	boolean userMove();

	/**
	 * Does the user want to play again?
	 * @return true to indicate another game is requested
	 */
	boolean playAgain();

	/** 
	 * Any system cleanup (free any resources) are done here. 
	 */
	void endProgram();

}