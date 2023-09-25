package menu;

import menu.domain.Category;
import menu.domain.Days;

import java.util.EnumMap;
import java.util.Map;

public class CategoryResult {
    private static Map<Days, Category> result = new EnumMap<>(Days.class);

    public void setCategory(Days days, Category category) {
        validateNumberOfCategory(category);
        result.put(days, category);
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
