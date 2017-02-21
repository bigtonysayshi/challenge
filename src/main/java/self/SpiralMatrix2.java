package self;

import java.util.Arrays;

/**
 * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 */
public class SpiralMatrix2 {
    // Time: O(n^2) Space: O(n^2)
    public int[][] generateMatrix(int n) {
        if (n <= 0) return new int[0][0];
        int[][] result = new int[n][n];
        int val = 1;
        for (int layer = 0; layer * 2 < n; layer ++) {
            for (int i = 0; i < n - 1 - layer * 2; i++) {
                result[layer][layer + i] = val++;
            }
            for (int i = 0; i < n - 1 - layer * 2; i++) {
                result[layer + i][n - 1 - layer] = val++;
            }
            for (int i = 0; i < n - 1 - layer * 2; i++) {
                result[n - 1 - layer][n - 1 - layer - i] = val++;
            }
            for (int i = 0; i < n - 1 - layer * 2; i++) {
                result[n - 1 - layer - i][layer] = val++;
            }
        }
        if (n % 2 == 1) {
            result[n/2][n/2] = val;
        }
        return result;
    }

    public static void main(String[] args){
        SpiralMatrix2 instance = new SpiralMatrix2();
        int[][] results = instance.generateMatrix(5);
        for (int[] row : results) {
            System.out.println(Arrays.toString(row));
        }
    }
}
