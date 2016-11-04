package self;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an array of integers, find if the array contains any duplicates.
 * Your function should return true if any value appears at least twice in the array,
 * and it should return false if every element is distinct.
 */
public class ContainsDuplicate {
    // m = unique numbers. Time: O(n) Space: O(m)
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> numSet = new HashSet<Integer>();
        for (int n : nums) {
            if (numSet.contains(n)) {
                return true;
            } else {
                numSet.add(n);
            }
        }
        return false;
    }

    public static void main(String[] args){
        ContainsDuplicate instance = new ContainsDuplicate();
        int[] input = new int[]{1, 2, 3, 4};
        System.out.println(instance.containsDuplicate(input));
    }
}
