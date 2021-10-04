package baseball;

import nextstep.utils.Randoms;

import java.util.ArrayList;

import static baseball.BaseballConstants.NUMBER_OF_BALL;

/**
 * @author Jo Guk <jjozerg@gmail.com>
 * @version 1.0
 * @since 1.0
 */
public class Balls {
    private ArrayList<Ball> ballList;
    private Integer strikeCnt;
    private Integer ballCnt;

    public Balls() {
        this.ballList = new ArrayList<>();
    }

    /**
     * 정해진 자리수만큼 서로 다른 숫자를 생성한다.
     */
    public void createBall() {
        if (ballList.size() == NUMBER_OF_BALL) {
            clearBall();
        }

        for (int i = 0; i < NUMBER_OF_BALL; i++) {
            ballList.add(new Ball(generateUniqueNumber()));
        }
    }

    /**
     * 게임에 사용될 숫자 중 중복되지 않은 숫자를 반환한다.
     *
     * @return 중복되지 않은 숫자
     */
    private Integer generateUniqueNumber() {
        while(true) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);

            if (isDuplicateNumber(randomNumber)) {
                continue;
            }

            return randomNumber;
        }
    }

    /**
     * Player가 입력한 숫자의 결과를 판단하여 승패를 반환한다.
     *
     * @param num Player의 입력값
     * @return 게임의 승패 결과값(숫자를 모두 맞출 경우 true)
     */
    public Boolean isDuplicateNumber(Integer num) {
        for (Ball ball : ballList) {
            if (ball.getNum().equals(num)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 새롭게 게임을 시작하기 위해 숫자를 초기화한다.
     */
    public void clearBall() {
        ballList.clear();
    }

    /**
     * 스트라이크와 볼 카운트를 초기화한다.
     */
    public void initCnt() {
        strikeCnt = 0;
        ballCnt = 0;
        for (Ball ball : ballList) {
            ball.setIsStrike(false);
        }
    }

    public void printBallNum() {
        System.out.println("===ball===");
        for (Ball ball : ballList) {
            System.out.print(ball.getNum());
        }
        System.out.println();
        System.out.println("===ball===");
    }

    /**
     * 스트라이크 개수를 판단한다.
     *
     * @param index 판단할 자리수
     * @param inputNum Player가 입력한 숫자
     */
    public void checkStrike(Integer index, Integer inputNum) {
        if (ballList.get(index).getNum() == inputNum) {
            strikeCnt++;
            ballList.get(index).setIsStrike(true);
        }
    }

    /**
     * 볼 개수를 판단한다.
     * 파라미터로 넘어온 숫자가 스트라이크가 아닌 자릿수의 숫자와 같은 경우 볼로 판단한다.
     *
     * @param inputNum Player가 입력한 숫자
     */
    public void checkBall(Integer inputNum) {
        for (Ball ball : ballList) {
            if (!ball.getIsStrike() && ball.getNum().equals(inputNum)) {
                ballCnt++;
                return;
            }
        }
    }

    /**
     * 스트라이크 카운트 getter
     */
    public Integer getStrikeCnt() {
        return strikeCnt;
    }

    /**
     * 볼 카운트 getter
     */
    public Integer getBallCnt() {
        return ballCnt;
    }

    class Ball {
        private Integer num;
        private Boolean isStrike;

        public Ball(Integer randomNumber) {
            this.num = randomNumber;
            isStrike = false;
        }

        public Integer getNum() {
            return num;
        }

        public Boolean getIsStrike() {
            return isStrike;
        }

        public void setIsStrike(Boolean isStrike) {
            this.isStrike = isStrike;
        }

    }
}
