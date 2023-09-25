package menu.domain;

import menu.Controller;

import java.util.EnumMap;
import java.util.Map;

public class CategoryResult {
    private static final Map<Days, Category> result = new EnumMap<>(Days.class);

    public void setCategory(Days days, Category category) {
        validateNumberOfCategory(category);
        result.put(days, category);
    }

    public static Map<Days, Category> getResult() {
        return result;
    }

    private void validateNumberOfCategory(Category category) {
        long count = result.values().stream()
                .filter(value -> value.equals(category))
                .count();
        if (count > 2) {
            Controller.recommendStatus = RecommendStatus.INVALID;
        }
    }
}
