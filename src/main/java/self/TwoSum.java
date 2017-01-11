package self;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution.
 * The return format had been changed to zero-based indices.
 */
public class TwoSum {
    // Time: O(n) Space:O(n)
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> valPosMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            if (valPosMap.containsKey(val)) {
                return new int[]{valPosMap.get(val), i};
            } else {
                valPosMap.put(target - val, i);
            }
        }
        return new int[2];
    }

    public static void main(String[] args){
        TwoSum instance = new TwoSum();
        System.out.println(Arrays.toString(instance.twoSum(new int[]{2, 7, 11, 15}, 9)));
    }
}
