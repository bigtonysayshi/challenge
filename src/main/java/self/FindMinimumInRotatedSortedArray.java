package self;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * Find the minimum element.
 * You may assume no duplicate exists in the array.
 */
public class FindMinimumInRotatedSortedArray {
    // Time: O(logn) Space: O(1)
    public int findMin(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            if (nums[lo] < nums[hi]) return nums[lo];
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] >= nums[lo]) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return nums[lo];
    }

    public static void main(String[] args){
        FindMinimumInRotatedSortedArray instance = new FindMinimumInRotatedSortedArray();
        System.out.println(instance.findMin(new int[]{2,1}));
        System.out.println(instance.findMin(new int[]{4,5,6,7,0,1,2}));
    }
}
