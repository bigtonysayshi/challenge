package self;

import java.util.Stack;

/**
 * Implement an iterator over a binary search tree (BST).
 * Your iterator will be initialized with the root node of a BST.
 * Calling next() will return the next smallest number in the BST.
 * Note:
 * next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
 */
public class BinarySearchTreeIterator {
    Stack<TreeNode> stack;
    TreeNode current;
    public BinarySearchTreeIterator(TreeNode root) {
        stack = new Stack<>();
        current = root;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return current != null || !stack.empty();
    }

    /** @return the next smallest number */
    public int next() {
        int val = 0;
        if (hasNext()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            val = current.val;
            current = current.right;
        }
        return val;
    }
}
