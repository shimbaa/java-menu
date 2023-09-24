package menu;

public class Controller {

    public static final int MIN_COACH_NUMBER = 2;
    public static final int MAX_COACH_NUMBER = 5;
    public static final String INVALID_COACH_NUMBER_MESSAGE = "[ERROR] 코치는 최소 2명, 최대 5명까지 입력 가능 합니다.";
    private final InputView inputView;

    public Controller(InputView inputView) {
        this.inputView = inputView;
    }

    public void setCoaches() {
        inputView.printStartMessage();
        String input = inputView.readCoachNames();
        String[] coachNames = input.trim().split(",");
        if (coachNames.length < MIN_COACH_NUMBER || coachNames.length > MAX_COACH_NUMBER) {
            throw new IllegalArgumentException(INVALID_COACH_NUMBER_MESSAGE);
        }
    }
}
