package baseball;

import nextstep.utils.Console;

import java.util.NoSuchElementException;

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
    }

    /**
     * Player 가 게임을 시작한다. 정해진 자리수(BaseballConstants.NUMBER_OF_BALL)의 숫자를 입력하고 컴퓨터에게 결과를 묻는다.
     * 게임에서 승리할 경우 새로운 게임을 시작할지 여부를 선택한다.
     */
    public void playBaseballGame() {
        while (true) {
            if (!getPlayerInput()) {
                continue;
            }

            if (computer.checkResult(input)) {
                return;
            }
        }
    }

    /**
     * Player 에게 숫자를 입력받는다.
     *
     * @return 입력값이 유효한지에 대한 Boolean
     */
    private Boolean getPlayerInput() {
        try {
            consoleView.printInputMessage();
            input = Console.readLine();

            validateInput();

            return true;
        } catch(Exception e){
            consoleView.printInvalideInputException();
            return false;
        }
    }

    /**
     * Player 의 입력에 대해 검증한다.
     * [ 규칙 ]
     * 1. 입력값의 자리수(BaseballConstants.NUMBER_OF_BALL)가 일치하지 않는 경우 InputMismatchException 을 발생시킨다.
     * 2. 숫자가 아닌 입력값이 발생한 경우 InputMismatchException 을 발생시킨다.
     * 3. 중복된 숫자가 입력된 경우 InputMismatchException 을 발생시킨다.
     */
    private void validateInput() {
        if (input.length() != NUMBER_OF_BALL || !input.chars().allMatch(Character::isDigit)) {
            throw new NoSuchElementException();
        }

        for (int i = 0; i < input.length(); i++) {
            if (input.indexOf(input.charAt(i)) != i) {
                throw new NoSuchElementException();
            }
        }
    }
}
