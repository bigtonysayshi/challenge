package self;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice.
 * Find the two elements that appear only once.
 * Note:
 * The order of the result is not important. So in the above example, [5, 3] is also correct.
 * Your algorithm should run in linear runtime complexity.
 * Could you implement it using only constant space complexity?
 */
public class SingleNumber3 {
    // Time: O(n) Space: O(1)
    public int[] singleNumber(int[] nums) {
        // diffBits is XOR result of the two unique numbers
        int diffBits = 0;
        for (int n : nums) {
            diffBits ^= n;
        }
        int mask = 1;
        while ((diffBits & mask) != mask) {
            mask <<= 1;
        }
        // Divide into two groups, one group of numbers with the mask bit set, the other group not set.
        // the two unique numbers must be in different groups.
        int num1 = 0, num2 = 0;
        for (int n : nums) {
            if ((n & mask) == mask) {
                num1 ^= n;
            } else {
                num2 ^= n;
            }
        }
        return new int[]{num1, num2};
    }

    public static void main(String[] args){
        SingleNumber3 instance = new SingleNumber3();
        int[] input = new int[]{1, 1, 2, 2, 3, 4, 4, 5};
        System.out.println(Arrays.toString(instance.singleNumber(input)));
    }
}
