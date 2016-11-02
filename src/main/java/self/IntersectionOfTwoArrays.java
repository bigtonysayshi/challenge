package self;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Given two arrays, write a function to compute their intersection.
 * Example:Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
 * Each element in the result must be unique.
 * The result can be in any order.
 */
public class IntersectionOfTwoArrays {
    // n = max length of nums1 and nums2. Time: O(n) Space: O(n)
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> numSet = new HashSet<Integer>();
        for (int i : nums1) {
            numSet.add(i);
        }
        Set<Integer> resultSet = new HashSet<Integer>();
        for (int j : nums2) {
            if (numSet.contains(j)) {
                resultSet.add(j);
            }
        }

        int[] results = new int[resultSet.size()];
        int idx = 0;
        for (int n : resultSet) {
            results[idx++] = n;
        }
        return results;
    }

    public static void main(String[] args){
        IntersectionOfTwoArrays instance = new IntersectionOfTwoArrays();
        int[] input1 = new int[]{1, 2, 2, 1};
        int[] input2 = new int[]{2, 2};
        System.out.println(Arrays.toString(instance.intersection(input1, input2)));
    }
}
