package self;

import java.util.Arrays;

/**
 * You are a professional robber planning to rob houses along a street.
 * Each house has a certain amount of money stashed, the only constraint stopping you from
 * robbing each of them is that adjacent houses have security system connected and
 * it will automatically contact the police if two adjacent houses were broken into on the same night.
 * Given a list of non-negative integers representing the amount of money of each house,
 * determine the maximum amount of money you can rob tonight without alerting the police.
 */
public class HouseRobber {
    // Time: O(n) Space: O(1)
    public int rob(int[] nums) {
        int prevTaken = 0;
        int prevSkipped = 0;

        for (int n : nums) {
            int takeCurrent = prevSkipped + n;
            int skipCurrent = Math.max(prevTaken, prevSkipped);
            prevTaken = takeCurrent;
            prevSkipped = skipCurrent;
        }
        return Math.max(prevTaken, prevSkipped);
    }

    public static void main(String[] args){
        HouseRobber instance = new HouseRobber();
        System.out.println(instance.rob(new int[]{6, 5, 1, 2, 1, 8, 1}));
    }
}
