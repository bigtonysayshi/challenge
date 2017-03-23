package self;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * Write a function to determine if a given target is in the array.
 * The array may contain duplicates.
 */
public class SearchInRotatedSortedArray2 {
    // Time: O(logn) Space: O(1)
    public boolean search(int[] nums, int target) {
        if (nums.length == 0) return false;
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int val = nums[mid];
            if (val == target) return true;
            if (nums[lo] < val) {
                if (nums[lo] <= target && val > target) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else if (nums[lo] > val) {
                if (val < target && nums[hi] >= target) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            } else {
                lo++;
            }
        }
        return nums[lo] == target;
    }

    public static void main(String[] args){
        SearchInRotatedSortedArray2 instance = new SearchInRotatedSortedArray2();
        System.out.println(instance.search(new int[]{4,5,6,7,0,1,2}, 6));
        System.out.println(instance.search(new int[]{4,4,4,7,0,1,1}, 1));
        System.out.println(instance.search(new int[]{1,3,1,1,1}, 3));
        System.out.println(instance.search(new int[]{1,3,1,1,1}, 2));
        System.out.println(instance.search(new int[]{1,3,5}, 1));
    }
}
