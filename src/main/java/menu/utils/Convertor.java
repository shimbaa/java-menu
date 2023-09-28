package menu.utils;

import menu.domain.Coach;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Convertor {
    private static final String COMMA = ",";

    public static String[] splitSentenceByComma(String input) {
        return input.split(COMMA);
    }

    public static List<Coach> toCoaches(String[] names) {
        return Arrays.stream(names)
                .map(String::trim)
                .map(Coach::new)
                .collect(Collectors.toList());
    }

    public static List<String> toFoodList(String[] foods) {
        return Arrays.stream(foods)
                .map(String::trim)
                .collect(Collectors.toList());
    }
}
