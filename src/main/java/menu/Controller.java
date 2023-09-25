package menu;

import menu.view.InputView;
import menu.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    private static final int MIN_COACH_NUMBER = 2;
    private static final int MAX_COACH_NUMBER = 5;
    private static final String INVALID_COACH_NUMBER_MESSAGE = "[ERROR] 코치는 최소 2명, 최대 5명까지 입력 가능 합니다.";
    private static final String COMMA = ",";

    public static RecommendStatus recommendStatus;
    private final InputView inputView;
    private final OutputView outputView;
    private CoachRepository coachRepository;

    private RecommendService recommendService = new RecommendService();

    public Controller(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        setCoachName();
        setCoachDislikeFood();

        do {
            recommendService.recommend(coachRepository.getCoaches());
        }
        while (recommendStatus == RecommendStatus.INVALID);

        List<Coach> coaches = coachRepository.getCoaches();
        outputView.printResult(coaches);
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
