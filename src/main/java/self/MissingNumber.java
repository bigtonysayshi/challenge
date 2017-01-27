package self;

/**
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n,
 * find the one that is missing from the array.
 * Note:
 * Your algorithm should run in linear runtime complexity.
 * Could you implement it using only constant extra space complexity?
 */
public class MissingNumber {
    // Time: O(n) Space: O(1)
    public int missingNumber(int[] nums) {
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing ^= i;
            missing ^= nums[i];
        }
        return missing;
    }

    public static void main(String[] args){
        MissingNumber instance = new MissingNumber();
        System.out.println(instance.missingNumber(new int[]{0,1,3}));
        System.out.println(instance.missingNumber(new int[]{2,1,3}));
        System.out.println(instance.missingNumber(new int[]{2,1,0}));
    }
}
