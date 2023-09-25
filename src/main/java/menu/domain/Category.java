package menu.domain;

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
}
