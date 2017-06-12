package self;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * Given an array with n integers, you need to find if there are triplets (i, j, k) which satisfies following conditions:
 * 0 < i, i + 1 < j, j + 1 < k < n - 1
 * Sum of subarrays (0, i - 1), (i + 1, j - 1), (j + 1, k - 1) and (k + 1, n - 1) should be equal.
 * where we define that subarray (L, R) represents a slice of the original array starting from the element indexed L to the element indexed R.
 * Note:
 * 1 <= n <= 2000.
 * Elements in the given array will be in range [-1,000,000, 1,000,000].
 */
public class SplitArrayWithEqualSum {
    // Time: O(n^2) Space: O(n)
    public boolean splitArray(int[] nums) {
        if (nums == null || nums.length < 7) {
            return false;
        }
        int n = nums.length;
        int[] preSums = new int[n];
        preSums[0] = nums[0];
        for (int i = 1; i < n; i++) {
            preSums[i] = preSums[i - 1] + nums[i];
        }

        for (int j = 3; j < n - 3; j++) {
            HashSet<Integer> targets = new HashSet<>();
            for (int i = 1; i < j - 1; i++) {
                if (preSums[i - 1] == preSums[j - 1] - preSums[i]) {
                    targets.add(preSums[i - 1]);
                }
            }
            for (int k = j + 2; k < n - 1; k++) {
                if (preSums[k - 1] - preSums[j] == preSums[n - 1] - preSums[k] && targets.contains(preSums[k - 1] - preSums[j])) {
                    return true;
                }
            }
        }
        return false;
    }


    public static void main(String[] args){
        SplitArrayWithEqualSum instance = new SplitArrayWithEqualSum();
        System.out.println(instance.splitArray(new int[]{1, 2, 1, 2, 1, 2, 1}));
        System.out.println(instance.splitArray(new int[]{1, 2, 1, 2, 1, 2, 2}));
        System.out.println(instance.splitArray(new int[]{1,2,1,3,0,0,2,2,1,3,3}));
    }
}
