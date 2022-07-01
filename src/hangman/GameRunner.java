package hangman;


public class GameRunner {

    private final Game game;

    /**
     * Construct the GameRunner with an implementation of
     * the Game interface.
     *
     * @param game
     */
    public GameRunner(Game game) {
        this.game = game;
    }

    /**
     * This main method constructs a GameRunner instance and
     * plays the registered game.
     *
     * @param args
     */
    public static void main(String[] args) {
        // Instantiate the GameRunner with an instance of the Game of your
        // choice.  Here I choose the HangmanGame.
        GameRunner gameRunner = new GameRunner(new HangmanGame());
        gameRunner.playGame();
    }

    /**
     * Once the runner has been initialized with a HangmanGame
     * (an implementation of the interface) we can run against the
     * interface.
     */
    void playGame() {
        try {
            game.initializeProgram();
            game.greetings();

            boolean playAnotherGame = false;
            do {
                game.initializeGame();
                char nextMove = game.whoMovesFirst();

                boolean gameOver = false;
                do {
                    if ('C' == nextMove) {
                        gameOver = game.computerMove();
                        nextMove = 'U';
                    } else {
                        gameOver = game.userMove();
                        nextMove = 'C';
                    }
                }
                while (!gameOver);

                playAnotherGame = game.playAgain();
            }
            while (playAnotherGame);

            game.endProgram();
        } catch (Exception e) {
            System.out.println("An error occured: " + e);
            e.printStackTrace(System.out);
        }
    }

}