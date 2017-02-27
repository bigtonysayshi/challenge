package self;

import java.util.Arrays;

/**
 * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
 * For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.
 */
public class PerfectSquares {
    // Time: O(n*sqrt(n)) Space: O(n)
    public int numSquares(int n) {
        int[] minSquares = new int[n+1];
        Arrays.fill(minSquares, Integer.MAX_VALUE);
        minSquares[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                minSquares[i] = Math.min(minSquares[i], minSquares[i - j * j] + 1);
            }
        }
        return minSquares[n];
    }

    public static void main(String[] args){
        PerfectSquares instance = new PerfectSquares();
        System.out.println(instance.numSquares(12));
    }
}
