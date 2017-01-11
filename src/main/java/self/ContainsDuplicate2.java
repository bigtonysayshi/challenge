package self;

import java.util.HashSet;

/**
 * Given an array of integers and an integer k,
 * find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j]
 * and the absolute difference between i and j is at most k.
 */
public class ContainsDuplicate2 {
    // Time: O(n) Space: O(k)
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> window = new HashSet<>();
        for (int i = 0; i <= k; i++) {
            if (i >= nums.length) break;
            if (!window.add(nums[i])) return true;
        }
        for (int i = 0; i + k + 1< nums.length; i++) {
            window.remove(nums[i]);
            if (!window.add(nums[i+k+1])) return true;
        }
        return false;
    }

    public static void main(String[] args){
        ContainsDuplicate2 instance = new ContainsDuplicate2();
        int[] input = new int[]{1, 10, 1, 4};
        System.out.println(instance.containsNearbyDuplicate(input, 1));
        System.out.println(instance.containsNearbyDuplicate(input, 2));
    }
}
