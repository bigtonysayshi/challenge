package self;

/**
 * Given an array of n positive integers and a positive integer s,
 * find the minimal length of a subarray of which the sum ≥ s.
 * If there isn't one, return -1 instead.
 */
public class MinimumSizeSubarraySum {
    // Time: O(n) Space: O(1)
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int minSize = 0;
        int sum = 0;
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            while (sum < s && j < nums.length) {
                sum += nums[j++];
            }
            if (sum < s) {
                break;
            }
            int len = j - i;
            if (minSize == 0 || len < minSize) {
                minSize = len;
            }
            sum -= nums[i];
        }
        return minSize;
    }

    public static void main(String[] args){
        MinimumSizeSubarraySum instance = new MinimumSizeSubarraySum();
        System.out.println(instance.minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
    }
}
