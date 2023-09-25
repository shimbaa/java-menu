package menu;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CoachTest {

    @Test
    @DisplayName("코치 이름 글자 수 테스트")
    void coachNameSizeValidationTest() {
        Assertions.assertThatThrownBy(() -> new Coach("abcde"))
                .hasMessageContaining("[ERROR] 코치의 이름은 최소 2글자, 최대 4글자 이어야 합니다.");

        Assertions.assertThatThrownBy(() -> new Coach("a"))
                .hasMessageContaining("[ERROR] 코치의 이름은 최소 2글자, 최대 4글자 이어야 합니다.");
    }
}
