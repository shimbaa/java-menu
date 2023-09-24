package menu;

public class Coach {

    public static final int MIN_NAME_SIZE = 2;
    public static final int MAX_NAME_SIZE = 4;
    public static final String INVALID_NAME_SIZE_MESSAGE = "[ERROR] 코치의 이름은 최소 2글자, 최대 4글자 이어야 합니다.";
    private final String name;

    public Coach(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (name.length() < MIN_NAME_SIZE || name.length() > MAX_NAME_SIZE) {
            throw new IllegalArgumentException(INVALID_NAME_SIZE_MESSAGE);
        }
    }
}
