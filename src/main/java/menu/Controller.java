package menu;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    public static final int MIN_COACH_NUMBER = 2;
    public static final int MAX_COACH_NUMBER = 5;
    public static final String INVALID_COACH_NUMBER_MESSAGE = "[ERROR] 코치는 최소 2명, 최대 5명까지 입력 가능 합니다.";
    public static final String COMMA = ",";
    private final InputView inputView;

    private CoachRepository coachRepository;

    public Controller(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        setCoachName();
        setCoachDislikeFood();
    }

    private void setCoachName() {
        inputView.printStartMessage();
        String input = inputView.readCoachNames();
        String[] coachNames = input.split(COMMA);

        if (coachNames.length < MIN_COACH_NUMBER || coachNames.length > MAX_COACH_NUMBER) {
            throw new IllegalArgumentException(INVALID_COACH_NUMBER_MESSAGE);
        }

        List<Coach> coaches = new ArrayList<>();
        for (String coachName : coachNames) {
            coaches.add(new Coach(coachName.trim()));
        }
        coachRepository = new CoachRepository(coaches);
    }

    private void setCoachDislikeFood() {
        List<Coach> coaches = coachRepository.getCoaches();
        for (Coach coach : coaches) {
            String input = inputView.readDislikeFoods(coach.getName());
            if (!input.isEmpty()) {
                String[] dislikeFoods = input.trim().split(COMMA);
                coach.addDislikeFood(dislikeFoods);
            }
        }
    }
}
