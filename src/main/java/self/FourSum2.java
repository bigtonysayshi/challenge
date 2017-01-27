package self;

import java.util.HashMap;
import java.util.Map;

/**
 * Given four lists A, B, C, D of integer values,
 * compute how many tuples (i, j, k, l) there are such that A[i] + B[j] + C[k] + D[l] is zero.
 * To make problem a bit easier, all A, B, C, D have same length of N where 0 ≤ N ≤ 500.
 * All integers are in the range of -228 to 228 - 1 and the result is guaranteed to be at most 231 - 1.
 */
public class FourSum2 {
    // Time: O(n^2) Space: O(n^2)
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int tuples = 0;
        Map<Integer, Integer> remMap = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int rem = -(A[i] + B[j]);
                remMap.put(rem, remMap.getOrDefault(rem, 0) + 1);
            }
        }
        for (int k = 0; k < C.length; k++) {
            for (int l = 0; l < D.length; l++) {
                int sum = C[k] + D[l];
                tuples += remMap.getOrDefault(sum, 0);
            }
        }
        return tuples;
    }

    public static void main(String[] args){
        FourSum2 instance = new FourSum2();
        int[] A = new int[]{1,2};
        int[] B = new int[]{-2,-1};
        int[] C = new int[]{-1,2};
        int[] D = new int[]{0,2};
        System.out.println(instance.fourSumCount(A,B,C,D));
    }
}
