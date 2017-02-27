package self;

/**
 * A sequence of numbers is called a wiggle sequence if the differences between successive numbers
 * strictly alternate between positive and negative. The first difference (if one exists) may be
 * either positive or negative. A sequence with fewer than two elements is trivially a wiggle sequence.
 * Given a sequence of integers, return the length of the longest subsequence that is a wiggle sequence.
 * A subsequence is obtained by deleting some number of elements (eventually, also zero) from the
 * original sequence, leaving the remaining elements in their original order.
 */
public class WiggleSubsequence {
    // Time: O(n) Space: O(1)
    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2) return nums.length;
        int diff = nums[1] - nums[0];
        int maxLen = diff == 0 ? 1 : 2;
        for (int i = 2; i < nums.length; i++) {
            int newDiff = nums[i] - nums[i-1];
            if ((newDiff > 0 && diff <= 0) || (newDiff < 0 && diff >= 0)) {
                diff = newDiff;
                maxLen++;
            }
        }
        return maxLen;
    }

    public static void main(String[] args){
        WiggleSubsequence instance = new WiggleSubsequence();
        System.out.println(instance.wiggleMaxLength(new int[]{1,7,4,9,2,5}));
        System.out.println(instance.wiggleMaxLength(new int[]{1,17,5,10,13,15,10,5,16,8}));
        System.out.println(instance.wiggleMaxLength(new int[]{1,2,3,4,5,6,7,8,9}));
    }
}
