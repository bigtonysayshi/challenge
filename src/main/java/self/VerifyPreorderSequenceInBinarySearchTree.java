package self;

import java.util.Stack;

/**
 * Given an array of numbers, verify whether it is the correct preorder traversal sequence of a binary search tree.
 * You may assume each number in the sequence is unique.
 * Follow up: Could you do it using only constant space complexity?
 */
public class VerifyPreorderSequenceInBinarySearchTree {
    // Time: O(n) Space: O(n)
    public boolean verifyPreorder(int[] preorder) {
        Stack<Integer> stack = new Stack<>();
        int low = Integer.MIN_VALUE;
        for (int n : preorder) {
            if (n < low) return false;
            while (!stack.empty() && n > stack.peek()) low = stack.pop();
            stack.push(n);
        }
        return true;
    }

    public static void main(String[] args){
        VerifyPreorderSequenceInBinarySearchTree instance = new VerifyPreorderSequenceInBinarySearchTree();
        System.out.println(instance.verifyPreorder(new int[]{2,3,1}));
        System.out.println(instance.verifyPreorder(new int[]{5,1,3,4,6,8,7}));
        System.out.println(instance.verifyPreorder(new int[]{5,3,1,4,6,8,7}));
    }
}
