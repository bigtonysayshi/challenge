package self;

/**
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
 */
public class MaximalSquare {
    // Time: O(mn) Space: O(n)
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] results = new int[2][n];
        int maxSide = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    int top = i > 0 ? results[(i - 1) % 2][j] : 0;
                    int left = j > 0 ? results[i % 2][j - 1] : 0;
                    int topLeft = (i > 0 & j > 0) ? results[(i - 1) % 2][j - 1] : 0;
                    results[i % 2][j] = Math.min(Math.min(top, left), topLeft) + 1;
                    maxSide = Math.max(maxSide, results[i % 2][j]);
                } else {
                    results[i % 2][j] = 0;
                }
            }
        }
        return maxSide * maxSide;
    }

    public static void main(String[] args){
        MaximalSquare instance = new MaximalSquare();
        System.out.println(instance.maximalSquare(new char[][]{
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        }));
        System.out.println(instance.maximalSquare(new char[][]{
                {'1','0','1','1','0','1'},
                {'1','1','1','1','1','1'},
                {'0','1','1','0','1','1'},
                {'1','1','1','0','1','0'},
                {'0','1','1','1','1','1'},
                {'1','1','0','1','1','1'},
        }));
    }
}
