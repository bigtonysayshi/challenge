package self;

/**
 * Given a binary array, find the maximum number of consecutive 1s in this array if you can flip at most one 0.
 * Note: The input array will only contain 0 and 1.
 * The length of input array is a positive integer and will not exceed 10,000
 * Follow up:
 * What if the input numbers come in one by one as an infinite stream?
 * In other words, you can't store all numbers coming from the stream as it's too large to hold in memory.
 * Could you solve it efficiently?
 */
public class MaxConsecutiveOnes2 {
    // Time: O(n) Space: O(1)
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0, prev = -1;
        for (int lo = 0, hi = 0; hi < nums.length; hi++) {
            if (nums[hi] == 0) {
                lo = prev + 1;
                prev = hi;
            }
            maxCount = Math.max(maxCount, hi - lo + 1);
        }
        return maxCount;
    }

    public static void main(String[] args){
        MaxConsecutiveOnes2 instance = new MaxConsecutiveOnes2();
        System.out.println(instance.findMaxConsecutiveOnes(new int[]{}));
        System.out.println(instance.findMaxConsecutiveOnes(new int[]{0}));
        System.out.println(instance.findMaxConsecutiveOnes(new int[]{1}));
        System.out.println(instance.findMaxConsecutiveOnes(new int[]{1,0,1,1,0}));
    }
}
