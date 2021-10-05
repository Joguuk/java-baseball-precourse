package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static baseball.BaseballConstants.NUMBER_OF_BALL;

class BallsTest {

    @DisplayName("여러가지 케이스에 대한 strike 결과를 테스트한다.")
    @ParameterizedTest
    @CsvSource(value = {"135:3", "136:2", "235:2","198:1","567:0"}, delimiter = ':')
    void strike_개수(String input, int expected) {
        Balls balls = new Balls();
        balls.createBall("135");
        balls.initCnt();

        for (int i = 0; i < NUMBER_OF_BALL; i++) {
            balls.checkStrike(i,Character.getNumericValue(input.charAt(i)));
        }

        Assertions.assertThat(balls.getStrikeCnt()).isEqualTo(expected);
    }

    @DisplayName("여러가지 케이스에 대한 ball 결과를 테스트한다.")
    @ParameterizedTest
    @CsvSource(value = {"135:0", "136:0", "235:0","153:2","567:1"}, delimiter = ':')
    void ball_개수(String input, int expected) {
        Balls balls = new Balls();
        balls.createBall("135");
        balls.initCnt();

        for (int i = 0; i < NUMBER_OF_BALL; i++) {
            balls.checkStrike(i,Character.getNumericValue(input.charAt(i)));
        }

        for (int i = 0; i < NUMBER_OF_BALL; i++) {
            balls.checkBall(Character.getNumericValue(input.charAt(i)));
        }

        Assertions.assertThat(balls.getBallCnt()).isEqualTo(expected);
    }

    @DisplayName("여러가지 케이스에 대한 strike와 ball을 함께 결과를 테스트한다.")
    @ParameterizedTest
    @CsvSource(value = {"135:3:0", "136:2:0", "235:2:0","153:1:2","567:0:1"}, delimiter = ':')
    void strikeAndBall_개수(String input, int expectedStrikeCnt, int expectedBallCnt) {
        Balls balls = new Balls();
        balls.createBall("135");
        balls.initCnt();

        for (int i = 0; i < NUMBER_OF_BALL; i++) {
            balls.checkStrike(i,Character.getNumericValue(input.charAt(i)));
        }

        for (int i = 0; i < NUMBER_OF_BALL; i++) {
            balls.checkBall(Character.getNumericValue(input.charAt(i)));
        }

        Assertions.assertThat(balls.getStrikeCnt()).isEqualTo(expectedStrikeCnt);
        Assertions.assertThat(balls.getBallCnt()).isEqualTo(expectedBallCnt);
    }
}