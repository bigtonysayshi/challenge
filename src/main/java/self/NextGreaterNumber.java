package self;

import java.util.*;

/**
 * Given a circular array (the next element of the last element is the first element of the array),
 * print the Next Greater Number for every element.
 * The Next Greater Number of a number x is the first greater number to its traversing-order next in the array,
 * which means you could search circularly to find its next greater number.
 * If it doesn't exist, output -1 for this number.
 */
public class NextGreaterNumber {
    // Time: O(n^2) Space: O(n)
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] results = new int[n];
        Arrays.fill(results, -1);
        Stack<Integer> waitList = new Stack<>();
        for (int i = 0; i < n * 2; i++) {
            int num = nums[i % n];
            while (!waitList.empty() && nums[waitList.peek()] < num) {
                results[waitList.pop()] = num;
            }
            if (i < n) waitList.push(i);
        }
        return results;
    }

    public static void main(String[] args){
        NextGreaterNumber instance = new NextGreaterNumber();
        System.out.println(Arrays.toString(instance.nextGreaterElements(new int[]{1,2,1})));
        System.out.println(Arrays.toString(instance.nextGreaterElements(new int[]{3,3,6,2,4,5,1,3})));
    }
}
