package self;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given an array nums, write a function to move all 0's to the end of it
 * while maintaining the relative order of the non-zero elements.
 * For example, given nums = [0, 1, 0, 3, 12], after calling your function,
 * nums should be [1, 3, 12, 0, 0].
 * Note:You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 */
public class MoveZeroes {
    // Time: O(n) Space: O(1)
    public void moveZeroes(int[] nums) {
        int startIdx = 0;
        while (startIdx < nums.length && nums[startIdx] != 0) {
            startIdx++;
        }
        int currentIdx = startIdx + 1;
        while (currentIdx < nums.length) {
            if (nums[currentIdx] != 0) {
                swap(nums, startIdx, currentIdx);
                startIdx++;
            }
            currentIdx++;
        }
    }

    // Time: O(n) Space: O(1)
    public void moveZeroes2(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }
        for (; j < nums.length; j++) {
            nums[j] = 0;
        }
    }

    private void swap(int[] nums, int idx1, int idx2) {
        int tmp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = tmp;
    }

    public static void main(String[] args){
        MoveZeroes instance = new MoveZeroes();
        int[] input = new int[]{0,1,0,3,12};
        instance.moveZeroes2(input);
        System.out.println(Arrays.toString(input));
    }
}
