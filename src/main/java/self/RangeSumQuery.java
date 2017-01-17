package self;

/**
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j),
 * inclusive.
 * Note:
 * You may assume that the array does not change.
 * There are many calls to sumRange function
 */
public class RangeSumQuery {
    public static void main(String[] args){
        int[] nums = new int[]{-2, 0, 3, -5, 2, -1};
        NumArray numArray = new NumArray(nums);
        System.out.println(numArray.sumRange(0,2));
        System.out.println(numArray.sumRange(2,5));
        System.out.println(numArray.sumRange(0,5));
    }
}


// Initialization O(n)
// Query Time: O(1) Space:O(n)
class NumArray {
    private int[] sums;

    public NumArray(int[] nums) {
        int n = nums.length;
        sums = new int[n];
        if (n > 0) sums[0] = nums[0];
        for (int i = 1; i < n; i++) {
            sums[i] = sums[i-1] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        if (i < 0) i = 0;
        if (j > sums.length - 1) j = sums.length - 1;
        if (j < i) return 0;

        return sums[j] - (i == 0 ? 0 : sums[i-1]);
    }
}