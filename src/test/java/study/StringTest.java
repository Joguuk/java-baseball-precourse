package study;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @DisplayName("1,2를 ,로 split 했을 때 1과 2로 분리되는지 확인한다")
    @Test
    void contains_test() {
        String junitTestInputString = "1,2";
        String[] splitString = junitTestInputString.split(",");
        assertThat(splitString).contains("1","2");
    }

    @DisplayName("1을 ,로 split 했을 때 1만을 포함하는 배열을 반환하는지 확인한다")
    @Test
    void containsExactly_test() {
        String junitTestInputString = "1";
        String[] splitString = junitTestInputString.split(",");
        assertThat(splitString).containsExactly("1");
    }

    @DisplayName("(1,2) substring 메소드를 통해 1,2만 반환하도록 구현하고 확인한다")
    @Test
    void substring_test() {
        String junitTestInputString = "(1,2)";
        String substring = junitTestInputString.substring(1, 4);
        assertThat(substring).isEqualTo("1,2");
    }

    @DisplayName("String의 charAt 메소드를 통해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException가 발생하는 것을 확인한다.")
    @Test
    void string_StringIndexOutOfBoundsException_test() {
        String junitTestInputString = "abc";
        assertThatThrownBy(() -> {
            for (int i = 0; i <= 3; i++) {
                junitTestInputString.charAt(i);
            }
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("out of range: 3");
    }
}
