package self;

import java.util.Arrays;
import java.util.Map;

/**
 * Given an integer array with all positive numbers and no duplicates,
 * find the number of possible combinations that add up to a positive integer target.
 * Follow up:
 * What if negative numbers are allowed in the given array?
 * How does it change the problem?
 * What limitation we need to add to the question to allow negative numbers?
 */
public class CombinationSum4 {
    // Time: O(nt) Space: O(t)
    public int combinationSum4(int[] nums, int target) {
        int[] counts = new int[target+1];
        counts[0] = 1;
        for (int i = 0; i < counts.length; i++) {
            for (int n : nums) {
                if (n + i < counts.length) counts[n + i] += counts[i];
            }
        }
        return counts[counts.length-1];
    }

    public static void main(String[] args){
        CombinationSum4 instance = new CombinationSum4();
        System.out.println(instance.combinationSum4(new int[]{1,2,3}, 4));
    }
}
