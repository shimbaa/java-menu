package menu;

import camp.nextstep.edu.missionutils.Console;

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

    public String readCoachNames() {
        System.out.println(ConsoleMessage.COACH_NAME.message);
        return Console.readLine();
    }

    public String readDislikeFoods(String coachName) {
        System.out.println(coachName + ConsoleMessage.DISLIKE_FOOD.message);
        return Console.readLine();
    }
}
