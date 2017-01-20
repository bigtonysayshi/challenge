package self;

import java.util.Arrays;

/**
 * Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
 * Solve it without division and in O(n).
 * Could you solve it with constant space complexity? (Note: The output array does not count as extra space for the purpose of space complexity analysis.)
 */
public class ProductOfArrayExceptSelf {
    // Time: O(n) Space: O(1)
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] products = new int[n];
        products[0] = 1;
        for (int i = 1; i < n; i++) {
            products[i] = products[i-1] * nums[i-1];
        }
        int tmp = 1;
        for (int i = n - 1; i >= 0; i--) {
            products[i] *= tmp;
            tmp *= nums[i];
        }
        return products;
    }

    public static void main(String[] args){
        ProductOfArrayExceptSelf instance = new ProductOfArrayExceptSelf();
        System.out.println(Arrays.toString(instance.productExceptSelf(new int[]{1,2,3,4})));
    }
}
