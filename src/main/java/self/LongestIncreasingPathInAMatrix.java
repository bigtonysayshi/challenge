package self;

/**
 * Given an integer matrix, find the length of the longest increasing path.
 * From each cell, you can either move to four directions: left, right, up or down.
 * You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).
 */
public class LongestIncreasingPathInAMatrix {
    static final int[] dx = new int[]{0, 0, 1, -1};
    static final int[] dy = new int[]{1, -1, 0, 0};

    // Time: O(mn) Space: O(mn)
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int maxLen = 0;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxLen = Math.max(maxLen, search(matrix, dp, i, j));
            }
        }
        return maxLen;
    }

    private int search(int[][] matrix, int[][] dp, int row, int col) {
        if (dp[row][col] > 0) {
            return dp[row][col];
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int val = matrix[row][col];
        int maxLen = 0;
        for (int i = 0; i < dx.length; i++) {
            int nr = row + dy[i];
            int nc = col + dx[i];
            if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                continue;
            }
            if (val > matrix[nr][nc]) {
                int prevLen = search(matrix, dp, nr, nc);
                maxLen = Math.max(maxLen, prevLen);
            }
        }
        dp[row][col] = maxLen + 1;
        return dp[row][col];
    }

    public static void main(String[] args){
        LongestIncreasingPathInAMatrix instance = new LongestIncreasingPathInAMatrix();
        System.out.println(instance.longestIncreasingPath(new int[][] {
                {9, 9, 4},
                {6, 6, 8},
                {2, 1, 1}
        }));
    }
}
