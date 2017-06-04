package ttt.model;

/**
 * Created by tzhang2 on 4/25/17.
 */
public class SimpleMoveStrategy implements MoveMethod {
    private Game game;
    public SimpleMoveStrategy(Game g) {
        game = g;
    }

    public int move() {
        Board board = game.getBoard();
        for (int i = 0; i < board.getRows(); i++) {
            for (int j = 0; j < board.getCols(); j++) {
                int move = i * board.getCols() + j + 1;
                if (board.validMove(move)) {
                    return move;
                }
            }
        }
        return 0;
    }
}
