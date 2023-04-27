public interface HangmanView {
    char getGuess();
    void update(String word, String guessedLetters, int guessesLeft);
    void showResult(boolean win);
}
