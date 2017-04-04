package self;

/**
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 */
public class MaximumSubarray {
    // Time: O(n) Space: O(1)
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int maxSum = nums[0];
        int currentSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }

    public static void main(String[] args){
        MaximumSubarray instance = new MaximumSubarray();
        System.out.println(instance.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println(instance.maxSubArray(new int[]{-2, -1}));
    }
}
