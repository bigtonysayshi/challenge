package self;

import java.util.HashMap;

/**
 * You are given a list of non-negative integers, a1, a2, ..., an, and a target, S.
 * Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.
 * Find out how many ways to assign symbols to make sum of integers equal to target S.
 * Note:
 * The length of the given array is positive and will not exceed 20.
 * The sum of elements in the given array will not exceed 1000.
 * Your output answer is guaranteed to be fitted in a 32-bit integer.
 */
public class TargetSum {
    public int findTargetSumWays(int[] nums, int S) {
        return findWays(nums, 0, S, new HashMap[nums.length]);
    }

    private int findWays(int[] nums, int idx, int S, HashMap<Integer, Integer>[] known) {
        if (known[idx] == null) known[idx] = new HashMap<>();
        HashMap<Integer, Integer> entry = known[idx];
        if (!entry.containsKey(S)) {
            int val = 0;
            if (idx == nums.length - 1) {
                if (nums[idx] == S) val++;
                if (nums[idx] == -S) val++;
            } else {
                val = findWays(nums, idx + 1, S - nums[idx], known) +
                        findWays(nums, idx + 1, S + nums[idx], known);
            }
            entry.put(S, val);
        }
        return entry.get(S);
    }

    // DP
    // Time: O(n*SUM) Space: O(SUM)
    public int findTargetSumWays2(int[] nums, int s) {
        int sum = 0;
        for(int i: nums) sum+=i;
        if(s>sum || s<-sum) return 0;
        int[] dp = new int[2*sum+1];
        dp[0+sum] = 1;
        for(int i = 0; i<nums.length; i++){
            int[] next = new int[2*sum+1];
            for(int k = 0; k<2*sum+1; k++){
                if(dp[k]!=0){
                    next[k + nums[i]] += dp[k];
                    next[k - nums[i]] += dp[k];
                }
            }
            dp = next;
        }
        return dp[sum+s];
    }

    public static void main(String[] args){
        TargetSum instance = new TargetSum();
        System.out.println(instance.findTargetSumWays(new int[]{1,1,1,1,1}, 3));
        System.out.println(instance.findTargetSumWays(new int[]{6,20,22,38,11,15,22,30,0,17,34,29,7,42,46,49,30,7,14,5}, 28));
    }
}
