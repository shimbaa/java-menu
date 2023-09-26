package menu.domain;

import menu.Controller;

import java.util.*;

public class Coach {

    private static final int MIN_NAME_SIZE = 2;
    private static final int MAX_NAME_SIZE = 4;
    private static final String INVALID_NAME_SIZE_MESSAGE = "[ERROR] 코치의 이름은 최소 2글자, 최대 4글자 이어야 합니다.";
    private final String name;

    private List<String> dislikeFoods;

    private final Map<Days, String> menuOfWeek = new EnumMap<>(Days.class);

    public Coach(String name) {
        validateName(name);
        this.name = name;
    }

    public void setMenuOfADay(Days day, String menu) {
        if (dislikeFoods != null && dislikeFoods.contains(menu) || menuOfWeek.containsValue(menu)) {
            Controller.recommendStatus = RecommendStatus.INVALID;
        }
        menuOfWeek.put(day, menu);
    }

    public String getName() {
        return name;
    }

    public Map<Days, String> getMenuOfWeek() {
        return menuOfWeek;
    }

    public void setDislikeFood(List<String> foods) {
        dislikeFoods = foods;
    }

    private void validateName(String name) {
        if (name.length() < MIN_NAME_SIZE || name.length() > MAX_NAME_SIZE) {
            throw new IllegalArgumentException(INVALID_NAME_SIZE_MESSAGE);
        }
    }
}
