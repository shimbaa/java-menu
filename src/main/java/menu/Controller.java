package menu;

import menu.domain.Coach;
import menu.domain.CoachRepository;
import menu.domain.RecommendStatus;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.List;

public class Controller {

    public static RecommendStatus recommendStatus;
    private final InputView inputView;
    private final OutputView outputView;
    private CoachRepository coachRepository;

    private final RecommendService recommendService = new RecommendService();

    public Controller(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        inputView.printStartMessage();
        setCoachName();
        setCoachDislikeFood();

        do {
            recommendService.recommend(coachRepository.getCoaches());
        } while (recommendStatus == RecommendStatus.INVALID);

        List<Coach> coaches = coachRepository.getCoaches();
        outputView.printResult(coaches);
    }

    private void setCoachName() {
        List<Coach> coaches = inputView.getCoaches();
        coachRepository = new CoachRepository(coaches);
    }

    private void setCoachDislikeFood() {
        List<Coach> coaches = coachRepository.getCoaches();
        for (Coach coach : coaches) {
            String input = inputView.readDislikeFoods(coach.getName());
            if (!input.isEmpty()) {
                String[] dislikeFoods = input.trim().split(",");
                coach.addDislikeFood(dislikeFoods);
            }
        }
    }
}
