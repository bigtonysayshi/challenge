package self;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 * For example, Given [10, 9, 2, 5, 3, 7, 101, 18],
 * The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4.
 * Note that there may be more than one LIS combination, it is only necessary for you to return the length.
 * Your algorithm should run in O(n2) complexity.
 * Follow up: Could you improve it to O(n log n) time complexity?
 */
public class LongestIncreasingSubsequence {
    // Time: O(nlogn) Space: O(n)
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int len = 0;
        for (int num : nums) {
            int pos = Arrays.binarySearch(dp, 0, len, num);
            if (pos < 0) pos = - (pos+1);
            dp[pos] = num;
            if (pos == len) len++;
        }
        return len;
    }

    public static void main(String[] args){
        LongestIncreasingSubsequence instance = new LongestIncreasingSubsequence();
        System.out.println(instance.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
        System.out.println(instance.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 4}));
    }
}
