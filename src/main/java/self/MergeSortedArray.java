package self;

import java.util.Arrays;

/**
 *Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * Note: You may assume that nums1 has enough space (size that is greater or equal to m + n) to
 * hold additional elements from nums2.
 * The number of elements initialized in nums1 and nums2 are m and n respectively.
 */
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m+n-1, idx1 = m-1, idx2 = n-1;
        while (idx1 >= 0 && idx2 >= 0) {
            nums1[i--] = nums1[idx1] > nums2[idx2] ? nums1[idx1--] : nums2[idx2--];
        }
        if (idx1 < 0) {
            while (idx2 >= 0) {
                nums1[i--] = nums2[idx2--];
            }
        }
    }

    public static void main(String[] args){
        MergeSortedArray instance = new MergeSortedArray();
        int[] input1 = new int[]{1, 2, 4, 6, 0, 0, 0, 0, 0};
        int[] input2 = new int[]{1, 3, 3, 8};
        instance.merge(input1, 4, input2, 4);
        System.out.println(Arrays.toString(input1));
    }
}
