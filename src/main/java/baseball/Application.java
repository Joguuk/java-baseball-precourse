package baseball;

import java.util.NoSuchElementException;

/**
 * @author Jo Guk <jjozerg@gmail.com>
 * @version 1.0
 * @since 1.0
 */
public class Application {
    public static final ConsoleView consoleView = ConsoleView.getInstance();

    public static void main(String[] args) {
        Player player = new Player();
        player.playBaseballGame();
    }
}
