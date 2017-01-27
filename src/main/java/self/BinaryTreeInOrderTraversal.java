package self;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the inorder traversal of its nodes' values.
 */
public class BinaryTreeInOrderTraversal {
    // Iterative
    // Time: O(n) Space: O(n)
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> vals = new ArrayList<>();
        Stack<TreeNode> nodeStack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !nodeStack.empty()) {
            while (curr != null) {
                nodeStack.push(curr);
                curr = curr.left;
            }
            curr = nodeStack.pop();
            vals.add(curr.val);
            curr = curr.right;

        }
        return vals;
    }

    // Recursive
    // Time: O(n) Space: O(logn)
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> vals = new ArrayList<>();
        traversalHelper(root, vals);
        return vals;
    }

    private void traversalHelper(TreeNode node, List<Integer> vals) {
        if (node != null) {
            traversalHelper(node.left, vals);
            vals.add(node.val);
            traversalHelper(node.right, vals);
        }
    }
}
