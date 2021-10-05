package baseball;

/**
 * @author Jo Guk <jjozerg@gmail.com>
 * @version 1.0
 * @since 1.0
 */
public class BaseballConstants {
    public static final Integer NUMBER_OF_BALL = 3;
    public static final Integer ZERO_COUNT = 0;
    public static final String GAME_RESTART_CODE = "1";
    public static final String GAME_TERMINATION_CODE = "2";

    public enum Message {
        INPUT_GUIDE_MESSAGE("숫자를 입력해주세요 : "),
        INPUT_ERROR_MESSAGE("[ERROR]%d자리의 서로 다른 숫자를 입력해야 합니다.\n"),
        HINT_NOT_MATCH_GUIDE_MESSAGE("낫싱"),
        HINT_STRIKE_GUIDE_MESSAGE("스트라이크"),
        HINT_BALL_GUIDE_MESSAGE("볼"),
        GAME_SUCCESS_GUIDE_MESSAGE("%d개의 숫자를 모두 맞히셨습니다! 게임 끝\n"),
        GAME_END_GUIDE_MESSAGE("게임을 새로 시작하려면 %s, 종료하려면 %s를 입력하세요.");

        private final String message;

        private Message(String description) {
            this.message = description;
        }

        public String getMessage() {
            return message;
        }
    }
}
