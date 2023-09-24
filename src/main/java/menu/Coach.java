package menu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Coach {

    public static final int MIN_NAME_SIZE = 2;
    public static final int MAX_NAME_SIZE = 4;
    public static final String INVALID_NAME_SIZE_MESSAGE = "[ERROR] 코치의 이름은 최소 2글자, 최대 4글자 이어야 합니다.";
    public static final String INVALID_DISLIKE_FOOD_SIZE = "[ERROR] 먹지 못하는 메뉴는 최대 2개 까지만 가능 합니다.";
    public static final int MAX_DISLIKE_FOOD_SIZE = 2;
    private final String name;

    private List<String> dislikeFoods;

    public Coach(String name) {
        validateName(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addDislikeFood(String[] input) {
        validateDislikeFood(input);
        dislikeFoods = new ArrayList<>(Arrays.asList(input));
    }

    private void validateName(String name) {
        if (name.length() < MIN_NAME_SIZE || name.length() > MAX_NAME_SIZE) {
            throw new IllegalArgumentException(INVALID_NAME_SIZE_MESSAGE);
        }
    }

    private void validateDislikeFood(String[] input) {
        if (input.length > MAX_DISLIKE_FOOD_SIZE) {
            throw new IllegalArgumentException(INVALID_DISLIKE_FOOD_SIZE);
        }
    }
}
