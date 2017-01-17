package self;

import java.util.Arrays;

/**
 * Rotate an array of n elements to the right by k steps.
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 * Note:
 * Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 */
public class RotateArray {
    // Time: O(n) Space: O(1)
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) return;
        k = k % n;
        if (k == 0) return;
        if (k < 0) k += n;
        reverse(nums, 0, n-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, n-1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }


    public static void main(String[] args){
        RotateArray instance = new RotateArray();
        int[] input = new int[]{1,2,3,4,5,6};
        instance.rotate(input, 2);
        System.out.println(Arrays.toString(input));
        instance.rotate(input, 3);
        System.out.println(Arrays.toString(input));
        instance.rotate(input, 1);
        System.out.println(Arrays.toString(input));
        instance.rotate(input, -1);
        System.out.println(Arrays.toString(input));
        instance.rotate(input, 8);
        System.out.println(Arrays.toString(input));
    }
}
