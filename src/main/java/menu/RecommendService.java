package menu;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.Category;
import menu.domain.Days;
import menu.domain.Menu;

import java.util.List;

public class RecommendService {

    private final Menu menu = new Menu();
    private final CategoryResult categoryResult = new CategoryResult();


    public void recommend(List<Coach> coaches) {
        Days[] days = Days.values();
        for (Days day : days) {
            Category category = getRandomCategory();

            setCategoryOf(day, category);
            setCoachesMenu(coaches, day, category);
        }
    }

    private void setCoachesMenu(List<Coach> coaches, Days day, Category category) {
        for (Coach coach : coaches) {
            String randomMenu = getRandomMenu(category);
            coach.setMenuOfADay(day, randomMenu);
        }
    }

    private void setCategoryOf(Days days, Category category) {
        categoryResult.setCategory(days, category);
    }

    public String getRandomMenu(Category category) {
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
