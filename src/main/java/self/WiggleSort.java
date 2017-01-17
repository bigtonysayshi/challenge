package self;

import java.util.Arrays;

/**
 * Given an unsorted array nums, reorder it in-place such that nums[0] <= nums[1] >= nums[2] <= nums[3]...
 */
public class WiggleSort {
    // Time: O(n) Space: O(1)
    public void wiggleSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (((i % 2 == 0) && (nums[i] > nums[i-1])) ||
                    ((i % 2 == 1) && (nums[i] < nums[i-1]))) {
                swapPrev(nums, i);
            }
        }
    }

    private void swapPrev(int[] nums, int idx) {
        if (idx > 0 ) {
            int tmp = nums[idx-1];
            nums[idx-1] = nums[idx];
            nums[idx] = tmp;
        }
    }

    public static void main(String[] args){
        int[] input = new int[]{3, 3, 2, 2, 6, 4};
        WiggleSort instance = new WiggleSort();
        instance.wiggleSort(input);
        System.out.println(Arrays.toString(input));
    }
}
