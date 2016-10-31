package self;

/**
 * Given an array of integers, every element appears twice except for one.
 * Find that single one.
 * Your algorithm should have a linear runtime complexity.
 * Could you implement it without using extra memory?
 */
public class SingleNumber {
    // Time: O(n) Space: O(1)
    public int singleNumber(int[] nums) {
        int single = 0;
        for (int n : nums) {
            single ^= n;
        }
        return single;
    }

    public static void main(String[] args){
        SingleNumber instance = new SingleNumber();
        int[] input = new int[]{1, 1, 2, 2, 3, 4, 4};
        System.out.println(instance.singleNumber(input));
    }
}
