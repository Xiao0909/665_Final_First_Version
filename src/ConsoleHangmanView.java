import java.util.Scanner;

public class ConsoleHangmanView implements HangmanView {
    private final Scanner scanner;

    public ConsoleHangmanView() {
        scanner = new Scanner(System.in);
    }

    @Override
    public char getGuess() {
        System.out.print("Guess a letter: ");
        String input = scanner.nextLine();
        while (input.length() != 1) {
            System.out.print("Please enter a single letter: ");
            input = scanner.nextLine();
        }
        return input.charAt(0);
    }

    @Override
    public void update(String word, String guessedLetters, int guessesLeft) {
        System.out.println("Word: " + getWordDisplay(word, guessedLetters));
        System.out.println("Guessed letters: " + guessedLetters);
        System.out.println("Guesses left: " + guessesLeft);
    }

    @Override
    public void showResult(boolean win) {
        if (win) {
            System.out.println("Congratulations, you won!");
        } else {
            System.out.println("Game over, The man was died!");
        }
    }

    private String getWordDisplay(String word, String guessedLetters) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (guessedLetters.indexOf(c) >= 0) {
                sb.append(c);
            } else {
                sb.append("_");
            }
            sb.append(" ");
        }
        return sb.toString();
    }
}
