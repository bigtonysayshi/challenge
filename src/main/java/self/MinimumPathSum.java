package self;

/**
 * Given a m x n grid filled with non-negative numbers,
 * find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 * Note: You can only move either down or right at any point in time.
 */
public class MinimumPathSum {
    // Time: O(mn) Space: O(n)
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        if (m == 0) return 0;
        int n = grid[0].length;
        int[] sums = new int[n];
        for (int i = m-1; i >= 0; i--) {
            for (int j = n-1; j >= 0; j--) {
                int curr = grid[i][j];
                if (i == m-1 && j == n-1) {
                    sums[j] = curr;
                } else if (i == m-1) {
                    sums[j] = curr + sums[j+1];
                } else if (j == n-1) {
                    sums[j] = curr + sums[j];
                } else {
                    sums[j] = curr + Math.min(sums[j+1], sums[j]);
                }
            }
        }
        return sums[0];
    }

    public static void main(String[] args){
        MinimumPathSum instance = new MinimumPathSum();
        System.out.println(instance.minPathSum(new int[][]{{1,2,3},{3,0,1},{2,3,1}}));
    }
}
