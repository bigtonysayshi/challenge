package self;

import java.util.Arrays;

/**
 * Given an array of integers that is already sorted in ascending order,
 * find two numbers such that they add up to a specific target number.
 * The function twoSum should return indices of the two numbers such that they add up to the target,
 * where index1 must be less than index2.
 * Please note that your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution.
 */
public class TwoSum2 {
    // Time: O(n) Space: O(1)
    public int[] twoSum(int[] numbers, int target) {
        int i = 0, j = numbers.length - 1;
        while (i < j - 1) {
            int left = numbers[i], right = numbers[j];
            if (left + right == target) {
                return new int[]{i+1,j+1};
            } else if (left + right > target) {
                j--;
            } else {
                i++;
            }
        }
        return new int[]{i+1,j+1};
    }

    public static void main(String[] args){
        TwoSum2 instance = new TwoSum2();
        System.out.println(Arrays.toString(instance.twoSum(new int[]{0,0,3,4}, 0)));
    }
}
