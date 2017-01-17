package self;

import java.util.Arrays;

/**
 * A sequence of number is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.
 * A zero-indexed array A consisting of N numbers is given. A slice of that array is any pair of integers (P, Q) such that 0 <= P < Q < N.
 * A slice (P, Q) of array A is called arithmetic if the sequence:
 * A[P], A[p + 1], ..., A[Q - 1], A[Q] is arithmetic. In particular, this means that P + 1 < Q.
 * The function should return the number of arithmetic slices in the array A.
 */
public class ArithmeticSlices {
    // Time: O(n) Space: O(1)
    public int numberOfArithmeticSlices(int[] A) {
        if (A.length <= 2) return 0;
        int count = 0, streak = 1, currentDiff = A[1] - A[0];
        for (int i = 2; i < A.length; i++) {
            int diff = A[i] - A[i-1];
            if (diff == currentDiff) {
                streak++;
            } else {
                currentDiff = diff;
                count += streak * (streak - 1) / 2;
                streak = 1;
            }
        }
        count += streak * (streak - 1) / 2;
        return count;
    }

    public static void main(String[] args){
        int[] input = new int[]{1, 1, 1, 2, 3, 4, 7, 8};
        ArithmeticSlices instance = new ArithmeticSlices();
        System.out.println(instance.numberOfArithmeticSlices(input));
    }
}
