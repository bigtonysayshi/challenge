package self;

import java.util.Arrays;

/**
 * You are given an n x n 2D matrix representing an image.
 * Rotate the image by 90 degrees (clockwise).
 * Follow up: Could you do this in-place?
 */
public class RotateImage {
    // Time: O(n^2) Space: O(1)
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int layer = 0; layer < n / 2; layer++) {
            rotateLayer(matrix, layer);
        }
    }

    private void rotateLayer(int[][] matrix, int layer) {
        int n = matrix.length;
        for (int i = 0; i < n - 1 - layer*2; i++) {
            int tmp = matrix[layer][layer+i];
            matrix[layer][layer+i] = matrix[n-1-layer-i][layer];
            matrix[n-1-layer-i][layer] = matrix[n-1-layer][n-1-layer-i];
            matrix[n-1-layer][n-1-layer-i] = matrix[layer+i][n-1-layer];
            matrix[layer+i][n-1-layer] = tmp;
        }
    }

    public static void main(String[] args){
        RotateImage instance = new RotateImage();
        int[][] input = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        instance.rotate(input);
        for (int[] row : input) {
            System.out.println(Arrays.toString(row));
        }
    }
}
