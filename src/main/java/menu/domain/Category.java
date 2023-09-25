package menu.domain;

import java.util.Arrays;

public enum Category {
    JAPANESE("일식", 1),
    KOREAN("한식", 2),
    CHINESE("중식", 3),
    ASIAN("아시안", 4),
    WESTERN("양식", 5);

    private final String label;
    private final int number;

    Category(String label, int number) {
        this.label = label;
        this.number = number;
    }

    public static Category get(int number) {
        return Arrays.stream(values())
                .filter(value -> value.number == number)
                .findAny()
                .orElseThrow(() -> new IllegalStateException("[ERROR] 난수 생성이 잘못 되었습니다."));
    }
}
