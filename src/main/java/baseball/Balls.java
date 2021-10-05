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
        clearBall();

        for (int i = 0; i < NUMBER_OF_BALL; i++) {
            ballList.add(new Ball(getUniqueNumber()));
        }
    }

    /**
     * 게임에 사용될 숫자 중 중복되지 않은 숫자를 반환한다.
     *
     * @return 중복되지 않은 숫자
     */
    private Integer getUniqueNumber() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);

        if (isDuplicateNumber(randomNumber))
            return getUniqueNumber();

        return randomNumber;
    }

    /**
     * 파라미터로 전달받은 숫자의 중복 여부를 반환한다.
     *
     * @param num 중복 여부를 판단할 숫자
     * @return 파라미터 숫자의 중복 여부
     */
    public Boolean isDuplicateNumber(Integer num) {
        return getAllBallNum().contains(Integer.toString(num));
    }

    /**
     * 새롭게 게임을 시작하기 위해 숫자를 초기화한다.
     */
    public void clearBall() {
        if (ballList.size() == NUMBER_OF_BALL) {
            ballList.clear();
        }
    }

    /**
     * 스트라이크와 볼 카운트를 초기화한다.
     */
    public void initCnt() {
        strikeCnt = 0;
        ballCnt = 0;
        ballList.forEach(ball -> ball.setIsStrike(false));
    }

    public void printBallNum() {
        System.out.println("===ball===");
        System.out.println(getAllBallNum());
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
        if (getNotStrikeBallNum().contains(Integer.toString(inputNum))) {
            ballCnt++;
            return;
        }
    }

    /**
     * ballList에 등록된 전체 번호를 반환한다.
     *
     * @return 전체 번호
     */
    public String getAllBallNum() {
        String allBallNum = "";
        for (Ball ball : ballList) {
            allBallNum += ball.getNum();
        }
        return allBallNum;
    }

    /**
     * ballList에 등록된 전체 번호 중 스트라이크가 아닌 번호를 반환한다.
     *
     * @return 전체 번호
     */
    public String getNotStrikeBallNum() {
        String notStrikeBallNum = "";
        for (Ball ball : ballList) {
            notStrikeBallNum += ball.getIsStrike().equals(false) ? ball.getNum() : "";
        }
        return notStrikeBallNum;
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

    /**
     * 각 자리수에 해당하는 숫자를 의미하는 Ball Class
     */
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
