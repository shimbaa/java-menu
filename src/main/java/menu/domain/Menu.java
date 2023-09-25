package menu.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Menu {
    private static final Map<Category, List<String>> menu = new EnumMap<>(Category.class);

    private static final String[] JAPANESE_MENU = {"규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼"};
    private static final String[] KOREAN_MENU = {"김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음"};
    private static final String[] CHINESE_MENU = {"깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채"};
    private static final String[] ASIAN_MENU = {"팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜"};
    private static final String[] WESTERN_MENU = {"라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니"};

    public static void initMenu() {
        menu.put(Category.JAPANESE, Arrays.asList(JAPANESE_MENU));
        menu.put(Category.KOREAN, Arrays.asList(KOREAN_MENU));
        menu.put(Category.CHINESE, Arrays.asList(CHINESE_MENU));
        menu.put(Category.ASIAN, Arrays.asList(ASIAN_MENU));
        menu.put(Category.WESTERN, Arrays.asList(WESTERN_MENU));
    }
}
