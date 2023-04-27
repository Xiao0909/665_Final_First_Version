import java.util.Random;

public class DefaultHangmanModel implements HangmanModel {
    private static final String[] WORDS = {"java", "programming", "computer", "algorithm", "software"};

    @Override
    public String getRandomWord() {
        Random random = new Random();
        return WORDS[random.nextInt(WORDS.length)];
    }
}
