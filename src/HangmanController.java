public class HangmanController {
    private final HangmanModel model;
    private final HangmanView view;
    private String word;
    private int guessesLeft;
    private StringBuilder guessedLetters;

    public HangmanController(HangmanModel model, HangmanView view) {
        this.model = model;
        this.view = view;
    }

    public void play() {
        initialize();
        while (!isGameOver()) {
            char guess = view.getGuess();
            update(guess);
            view.update(word, guessedLetters.toString(), guessesLeft);
        }
        view.showResult(isWin());
    }

    private void initialize() {
        word = model.getRandomWord();
        guessesLeft = 6;
        guessedLetters = new StringBuilder();
    }

    private boolean isGameOver() {
        return guessesLeft == 0 || isWin();
    }

    private boolean isWin() {
        for (int i = 0; i < word.length(); i++) {
            if (guessedLetters.indexOf(word.charAt(i) + "") < 0) {
                return false;
            }
        }
        return true;
    }

    private void update(char guess) {
        if (word.indexOf(guess) >= 0) {
            guessedLetters.append(guess);
        } else {
            guessesLeft--;
        }
    }
}
