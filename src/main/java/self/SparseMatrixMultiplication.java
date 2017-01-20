package self;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given two sparse matrices A and B, return the result of AB.
 * You may assume that A's column number is equal to B's row number.
 */
public class SparseMatrixMultiplication {
    // Time: O(mnk) Space: O(mk)
    public int[][] multiply(int[][] A, int[][] B) {
        int m = A.length;
        int n = B.length;
        int k = B[0].length;
        int[][] product = new int[m][k];

        for (int i = 0; i < m; i++) {
            for (int l = 0; l < n; l++) {
                if (A[i][l] != 0) {
                    for (int j = 0; j < k; j++) {
                        product[i][j] += A[i][l] * B[l][j];
                    }
                }
            }
        }
        return product;
    }
}
