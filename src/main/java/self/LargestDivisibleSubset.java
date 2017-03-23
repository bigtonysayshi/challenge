package self;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj)
 * of elements in this subset satisfies: Si % Sj = 0 or Sj % Si = 0.
 * If there are multiple solutions, return any subset is fine.
 */
public class LargestDivisibleSubset {
    // Time: O(n^2) Space: O(n)
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        List<Integer> results = new ArrayList<>();
        if (n == 0) return results;
        Arrays.sort(nums);
        int[] maxSizes = new int[n];
        int[] roots = new int[n];
        maxSizes[0] = 1;
        roots[0] = 0;
        int globalMax = 1, globalMaxIdx = 0;
        for (int i = 1; i < n; i++) {
            int maxSize = 1;
            roots[i] = i;
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && maxSizes[j] + 1 > maxSize) {
                    maxSize = maxSizes[j] + 1;
                    roots[i] = j;
                }
            }
            maxSizes[i] = maxSize;
            if (maxSize > globalMax) {
                globalMax = maxSize;
                globalMaxIdx = i;
            }
        }
        int idx = globalMaxIdx;
        while (roots[idx] != idx) {
            results.add(nums[idx]);
            idx = roots[idx];
        }
        results.add(nums[idx]);
        return results;
    }

    public static void main(String[] args){
        LargestDivisibleSubset instance = new LargestDivisibleSubset();
        System.out.println(instance.largestDivisibleSubset(new int[]{1,2,3}));
        System.out.println(instance.largestDivisibleSubset(new int[]{1,2,4,8}));
        System.out.println(instance.largestDivisibleSubset(new int[]{4,8,10,240}));
    }
}
