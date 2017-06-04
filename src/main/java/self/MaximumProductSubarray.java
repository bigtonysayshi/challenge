package self;

/**
 * Find the contiguous subarray within an array (containing at least one number) which has the largest product.
 */
public class MaximumProductSubarray {
    // Time: O(n) Space: O(1)
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int n = nums.length;
        int maxProd = nums[0];
        int minProd = nums[0];
        int result = maxProd;
        for (int i = 1; i < n; i++) {
            int num = nums[i];
            int prod1 = maxProd * num;
            int prod2 = minProd * num;
            maxProd = Math.max(Math.max(prod1, prod2), num);
            minProd = Math.min(Math.min(prod1, prod2), num);
            result = Math.max(result, maxProd);
        }
        return result;
    }

    public static void main(String[] args){
        MaximumProductSubarray instance = new MaximumProductSubarray();
        System.out.println(instance.maxProduct(new int[]{2,3,-2,4}));
    }
}
