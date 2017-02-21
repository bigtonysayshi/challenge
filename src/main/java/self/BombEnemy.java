package self;

import java.util.*;

/**
 * Given a 2D grid, each cell is either a wall 'W', an enemy 'E' or empty '0' (the number zero),
 * return the maximum enemies you can kill using one bomb.
 * The bomb kills all the enemies in the same row and column from the planted point until
 * it hits the wall since the wall is too strong to be destroyed.
 * Note that you can only put the bomb at an empty cell.
 */
public class BombEnemy {
    // Time: O(mn) Space: O(n)
    public int maxKilledEnemies(char[][] grid) {
        int m = grid.length;
        if (m == 0) return 0;
        int n = grid[0].length;
        int maxCount = 0, rowCount = 0;
        int[] colCounts = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0 || grid[i][j-1] == 'W') {
                    rowCount = 0;
                    for (int k = j; k < n && grid[i][k] != 'W'; k++) {
                        if (grid[i][k] == 'E') rowCount++;
                    }
                }
                if (i == 0 || grid[i-1][j] == 'W') {
                    int colCount = 0;
                    for (int k = i; k < m && grid[k][j] != 'W'; k++) {
                        if (grid[k][j] == 'E') colCount++;
                    }
                    colCounts[j] = colCount;
                }
                if (grid[i][j] == '0') {
                    maxCount = Math.max(maxCount, rowCount + colCounts[j]);
                }
            }
        }
        return maxCount;
    }

    public static void main(String[] args){
        BombEnemy instance = new BombEnemy();
        System.out.println(instance.maxKilledEnemies(
                new char[][]{
                        {'0','E','0','0','E'},
                        {'E','0','W','E','E'},
                        {'0','E','0','E','E'}
                }));
    }
}
