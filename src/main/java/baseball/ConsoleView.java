package baseball;

import static baseball.BaseballConstants.*;
import static baseball.BaseballConstants.ErrorMessage.INPUT_ERROR_MESSAGE;
import static baseball.BaseballConstants.ErrorMessage.INPUT_GUIDE_MESSAGE;

/**
 * @author Jo Guk <jjozerg@gmail.com>
 * @version 1.0
 * @since 1.0
 */
public class ConsoleView {
    /**
     * 사용자의 입력 안내메세지를 콘솔 출력한다.
     */
    public void printInputMessage() {
        System.out.print(INPUT_GUIDE_MESSAGE.getErrorMessage());
    }

    /**
     * 잘못된 사용자 입력에 대한 안내 메세지를 콘솔 출력한다.
     */
    public void printInvalideInputException() {
        System.out.printf(INPUT_ERROR_MESSAGE.getErrorMessage(), NUMBER_OF_BALL);
    }
}
