package self;

import com.sun.tools.javac.util.ArrayUtils;

import java.util.Arrays;

/**
 * Given a sorted array of integers nums and integer values a, b and c.
 * Apply a function of the form f(x) = ax2 + bx + c to each element x in the array.
 * The returned array must be in sorted order.
 * Expected time complexity: O(n)
 */
public class SortTransformedArray {
    // Time: O(n) Space: O(n)
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        if (nums.length == 0) return nums;
        int[] sorted = new int[nums.length];
        double vertex;
        if (a == 0) {
            vertex = b >= 0? nums[0] : nums[nums.length - 1];
        } else {
            vertex = -(double) b / (double) (2*a);
        }
        int left = 0, right = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            double leftDiff = Math.abs(nums[left] - vertex);
            double rightDiff = Math.abs(nums[right] - vertex);
            boolean useLeft = leftDiff >= rightDiff;
            int next = useLeft ? nums[left] : nums[right];
            int idx = a >= 0 ? nums.length - 1 - i : i;
            sorted[idx] = a * next * next + b * next + c;
            if (useLeft) {
                left++;
            } else {
                right--;
            }
        }
        return sorted;
    }

    public static void main(String[] args){
        SortTransformedArray instance = new SortTransformedArray();
        System.out.println(Arrays.toString(instance.sortTransformedArray(new int[]{-4,-2,2,4},1,3,5)));
        System.out.println(Arrays.toString(instance.sortTransformedArray(new int[]{-4,-2,2,4},-1,3,5)));
        System.out.println(Arrays.toString(instance.sortTransformedArray(new int[]{-4,-2,2,4},0,3,5)));
        System.out.println(Arrays.toString(instance.sortTransformedArray(new int[]{-4,-2,2,4},0,-2,5)));

    }
}
