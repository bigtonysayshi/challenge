package self;

import java.util.Arrays;

/**
 * Follow up for "Unique Paths":
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 */
public class UniquePaths3 {
    // Time: O(mn) Space: O(mn)
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null) {
            return 0;
        }
        int m = obstacleGrid.length;
        if (m == 0) {
            return 0;
        }
        int n = obstacleGrid[0].length;
        if (n == 0) {
            return 0;
        }
        int[][] dp = new int[m][n];
        dp[m - 1][n - 1] = obstacleGrid[m - 1][n - 1] == 1 ? 0 : 1;
        for (int i = m - 2; i >= 0; i--) {
            dp[i][n - 1] = obstacleGrid[i][n - 1] == 1 ? 0 : dp[i + 1][n - 1];
        }
        for (int j = n - 2; j >= 0; j--) {
            dp[m - 1][j] = obstacleGrid[m - 1][j] == 1 ? 0 : dp[m - 1][j + 1];
        }
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                dp[i][j] = obstacleGrid[i][j] == 1 ? 0 : dp[i + 1][j] + dp[i][j + 1];
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args){
        UniquePaths3 instance = new UniquePaths3();
        int output = instance.uniquePathsWithObstacles(new int[][]{
                {0, 0},
                {1, 0}
        });
        System.out.println(output);
    }
}
