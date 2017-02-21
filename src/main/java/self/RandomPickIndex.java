package self;

import java.util.*;

/**
 * Given an array of integers with possible duplicates,
 * randomly output the index of a given target number.
 * You can assume that the given target number must exist in the array.
 * Note:The array size can be very large.
 * Solution that uses too much extra space will not pass the judge.
 */
public class RandomPickIndex {
    Map<Integer, List<Integer>> indexMap;
    int[] nums;
    Random rand;
    public RandomPickIndex(int[] nums) {
        rand = new Random();
        this.nums = nums;
    }

    // reservoir sampling
    public int pick(int target) {
        int count = 0;
        int idx = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                if (rand.nextInt(++count) == 0) {
                    idx = i;
                }
            }
        }
        return idx;
    }
}
