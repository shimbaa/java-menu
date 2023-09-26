package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.domain.Coach;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    private static final int MIN_COACH_NUMBER = 2;
    private static final int MAX_COACH_NUMBER = 5;

    private static final String INVALID_COACH_NUMBER_MESSAGE = "[ERROR] 코치는 최소 2명, 최대 5명까지 입력 가능 합니다.";
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

            validateCoachNumber(names);

            return toCoaches(names);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return getCoaches();
        }
    }

    public String readDislikeFoods(String coachName) {
        System.out.println(coachName + ConsoleMessage.DISLIKE_FOOD.message);
        return Console.readLine();
    }

    private void validateCoachNumber(String[] names) {
        if (names.length < MIN_COACH_NUMBER || names.length > MAX_COACH_NUMBER) {
            throw new IllegalArgumentException(INVALID_COACH_NUMBER_MESSAGE);
        }
    }

    private List<Coach> toCoaches(String[] names) {
        return Arrays.stream(names)
                .map(String::trim)
                .map(Coach::new)
                .collect(Collectors.toList());
    }

    private String readInput() {
        return Console.readLine();
    }
}
