package self;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of size n, find the majority element.
 * The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * You may assume that the array is non-empty and the majority element always exist in the array.
 */
public class MajorityElement {
    // m = unique numbers. Time: O(n) Space: O(m)
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> freq= new HashMap<Integer, Integer>();
        int size = nums.length;
        for (int n : nums) {
            int count = freq.containsKey(n) ? freq.get(n) : 0;
            if ((count + 1) * 2 >= size) {
                return n;
            }
            freq.put(n, count + 1);
        }
        return nums[size - 1];
    }

    // Time: O(n) Space: O(1). Smart algorithm!
    public int majorityElement2(int[] nums) {
        int major=nums[0], count = 1;
        for(int i=1; i<nums.length;i++){
            if(count==0){
                count++;
                major=nums[i];
            }else if(major==nums[i]){
                count++;
            }else count--;

        }
        return major;
    }

    public static void main(String[] args){
        MajorityElement instance = new MajorityElement();
        int[] input = new int[]{1, 2, 3, 3, 2, 3};
        System.out.println(instance.majorityElement2(input));
    }
}
