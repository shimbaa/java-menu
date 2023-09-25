package menu.domain;

public enum Days {
    MON("월요일"),
    TUE("화요일"),
    WED("수요일"),
    THU("목요일"),
    FRI("금요일");

    private final String label;

    Days(String label) {
        this.label = label;
    }
}
