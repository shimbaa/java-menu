package menu;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.Category;
import menu.domain.Menu;

public class RecommendService {

    Menu menu = new Menu();

    public String getRandomMenu() {
        Category category = getRandomCategory();
        return menu.getRandomMenuOf(category);
    }

    public Category getRandomCategory() {
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
