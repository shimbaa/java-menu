package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.domain.Coach;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


public class InputView {

    private static final int MIN_COACH_NUMBER = 2;
    private static final int MAX_COACH_NUMBER = 5;
    private static final int MAX_DISLIKE_FOOD_SIZE = 2;
    private static final String INVALID_COACH_NUMBER_MESSAGE = "[ERROR] 코치는 최소 2명, 최대 5명까지 입력 가능 합니다.";
    private static final String INVALID_DISLIKE_FOOD_SIZE = "[ERROR] 먹지 못하는 메뉴는 최대 2개 까지만 가능 합니다.";
    private static final String COMMA = ",";


    private enum ConsoleMessage {
        START("점심 메뉴 추천을 시작합니다.\n"),
        COACH_NAME("코치의 이름을 입력해 주세요. (, 로 구분)"),
        DISLIKE_FOOD("(이)가 못 먹는 메뉴를 입력해 주세요.");

        private final String message;

        ConsoleMessage(String message) {
            this.message = message;
        }
    }

    public void printStartMessage() {
        System.out.println(ConsoleMessage.START.message);
    }

    public List<Coach> getCoaches() {
        try {
            System.out.println(ConsoleMessage.COACH_NAME.message);
            String input = readInput();
            String[] names = input.split(COMMA);

            validateCoachSize(names);

            return toCoaches(names);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return getCoaches();
        }
    }

    public List<String> getDislikeFoods(String coachName) {
        try {
            System.out.println(coachName + ConsoleMessage.DISLIKE_FOOD.message);
            String input = readInput();
            if (input.isEmpty()) {
                return Collections.emptyList(); // 처음 본다. 이걸 이상황에 쓰는거 좋은 것인가?
            }
            String[] foods = input.split(COMMA);
            validateDislikeFoodSize(foods);
            return toFoodList(foods);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return getDislikeFoods(coachName);
        }
    }

    private List<Coach> toCoaches(String[] names) {
        return Arrays.stream(names)
                .map(String::trim)
                .map(Coach::new)
                .collect(Collectors.toList());
    }

    private void validateCoachSize(String[] names) {
        if (names.length < MIN_COACH_NUMBER || names.length > MAX_COACH_NUMBER) {
            throw new IllegalArgumentException(INVALID_COACH_NUMBER_MESSAGE);
        }
    }

    private List<String> toFoodList(String[] foods) {
        return Arrays.stream(foods)
                .map(String::trim)
                .collect(Collectors.toList());
    }

    private void validateDislikeFoodSize(String[] foods) {
        if (foods.length > MAX_DISLIKE_FOOD_SIZE) {
            throw new IllegalArgumentException(INVALID_DISLIKE_FOOD_SIZE);
        }
    }

    private String readInput() {
        return Console.readLine();
    }
}
