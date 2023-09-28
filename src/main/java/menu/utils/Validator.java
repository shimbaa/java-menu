package menu.utils;

public class Validator {

    private static final int MIN_COACH_NUMBER = 2;
    private static final int MAX_COACH_NUMBER = 5;
    private static final int MAX_DISLIKE_FOOD_SIZE = 2;
    private static final String INVALID_COACH_NUMBER_MESSAGE = "[ERROR] 코치는 최소 2명, 최대 5명까지 입력 가능 합니다.";
    private static final String INVALID_DISLIKE_FOOD_SIZE = "[ERROR] 먹지 못하는 메뉴는 최대 2개 까지만 가능 합니다.";

    public static void validateCoachSize(String[] names) {
        if (names.length < MIN_COACH_NUMBER || names.length > MAX_COACH_NUMBER) {
            throw new IllegalArgumentException(INVALID_COACH_NUMBER_MESSAGE);
        }
    }

    public static void validateDislikeFoodSize(String[] foods) {
        if (foods.length > MAX_DISLIKE_FOOD_SIZE) {
            throw new IllegalArgumentException(INVALID_DISLIKE_FOOD_SIZE);
        }
    }
}
