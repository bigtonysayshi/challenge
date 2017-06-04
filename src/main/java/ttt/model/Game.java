package ttt.model;

/**
 * Created by tzhang2 on 4/23/17.
 */
public class Game {
    private static final String COMPUTER_NAME = "Computer";

    private GameState state;
    private Board board;
    private Player player1;
    private Player player2;
    private int currentPlayer;
    private int humanPlayersNeeded;
    private int computerPlayersNeeded;

    public Game(int rows, int cols, int humanPlayers) {
        state = GameState.INIT;
        board = new Board(rows, cols);
        player1 = null;
        player2 = null;
        currentPlayer = 0;
        humanPlayersNeeded = humanPlayers;
        computerPlayersNeeded = 2 - humanPlayers;
    }

    public GameState getState() {
        return state;
    }

    public void setState(GameState state) {
        this.state = state;
    }

    public Board getBoard() {
        return board;
    }

    public boolean needHumanPlayer() {
        return humanPlayersNeeded > 0;
    }

    public boolean needComputerPlayer() {
        return computerPlayersNeeded > 0;
    }

    public void addHumanPlayer(String name) {
        if (player1 == null) {
            player1 = new Player(name, false, Symbol.CROSS, new HumanMove());
            humanPlayersNeeded--;
        } else if (player2 == null) {
            player2 = new Player(name, false, Symbol.CIRCLE, new HumanMove());
            humanPlayersNeeded--;
        }
    }

    public void addComputerPlayer() {
        if (player1 == null) {
            player1 = new Player(COMPUTER_NAME, true, Symbol.CROSS, new SimpleMoveStrategy(this));
            computerPlayersNeeded--;
        } else if (player2 == null) {
            player2 = new Player(COMPUTER_NAME, true, Symbol.CIRCLE, new SimpleMoveStrategy(this));
            computerPlayersNeeded--;
        }
    }

    public Player getCurrentPlayer() {
        return currentPlayer == 1 ? player1 : player2;
    }

    public void setCurrentPlayer(int currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public void switchPlayer() {
        currentPlayer = 3 - currentPlayer;
    }

}
