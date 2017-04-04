package self;

import java.util.Stack;

/**
 * Given a 2D binary matrix filled with 0's and 1's,
 * find the largest rectangle containing only 1's and return its area.
 */
public class MaximalRectangle {
    // Time: O(mn) Space: O(mn)
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null) return 0;
        int m = matrix.length;
        if (m == 0) return 0;
        int n = matrix[0].length;
        if (n == 0) return 0;
        int[][] heights = new int[m][n];
        for (int j = 0; j < n; j++) {
            int h = 0;
            for (int i = 0; i < m; i++) {
                if (matrix[i][j] == '1') {
                    h++;
                } else {
                    h = 0;
                }
                heights[i][j] = h;
            }
        }
        int maxArea = 0;
        for (int i = 0; i < m; i++) {
            int area = largestRectangleArea(heights[i]);
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }

    private int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <= heights.length; i++) {
            int height = (i == heights.length) ? -1 : heights[i];
            while (!stack.isEmpty() && heights[stack.peek()] >= height) {
                int h = heights[stack.pop()];
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, h * w);
            }
            stack.push(i);
        }
        return maxArea;
    }
}
