package baseball;

import static baseball.BaseballConstants.*;
import static baseball.BaseballConstants.Message.*;

/**
 * @author Jo Guk <jjozerg@gmail.com>
 * @version 1.0
 * @since 1.0
 */
public class ConsoleView {
    private static final ConsoleView instance = new ConsoleView();

    private ConsoleView() {

    }
    public static ConsoleView getInstance(){
        return instance;
    }

    /**
     * 사용자의 입력 안내메세지를 콘솔 출력한다.
     */
    public void printInputMessage() {
        System.out.print(INPUT_GUIDE_MESSAGE.getMessage());
    }

    /**
     * 잘못된 사용자 입력에 대한 안내 메세지를 콘솔 출력한다.
     */
    public void printInvalideInputException() {
        System.out.printf(INPUT_ERROR_MESSAGE.getMessage(), NUMBER_OF_BALL);
    }

    /**
     * 사용자 입력에 대한 힌트 메세지를 콘솔 출력한다.
     *
     * @param strikeCnt 스트라이크 카운트 수
     * @param ballCnt 볼 카운트 수
     */
    public void printHintMessage(Integer strikeCnt, Integer ballCnt) {
        String resultMessage = "";
        if (strikeCnt == ZERO_COUNT && ballCnt == ZERO_COUNT) {
            System.out.println(HINT_NOT_MATCH_GUIDE_MESSAGE.getMessage());
            return;
        }

        resultMessage += strikeCnt != ZERO_COUNT ? strikeCnt + HINT_STRIKE_GUIDE_MESSAGE.getMessage() + " ": "";
        resultMessage += ballCnt != ZERO_COUNT ? ballCnt + HINT_BALL_GUIDE_MESSAGE.getMessage() : "";

        System.out.println(resultMessage);
    }

    /**
     * 게임 종료 안내 메세지를 콘솔 출력한다.
     */
    public void printSuccessMessage() {
        System.out.printf(GAME_SUCCESS_GUIDE_MESSAGE.getMessage(), NUMBER_OF_BALL);
    }

    /**
     * 게임 종료 안내 메세지를 콘솔 출력한다.
     */
    public void printEndGuideMessage() {
        System.out.printf(GAME_END_GUIDE_MESSAGE.getMessage(), GAME_RESTART_CODE, GAME_TERMINATION_CODE);
    }
}
