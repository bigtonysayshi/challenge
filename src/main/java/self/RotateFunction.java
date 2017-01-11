package self;

/**
 * Given an array of integers A and let n to be its length.
 * Assume Bk to be an array obtained by rotating the array A k positions clock-wise,
 * we define a "rotation function" F on A as follow:
 * F(k) = 0 * Bk[0] + 1 * Bk[1] + ... + (n-1) * Bk[n-1].
 * Calculate the maximum value of F(0), F(1), ..., F(n-1).
 * Note: n is guaranteed to be less than 105.
 */
public class RotateFunction {
    // Time: O(n) Space:O(1)
    // F(k) = F(k-1) + sum - nBk[0]
    public int maxRotateFunction(int[] A) {
        int n = A.length;
        int sum = 0, F = 0, maxSum = 0;
        for (int i = 0; i < n; i++) {
            sum += A[i];
            F += i * A[i];
        }
        maxSum = F;
        for (int k = 1; k < n; k++) {
            F = F + sum - n * A[n - k];
            maxSum = Math.max(maxSum, F);
        }
        return maxSum;
    }

    public static void main(String[] args){
        RotateFunction instance = new RotateFunction();
        System.out.println(instance.maxRotateFunction(new int[]{}));
        System.out.println(instance.maxRotateFunction(new int[]{4, 3, 2, 6}));
        System.out.println(instance.maxRotateFunction(new int[]{-2147483648,-2147483648}));
    }
}
