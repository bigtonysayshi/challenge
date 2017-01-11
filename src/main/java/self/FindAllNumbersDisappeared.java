package self;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array),
 * some elements appear twice and others appear once.
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 * Could you do it without extra space and in O(n) runtime?
 * You may assume the returned list does not count as extra space.
 */
public class FindAllNumbersDisappeared {
    // Time: O(n) Space: O(n)
    public List<Integer> findDisappearedNumbers(int[] nums) {
        boolean[] appeared = new boolean[nums.length];
        for (int n : nums) {
            appeared[n - 1] = true;
        }
        List<Integer> disappearedNumbers = new ArrayList<>();
        for (int i = 1; i <= nums.length; i++) {
            if (!appeared[i - 1]) disappearedNumbers.add(i);
        }
        return disappearedNumbers;
    }

    public static void main(String[] args){
        FindAllNumbersDisappeared instance = new FindAllNumbersDisappeared();
        int[] input = new int[]{4,3,2,7,8,2,3,1};
        System.out.println(instance.findDisappearedNumbers(input));
    }
}
