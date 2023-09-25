package menu.view;

import menu.domain.CategoryResult;
import menu.domain.Coach;
import menu.domain.Category;
import menu.domain.Days;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public class OutputView {
    private enum ConsoleMessage {
        RESULT_MESSAGE("메뉴 추천 결과입니다."),
        SEPARATION_START("[ 구분 "),
        CATEGORY_START("[ 카테고리 "),
        NAME_START("[ "),
        END_FORMAT("]"),
        COMPLETE_MESSAGE("\n추천을 완료했습니다.");

        private final String format;

        ConsoleMessage(String format) {
            this.format = format;
        }
    }

    public void printResult(List<Coach> coaches) {
        System.out.println(ConsoleMessage.RESULT_MESSAGE.format);
        System.out.println(ConsoleMessage.SEPARATION_START.format + getDaysFormat() + ConsoleMessage.END_FORMAT.format);
        System.out.println(ConsoleMessage.CATEGORY_START.format + getCategoryFormat() + ConsoleMessage.END_FORMAT.format);
        for (Coach coach : coaches) {
            System.out.println(ConsoleMessage.NAME_START.format + getCoachMenuFormat(coach) + ConsoleMessage.END_FORMAT.format);
        }
        System.out.println(ConsoleMessage.COMPLETE_MESSAGE.format);
    }

    private StringBuilder getDaysFormat() {
        StringBuilder format = new StringBuilder();

        Days[] days = Days.values();
        for (Days day : days) {
            format.append("| ").append(day.getLabel()).append(" ");
        }
        return format;
    }

    private StringBuilder getCategoryFormat() {
        StringBuilder format = new StringBuilder();

        Map<Days, Category> result = CategoryResult.getResult();
        Collection<Category> values = result.values();

        for (Category value : values) {
            format.append("| ").append(value.getLabel()).append(" ");
        }
        return format;
    }

    private StringBuilder getCoachMenuFormat(Coach coach) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(coach.getName()).append(" ");
        Map<Days, String> menuOfWeek = coach.getMenuOfWeek();
        for (String value : menuOfWeek.values()) {
            stringBuilder.append("| ").append(value).append(" ");
        }
        return stringBuilder;
    }
}
