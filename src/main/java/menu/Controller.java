package menu;

public class Controller {

    private final InputView inputView;

    public Controller(InputView inputView) {
        this.inputView = inputView;
    }

    public void setCoaches() {
        inputView.printStartMessage();
        String coaches = inputView.readCoachNames();
    }
}
