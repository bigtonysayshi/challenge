package self;

import java.util.Arrays;

/**
 * Given an array with n objects colored red, white or blue,
 * sort them so that objects of the same color are adjacent,
 * with the colors in the order red, white and blue
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 * Note: You are not suppose to use the library's sort function for this problem.
 */
public class SortColors {
    // Time: O(n) Space: O(1)
    public void sortColors(int[] nums) {
        int zeros = 0, ones = 0;
        for (int n : nums) {
            if (n == 0) {
                zeros++;
            } else if (n == 1) {
                ones++;
            }
        }
        Arrays.fill(nums, 0, zeros, 0);
        Arrays.fill(nums, zeros, zeros + ones, 1);
        Arrays.fill(nums, zeros + ones, nums.length, 2);
    }

    public void sortColors2(int[] nums) {
        int left = 0, right = nums.length - 1;
        for (int i = 0; i <= right; i++) {
            if (nums[i] == 0 && i != left) {
                swap(nums, i--, left++);
            } else if (nums[i] == 2 && i != right) {
                swap(nums, i--, right--);
            }
        }

    }

    private void swap(int[] nums, int x, int y) {
        int tmp = nums[x];
        nums[x] = nums[y];
        nums[y] = tmp;
    }

    public static void main(String[] args){
        SortColors instance = new SortColors();
        int[] input = new int[]{2,2,0,1,1,0,0,0,2,1};
        instance.sortColors(input);
        System.out.println(Arrays.toString(input));
    }
}
