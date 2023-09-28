package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.utils.Convertor;
import menu.utils.Validator;
import menu.domain.Coach;

import java.util.Collections;
import java.util.List;


public class InputView {
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
            //===========//
            String[] names = Convertor.splitSentenceByComma(input);
            Validator.validateCoachSize(names);
            return Convertor.toCoaches(names);
            //===========//
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
            //===========//
            String[] foods = Convertor.splitSentenceByComma(input);
            Validator.validateDislikeFoodSize(foods);
            return Convertor.toFoodList(foods);
            //===========//
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return getDislikeFoods(coachName);
        }
    }

    private String readInput() {
        return Console.readLine();
    }
}
