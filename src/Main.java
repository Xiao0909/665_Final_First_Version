//import java.util.Random;
//import java.util.Scanner;
//
//public class ConsoleHangmanView implements HangmanView {
//    private final Scanner scanner;
//
//    public ConsoleHangmanView() {
//        scanner = new Scanner(System.in);
//    }
//
//    @Override
//    public char getGuess() {
//        System.out.print("Guess a letter: ");
//        String input = scanner.nextLine();
//        while (input.length() != 1) {
//            System.out.print("Please enter a single letter: ");
//            input = scanner.nextLine();
//        }
//        return input.charAt(0);
//    }
//
//    @Override
//    public void update(String word, String guessedLetters, int guessesLeft) {
//        System.out.println("Word: " + getWordDisplay(word, guessedLetters));
//        System.out.println("Guessed letters: " + guessedLetters);
//        System.out.println("Guesses left: " + guessesLeft);
//    }
//
//    @Override
//    public void showResult(boolean win) {
//        if (win) {
//            System.out.println("Congratulations, you won!");
//        } else {
//            System.out.println("Game over, you lost!");
//        }
//    }
//
//    private String getWordDisplay(String word, String guessedLetters) {
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < word.length(); i++) {
//            char c = word.charAt(i);
//            if (guessedLetters.indexOf(c) >= 0) {
//                sb.append(c);
//            } else {
//                sb.append("_");
//            }
//            sb.append(" ");
//        }
//        return sb.toString();
//    }
//}
//
//public class DefaultHangmanModel implements HangmanModel {
//    private static final String[] WORDS = {"java", "programming", "computer", "algorithm", "software"};
//
//    @Override
//    public String getRandomWord() {
//        Random random = new Random();
//        return WORDS[random.nextInt(WORDS.length)];
//    }
//}
//
//public class Hangman {
//    private final HangmanController controller;
//
//    public Hangman(HangmanControllerBuilder builder) {
//        controller = builder.build();
//    }
//
//    public void play() {
//        controller.play();
//    }
//
//    public static void main(String[] args) {
//        HangmanControllerBuilder builder = new HangmanControllerBuilder();
//        Hangman game = new Hangman(builder);
//        game.play();
//    }
//}
//
//
//public class HangmanController {
//    private final HangmanModel model;
//    private final HangmanView view;
//    private String word;
//    private int guessesLeft;
//    private StringBuilder guessedLetters;
//
//    public HangmanController(HangmanModel model, HangmanView view) {
//        this.model = model;
//        this.view = view;
//    }
//
//    public void play() {
//        initialize();
//        while (!isGameOver()) {
//            char guess = view.getGuess();
//            update(guess);
//            view.update(word, guessedLetters.toString(), guessesLeft);
//        }
//        view.showResult(isWin());
//    }
//
//    private void initialize() {
//        word = model.getRandomWord();
//        guessesLeft = 6;
//        guessedLetters = new StringBuilder();
//    }
//
//    private boolean isGameOver() {
//        return guessesLeft == 0 || isWin();
//    }
//
//    private boolean isWin() {
//        for (int i = 0; i < word.length(); i++) {
//            if (guessedLetters.indexOf(word.charAt(i) + "") < 0) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    private void update(char guess) {
//        if (word.indexOf(guess) >= 0) {
//            guessedLetters.append(guess);
//        } else {
//            guessesLeft--;
//        }
//    }
//}
//
//public class HangmanControllerBuilder {
//    public HangmanController build() {
//        HangmanModel model = new DefaultHangmanModel();
//        HangmanView view = new ConsoleHangmanView();
//        return new HangmanController(model, view);
//    }
//}
//
//public interface HangmanModel {
//    String getRandomWord();
//}
//
//
//public interface HangmanView {
//    char getGuess();
//    void update(String word, String guessedLetters, int guessesLeft);
//    void showResult(boolean win);
//}
//
//
//
//
