package self;

/**
 * Note: This is an extension of House Robber.
 * After robbing those houses on that street, the thief has found himself a new place for his
 * thievery so that he will not get too much attention.
 * This time, all houses at this place are arranged in a circle.
 * That means the first house is the neighbor of the last one.
 * Meanwhile, the security system for these houses remain the same as for those in the previous street.
 * Given a list of non-negative integers representing the amount of money of each house,
 * determine the maximum amount of money you can rob tonight without alerting the police.
 */
public class HouseRobber2 {
    // Time: O(n) Space: O(1)
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        return Math.max(robRow(nums, 0, n-2), robRow(nums, 1, n-1));
    }

    private int robRow(int[] nums, int start, int end) {
        int prevTaken = 0;
        int prevSkipped = 0;
        for (int i = start; i <= end; i++) {
            int num = nums[i];
            int takeCurrent = prevSkipped + num;
            int skipCurrent = Math.max(prevTaken, prevSkipped);
            prevTaken = takeCurrent;
            prevSkipped = skipCurrent;
        }
        return Math.max(prevTaken, prevSkipped);
    }

    public static void main(String[] args){
        HouseRobber2 instance = new HouseRobber2();
        System.out.println(instance.rob(new int[]{6, 5, 1, 2, 1, 8, 1}));
        System.out.println(instance.rob(new int[]{2, 7, 9, 3, 1}));
    }
}
