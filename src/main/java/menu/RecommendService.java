package menu;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.Category;

public class RecommendService {

    public Category getCategoryByRandomNumber() {
        int randomNumber = getRandomNumber();
        return getCategoryByNumber(randomNumber);
    }

    protected Category getCategoryByNumber(int number) {
        return Category.get(number);
    }

    private int getRandomNumber() {
        return Randoms.pickNumberInRange(1, 5);
    }
}
