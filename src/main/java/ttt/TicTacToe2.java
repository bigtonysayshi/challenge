package ttt;

import ttt.controller.Automaton;
import ttt.model.Game;
import ttt.view.ConsoleInterface;
import ttt.view.UserInterface;

/**
 * Created by tzhang2 on 4/23/17.
 */
public class TicTacToe2 {
    private static final int ROWS = 3;
    private static final int COLS = 3;
    private static final int HUMAN_PLAYERS = 1;

    public static void main(String[] args) {
        Game game = new Game(ROWS, COLS, HUMAN_PLAYERS);
        UserInterface userInterface = new ConsoleInterface();
        Automaton automaton = new Automaton(game, userInterface);

        while (!automaton.gameOver()) {
            automaton.step();
        }
    }


}
