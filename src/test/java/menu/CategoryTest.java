package menu;

import menu.domain.Category;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CategoryTest {

    @Test
    void categoryByNumber() {
        Assertions.assertThat(Category.get(1)).isEqualTo(Category.JAPANESE);
        Assertions.assertThat(Category.get(2)).isEqualTo(Category.KOREAN);
        Assertions.assertThat(Category.get(3)).isEqualTo(Category.CHINESE);
        Assertions.assertThat(Category.get(4)).isEqualTo(Category.ASIAN);
        Assertions.assertThat(Category.get(5)).isEqualTo(Category.WESTERN);
    }
}
