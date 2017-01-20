package self;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array),
 * some elements appear twice and others appear once.
 * Find all the elements that appear twice in this array.
 * Could you do it without extra space and in O(n) runtime?
 */
public class FindAllDuplicatesInAnArray {
    // Time: O(n) Space:O(n)
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> duplicates = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int n = Math.abs(nums[i]);
            if (nums[n-1] < 0) {
                duplicates.add(n);
            } else {
                nums[n-1] *= -1;
            }
        }
        return duplicates;
    }

    public static void main(String[] args){
        FindAllDuplicatesInAnArray instance = new FindAllDuplicatesInAnArray();
        int[] input = new int[]{4,3,2,7,8,2,3,1};
        System.out.println(instance.findDuplicates(input));
    }
}
