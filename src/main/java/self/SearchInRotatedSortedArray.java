package self;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * You may assume no duplicate exists in the array.
 */
public class SearchInRotatedSortedArray {
    // Time: O(logn) Space: O(1)
    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int val = nums[mid];
            if (val == target) return mid;
            if (nums[lo] <= val) {
                if (nums[lo] <= target && val > target) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else {
                if (val < target && nums[hi] >= target) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }
        return nums[lo] == target ? lo : -1;
    }

    public static void main(String[] args){
        SearchInRotatedSortedArray instance = new SearchInRotatedSortedArray();
        System.out.println(instance.search(new int[]{4,5,6,7,0,1,2}, 6));
        System.out.println(instance.search(new int[]{4,5,6,7,0,1,2}, 3));
        System.out.println(instance.search(new int[]{1,3}, 3));
        System.out.println(instance.search(new int[]{1,3,5}, 1));
    }
}
