package self;

import java.util.Arrays;

/**
 * Assume you have an array of length n initialized with all 0's and are given k update operations.
 * Each operation is represented as a triplet: [startIndex, endIndex, inc] which increments
 * each element of subarray A[startIndex ... endIndex] (startIndex and endIndex inclusive) with inc.
 * Return the modified array after all k operations were executed.
 */
public class RangeAddition {
    // Set val at start idx, and minus val at end+1 idx
    // Time: O(n+k) Space: O(n)
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] results = new int[length];
        for (int i = 0; i < updates.length; i++) {
            int[] update = updates[i];
            int start = update[0], end = update[1], val = update[2];
            results[start] += val;
            if (end < length - 1) {
                results[end+1] -=val;
            }
        }
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += results[i];
            results[i] = sum;
        }
        return results;
    }

    public static void main(String[] args){
        int[][] updates = new int[][]{
                {1, 3, 2},
                {2, 4, 3},
                {0, 2, -2}
        };
        RangeAddition instance = new RangeAddition();
        System.out.println(Arrays.toString(instance.getModifiedArray(5, updates)));
    }
}
