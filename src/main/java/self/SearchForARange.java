package self;

import java.util.Arrays;

/**
 * Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * If the target is not found in the array, return [-1, -1].
 */
public class SearchForARange {
    // Time: O(logn) Space: O(1)
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        if (nums == null || nums.length == 0) {
            return result;
        }
        int first = find(nums, target);
        if (first >= nums.length || nums[first] != target) {
            return result;
        }
        int last = find(nums, target + 1) - 1;
        result[0] = first;
        result[1] = last;
        return result;

    }

    // find index of first number greater than or equal to target
    private int find(int[] nums, int target) {
        int lo = 0, hi = nums.length;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    public static void main(String[] args){
        SearchForARange instance = new SearchForARange();
        System.out.println(Arrays.toString(instance.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
    }
}
