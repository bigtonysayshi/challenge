package self;

import java.util.HashMap;

/**
 * Given an array nums and a target value k, find the maximum length of a subarray that sums to k.
 * If there isn't one, return 0 instead.
 * Note: The sum of the entire nums array is guaranteed to fit within the 32-bit signed integer range.
 */
public class MaximumSizeSubarraySumEqualsK {
    // Time: O(n) Space: O(n)
    public int maxSubArrayLen(int[] nums, int k) {
        int sum = 0, maxLen = 0;
        HashMap<Integer, Integer> sumMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == k) {
                maxLen = i+1;
            } else if (sumMap.containsKey(sum - k)) {
              maxLen = Math.max(maxLen, i - sumMap.get(sum - k));
            }
            if (!sumMap.containsKey(sum)) {
                sumMap.put(sum, i);
            }
        }
        return maxLen;
    }

    public static void main(String[] args){
        MaximumSizeSubarraySumEqualsK instance = new MaximumSizeSubarraySumEqualsK();
        System.out.println(instance.maxSubArrayLen(new int[]{1,-1,5,-2,3}, 3));
        System.out.println(instance.maxSubArrayLen(new int[]{-2,-1,2,1}, 1));
    }
}
