public class Hangman {
    private final HangmanController controller;

    public Hangman(HangmanControllerBuilder builder) {
        controller = builder.build();
    }

    public void play() {
        controller.play();
    }

    public static void main(String[] args) {
        HangmanControllerBuilder builder = new HangmanControllerBuilder();
        Hangman game = new Hangman(builder);
        game.play();
    }
}
