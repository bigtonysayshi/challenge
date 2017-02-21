package self;

/**
 * Given a non-empty array containing only positive integers, find if the array can be partitioned
 * into two subsets such that the sum of elements in both subsets is equal.
 */
public class PartitionEqualSubsetSum {
    // Time: O(nS) Space: O(S)
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int n : nums) sum += n;
        if (sum % 2 != 0) return false;
        int target = sum / 2;
        boolean[] sums = new boolean[target+1];
        sums[0] = true;
        for (int n : nums) {
            for (int i = sums.length-1; i >= 0; i--) {
                if (i - n >= 0) {
                    sums[i] = sums[i] || sums[i-n];
                }
            }
        }
        return sums[target];
    }

    public static void main(String[] args){
        PartitionEqualSubsetSum instance = new PartitionEqualSubsetSum();
        System.out.println(instance.canPartition(new int[]{1,5,11,5}));
        System.out.println(instance.canPartition(new int[]{1,2,3,5}));
        System.out.println(instance.canPartition(new int[]{1,2,5}));
    }
}
