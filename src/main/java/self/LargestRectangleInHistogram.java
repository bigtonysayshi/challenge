package self;

import java.util.Stack;

/**
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1,
 * find the area of largest rectangle in the histogram.
 */
public class LargestRectangleInHistogram {
    // Time: O(n) Space: O(n)
    public int largestRectangleArea(int[] heights) {
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

    public static void main(String[] args){
        LargestRectangleInHistogram instance = new LargestRectangleInHistogram();
        System.out.println(instance.largestRectangleArea(new int[]{2,1,5,6,2,3}));
        System.out.println(instance.largestRectangleArea(new int[]{1,1}));
        System.out.println(instance.largestRectangleArea(new int[]{2,1,2}));
        System.out.println(instance.largestRectangleArea(new int[]{4,2,0,3,2,5}));
    }
}
