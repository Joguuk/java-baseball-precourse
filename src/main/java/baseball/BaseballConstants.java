package baseball;

/**
 * @author Jo Guk <jjozerg@gmail.com>
 * @version 1.0
 * @since 1.0
 */
public class BaseballConstants {
    public static final Integer NUMBER_OF_BALL = 3;
    public static final Integer ZERO_COUNT = 0;

    public enum ErrorMessage {
        INPUT_GUIDE_MESSAGE(0, "숫자를 입력해주세요 : "),
        INPUT_ERROR_MESSAGE(1, "[ERROR]%d자리의 서로 다른 숫자를 입력해야 합니다.\n"),
        HINT_NOT_MATCH_GUIDE_MESSAGE(2, "낫싱"),
        HINT_STRIKE_GUIDE_MESSAGE(3, "스트라이크"),
        HINT_BALL_GUIDE_MESSAGE(4, "볼"),
        GAME_SUCCESS_GUIDE_MESSAGE(5, "%d개의 숫자를 모두 맞히셨습니다! 게임 끝\n");

        private final int errorCode;
        private final String errorMessage;

        private ErrorMessage(int code, String description) {
            this.errorCode = code;
            this.errorMessage = description;
        }

        public String getErrorMessage() {
            return errorMessage;
        }

        public int getErrorCode() {
            return errorCode;
        }

        @Override
        public String toString() {
            return errorCode + ": " + errorMessage;
        }
    }
}
