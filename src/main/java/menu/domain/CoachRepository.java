package menu.domain;

import java.util.List;

public class CoachRepository {

    private final List<Coach> coaches;

    public CoachRepository(List<Coach> coaches) {
        this.coaches = coaches;
    }

    public List<Coach> getCoaches() {
        return coaches;
    }
}
