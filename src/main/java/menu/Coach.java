package menu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Coach {

    public static final int MIN_NAME_SIZE = 2;
    public static final int MAX_NAME_SIZE = 4;
    public static final String INVALID_NAME_SIZE_MESSAGE = "[ERROR] 코치의 이름은 최소 2글자, 최대 4글자 이어야 합니다.";
    private final String name;

    private List<String> dislikeFoods;

    public Coach(String name) {
        validate(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addDislikeFood(String[] input) {
        dislikeFoods = new ArrayList<>(Arrays.asList(input));
    }

    private void validate(String name) {
        if (name.length() < MIN_NAME_SIZE || name.length() > MAX_NAME_SIZE) {
            throw new IllegalArgumentException(INVALID_NAME_SIZE_MESSAGE);
        }
    }
}
