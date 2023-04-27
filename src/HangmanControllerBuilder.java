public class HangmanControllerBuilder {
    public HangmanController build() {
        HangmanModel model = new DefaultHangmanModel();
        HangmanView view = new ConsoleHangmanView();
        return new HangmanController(model, view);
    }
}
