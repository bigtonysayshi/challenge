package self;

import java.util.Arrays;

/**
 * Given a board with m by n cells, each cell has an initial state live (1) or dead (0).
 * Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):
 * Any live cell with fewer than two live neighbors dies, as if caused by under-population.
 * Any live cell with two or three live neighbors lives on to the next generation.
 * Any live cell with more than three live neighbors dies, as if by over-population..
 * Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
 * Write a function to compute the next state (after one update) of the board given its current state.
 * Follow up:
 * Could you solve it in-place?
 * Remember that the board needs to be updated at the same time:
 * You cannot update some cells first and then use their updated values to update other cells.
 * In this question, we represent the board using a 2D array.
 * In principle, the board is infinite, which would cause problems when the active area encroaches the border of the array.
 * How would you address these problems?
 */
public class GameOfLife {
    // Time: O(mn) Space: O(1)
    public void gameOfLife(int[][] board) {
        int m = board.length;
        if (m == 0)return;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int liveNeighbors = findLiveNeighbors(board, i, j);
                if (board[i][j] == 0 && liveNeighbors == 3) {
                    board[i][j] = 2;
                } else if (board[i][j] == 1 && (liveNeighbors < 2 || liveNeighbors > 3)) {
                    board[i][j] = -1;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = board[i][j] > 0 ? 1 : 0;
            }
        }
    }

    private int findLiveNeighbors(int[][] board, int i, int j) {
        int m = board.length, n = board[0].length, liveNeighbors = 0;
        if (i > 0 && j > 0 && Math.abs(board[i-1][j-1]) == 1) liveNeighbors++;
        if (i > 0 && Math.abs(board[i-1][j]) == 1) liveNeighbors++;
        if (i > 0 && j < n-1 && Math.abs(board[i-1][j+1]) == 1) liveNeighbors++;
        if (j > 0 && Math.abs(board[i][j-1]) == 1) liveNeighbors++;
        if (j < n-1 && Math.abs(board[i][j+1]) == 1) liveNeighbors++;
        if (i < m-1 && j > 0 && Math.abs(board[i+1][j-1]) == 1) liveNeighbors++;
        if (i < m-1 && Math.abs(board[i+1][j]) == 1) liveNeighbors++;
        if (i < m-1 && j < n-1 && Math.abs(board[i+1][j+1]) == 1) liveNeighbors++;
        return liveNeighbors;
    }

    public static void main(String[] args){
        GameOfLife instance = new GameOfLife();
        int[][] input = new int[][]{{0,1,1},{1,0,1},{0,0,0}};
        instance.gameOfLife(input);
        for (int[] row : input) {
            System.out.println(Arrays.toString(row));
        }
    }
}
