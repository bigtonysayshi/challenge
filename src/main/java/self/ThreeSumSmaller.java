package self;

import java.util.*;

/**
 * Given an array of n integers nums and a target, find the number of index triplets i, j, k
 * with 0 <= i < j < k < n that satisfy the condition nums[i] + nums[j] + nums[k] < target.
 */
public class ThreeSumSmaller {
    // Time: O(n^2) Space: O(1)
    public int threeSumSmaller(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        int counts = 0;
        for (int i = 0; i < n; i++) {
            counts += twoSumSmaller(nums, i+1, target - nums[i]);
        }
        return counts;
    }

    private int twoSumSmaller(int[] nums, int start, int target) {
        int left = start, right = nums.length - 1, count = 0;
        while (left < right) {
            if (nums[left] + nums[right] >= target) {
                right--;
            } else {
                count+= right - left;
                left++;
            }
        }
        return count;
    }

    public static void main(String[] args){
        ThreeSumSmaller instance = new ThreeSumSmaller();
        System.out.println(instance.threeSumSmaller(new int[]{-2,0,1,3}, 2));
    }
}
