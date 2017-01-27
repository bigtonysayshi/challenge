package self;

/**
 * Design a Tic-tac-toe game that is played between two players on a n x n grid.
 * You may assume the following rules:
 * A move is guaranteed to be valid and is placed on an empty block.
 * Once a winning condition is reached, no more moves is allowed.
 * A player who succeeds in placing n of their marks in a horizontal, vertical, or diagonal row wins the game.
 * Follow up: Could you do better than O(n2) per move() operation?
 */
public class TicTacToe {
    // Time: O(1) Space: O(n)
    private int size;
    private int[] rowCounts;
    private int[] colCounts;
    private int diag1Count;
    private int diag2Count;
    private int status;

    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        if (n <= 0) return;
        size = n;
        rowCounts = new int[size];
        colCounts = new int[size];
        diag1Count = 0;
        diag2Count = 0;
        status = 0;
    }

    /** Player {player} makes a move at ({row}, {col}).
     @param row The row of the board.
     @param col The column of the board.
     @param player The player, can be either 1 or 2.
     @return The current winning condition, can be either:
     0: No one wins.
     1: Player 1 wins.
     2: Player 2 wins. */
    public int move(int row, int col, int player) {
        int increment = player == 1 ? 1 : -1;
        if (status == 0) {
            rowCounts[row] += increment;
            colCounts[col] += increment;
            if (row == col) diag1Count += increment;
            if (row + col == size - 1) diag2Count += increment;
            if (Math.abs(diag1Count) == size ||
                    Math.abs(diag2Count) == size ||
                    Math.abs(rowCounts[row]) == size ||
                    Math.abs(colCounts[col]) == size) {
                status = player;
            }
        }
        return status;
    }
}
