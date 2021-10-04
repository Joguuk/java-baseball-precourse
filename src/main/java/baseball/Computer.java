package baseball;

import static baseball.Application.consoleView;
import static baseball.BaseballConstants.NUMBER_OF_BALL;

/**
 * @author Jo Guk <jjozerg@gmail.com>
 * @version 1.0
 * @since 1.0
 */
public class Computer {
    private Balls balls;

    public Computer() {
        balls = new Balls();
        initGame();
    }

    /**
     * Computer 가 게임을 시작하기 전에 초기화 세팅한다.
     */
    public void initGame() {
        balls.createBall();
        balls.printBallNum();
    }

    /**
     * Player 가 입력한 숫자의 결과를 판단하여 승패를 반환한다.
     *
     * @param input Player의 입력값
     * @return 게임의 승패 결과값(숫자를 모두 맞출 경우 true)
     */
    public Boolean checkResult(String input) {
        balls.initCnt();
        checkInputNum(input);
        consoleView.printHintMessage(balls.getStrikeCnt(), balls.getBallCnt());

        if (balls.getStrikeCnt() == NUMBER_OF_BALL) {
            consoleView.printSuccessMessage();
            return true;
        }

        return false;
    }

    /**
     * Player 가 입력한 숫자를 판단한다.
     * 각 자리수의 숫자가 스트라이크인 경우 볼로 판단하면 안되기 때문에 스트라이크를 먼저 체크한다.
     * 이후 사용자 입력의 숫자 중 스트라이크가 아닌 자릿수의 숫자와 동일한 경우 볼로 카운트한다.
     *
     * @param input Player의 입력값
     */
    public void checkInputNum(String input) {
        String[] splitInput = input.split("");

        // 1. 스트라이크 여부 체크
        for (int i = 0 ; i < NUMBER_OF_BALL ; i++) {
            balls.checkStrike(i, Integer.parseInt(splitInput[i]));
        }

        // 2. 볼 체크
        for (int i = 0 ; i < NUMBER_OF_BALL ; i++) {
            balls.checkBall(Integer.parseInt(splitInput[i]));
        }
    }
}
