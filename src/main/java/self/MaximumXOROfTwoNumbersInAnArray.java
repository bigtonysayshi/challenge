package self;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a non-empty array of numbers, a0, a1, a2, … , an-1, where 0 ≤ ai < 2^31.
 * Find the maximum result of ai XOR aj, where 0 ≤ i, j < n.
 * Could you do this in O(n) runtime?
 */
public class MaximumXOROfTwoNumbersInAnArray {
    // Time: O(n) Space: O(n)
    public int findMaximumXOR(int[] nums) {
        int maxVal = 0, mask = 0;
        for (int i = 31; i >= 0; i--) {
            mask |= (1 << i);
            Set<Integer> prefixSet = new HashSet<>();
            for (int n : nums) {
                prefixSet.add(n & mask);
            }
            int tmp = maxVal | (1 << i);
            for (int prefix : prefixSet) {
                if (prefixSet.contains(tmp ^ prefix)) {
                    maxVal = tmp;
                    break;
                }
            }
        }
        return maxVal;
    }

    public static void main(String[] args){
        MaximumXOROfTwoNumbersInAnArray instance = new MaximumXOROfTwoNumbersInAnArray();
        System.out.println(instance.findMaximumXOR(new int[]{3, 10, 5, 25, 2, 8}));
    }
}
