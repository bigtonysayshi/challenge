package self;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.
 * Note: The length of the given binary array will not exceed 50,000.
 */
public class ContiguousArray {
    // Time: O(n) Space: O(n)
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> balanceIdxMap = new HashMap<>();
        balanceIdxMap.put(0, -1);
        int balance = 0, maxLen = 0;
        for (int i = 0 ; i< nums.length; i++) {
            balance += nums[i] == 1 ? 1 : -1;
            if (balanceIdxMap.containsKey(balance)) {
                maxLen = Math.max(maxLen, i - balanceIdxMap.get(balance));
            } else {
                balanceIdxMap.put(balance, i);
            }
        }
        return maxLen;
    }

    public static void main(String[] args){
        ContiguousArray instance = new ContiguousArray();
        System.out.println(instance.findMaxLength(new int[]{0,1}));
        System.out.println(instance.findMaxLength(new int[]{0,1,0}));
    }
}
