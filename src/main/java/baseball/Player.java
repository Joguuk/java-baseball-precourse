package baseball;

import nextstep.utils.Console;

import static baseball.Application.consoleView;
import static baseball.BaseballConstants.*;

/**
 * @author Jo Guk <jjozerg@gmail.com>
 * @version 1.0
 * @since 1.0
 */
public class Player {
    private Computer computer;
    private String input;

    public Player() {
        computer = new Computer();
        input = "";
    }

    /**
     * Player 가 게임을 시작한다.
     */
    public void playBaseballGame() {
        Boolean isGamePlay = true;

        while (isGamePlay) {
            isGamePlay = startGame();
        }
    }

    /**
     * 정해진 자리수(BaseballConstants.NUMBER_OF_BALL)의 숫자를 입력하고 컴퓨터에게 결과를 묻는다.
     * 게임에서 승리할 경우 새로운 게임을 시작할지 여부를 선택한다.
     *
     * @return Game의 진행 여부에 대한 Boolean. 게임에서 승리할 경우 새로운 게임을 시작할지 여부를 선택하여 반환.
     */
    private Boolean startGame() {
        if (getPlayerInput() && computer.checkResult(input)) {
            return isGameReplay();
        }
        return true;
    }

    /**
     * Player 에게 숫자를 입력받는다.
     *
     * @return 입력값이 유효한지에 대한 Boolean
     */
    private Boolean getPlayerInput() {
        consoleView.printInputMessage();
        input = Console.readLine();

        return validateGameNumberInput();
    }

    /**
     * Player 의 게임 숫자 입력에 대해 검증한다.
     * [ 규칙 ]
     * 1. 입력값의 자리수(BaseballConstants.NUMBER_OF_BALL)가 일치하지 않는 경우 false 반환
     * 2. 숫자가 아닌 입력값이 발생한 경우 false 반환
     * 3. 중복된 숫자가 입력된 경우 false 반환
     *
     * @return 입력값이 유효한지에 대한 Boolean
     */
    private Boolean validateGameNumberInput() {
        Boolean isDuplicate = false;

        if (input.length() != NUMBER_OF_BALL || !input.chars().allMatch(Character::isDigit)) {
            consoleView.printInvalideInputException();
            return false;
        }

        for (int i = 0; !isDuplicate && i < input.length(); i++) {
            isDuplicate = isCharDuplidate(i);
        }
        return !isDuplicate;
    }

    /**
     * 파라미터로 전달된 input의 index가 중복인지 확인하여 반환한다.
     *
     * @return 파라미터가 중복 숫자인지 판단한 Boolean
     */
    private boolean isCharDuplidate(int i) {
        if (input.indexOf(input.charAt(i)) != i) {
            consoleView.printInvalideInputException();
            return true;
        }
        return false;
    }

    /**
     * Player 에게 게임을 계속할지 입력받는다.
     *
     * @return 게임을 종료할지에 대한 반환값
     */
    public Boolean isGameReplay() {
        Boolean isValidInput = true;

        while (isValidInput) {
            consoleView.printEndGuideMessage();
            input = Console.readLine();

            isValidInput = validateReplayInput();
        }

        return checkReplayInput();
    }

    /**
     * Player 의 재시작 입력에 대해 검증한다.
     * [ 규칙 ]
     * 1. 입력값이 재시작(BaseballConstants.GAME_RESTART_CODE) 혹은 종료(BaseballConstants.GAME_TERMINATION_CODE) 이외의 값인 경우 false 반환
     *
     * @return 입력값이 유효한지에 대한 Boolean
     */
    private Boolean validateReplayInput() {
        return input.equals(GAME_RESTART_CODE) || input.equals(GAME_TERMINATION_CODE) ? false : true;
    }

    /**
     * Player 의 재시작 여부 입력에 대한 결과를 반환한다.
     *
     * @return 종료 여부 Boolean
     */
    private Boolean checkReplayInput() {
        if (input.equals(GAME_RESTART_CODE)) {
            computer.initGame();
            return true;
        }

        if (input.equals(GAME_TERMINATION_CODE)) {
            return false;
        }

        return false;
    }
}
