package baseball;

/**
 * @author Jo Guk <jjozerg@gmail.com>
 * @version 1.0
 * @since 1.0
 */
public class BaseballConstants {
    public static final Integer NUMBER_OF_BALL = 3;

    public enum ErrorMessage {
        INPUT_GUIDE_MESSAGE(0, "숫자를 입력해주세요 : "),
        INPUT_ERROR_MESSAGE(1, "[ERROR]%d자리의 서로 다른 숫자를 입력해야 합니다.\n");

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
