package self;

import java.util.Arrays;

/**
 * Given a sorted array, remove the duplicates in place such that each element appear only once
 * and return the new length.
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 */
public class RemoveDuplicatesFromSortedArray {
    // Time: O(n) Space: O(1)
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int writeIdx = 1;
        int readIdx = 0;
        int currentVal = nums[readIdx++];
        while (readIdx < nums.length) {
            int val = nums[readIdx++];
            if (val != currentVal) {
                nums[writeIdx++] = val;
                currentVal = val;
            }
        }
        return writeIdx;
    }

    public static void main(String[] args){
        RemoveDuplicatesFromSortedArray instance = new RemoveDuplicatesFromSortedArray();
        System.out.println(instance.removeDuplicates(new int[]{1,1,2}));
        System.out.println(instance.removeDuplicates(new int[]{2,2}));
    }
}
